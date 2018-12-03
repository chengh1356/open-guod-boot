package cn.hacz.edu.hql;

import cn.hacz.edu.mapping.admin.SysDep;
import cn.hacz.edu.mapping.admin.SysMenu;
import cn.hacz.edu.mapping.admin.SysRole;
import cn.hacz.edu.mapping.admin.SysUser;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/29 时间:13:10
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
@Transactional(rollbackFor = RuntimeException.class)
public class HibernateHQL03 {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 功能描述：获取session
     */
    public Session getSessionUnwrap() {
        return entityManager.unwrap(Session.class);
    }


    /**
     * 功能描述：初始化数据（导航->双向Get关联->）
     */
    public void doInit() {
        // 01部门
        SysDep sysDep = new SysDep();
        sysDep.setName("技术开发部");
        // 02用户
        SysUser sysUser = new SysUser();
        sysUser.setUserName("超级管理员");
        // 03角色
        List<SysRole> roles = new ArrayList<>();
        // 04菜单
        List<SysMenu> menus = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SysMenu sysMenu = new SysMenu();
            sysMenu.setName("菜单" + i);
            menus.add(sysMenu);
        }
        for (int i = 0; i < 10; i++) {
            SysRole sysRole = new SysRole();
            sysRole.setName("角色" + i);
            roles.add(sysRole);
            sysRole.setMenus(new HashSet<>(menus));
        }
        // 双向Get关联
        sysDep.getUsers().add(sysUser);
        sysUser.setSysDep(sysDep);

        sysUser.setRoles(new HashSet<>(roles));

        this.getSessionUnwrap().save(sysDep);
    }

    /**
     * 功能描述：删除用户的一个角色，删除sys_role（由hibernate自动处理,流程是先删除中间表sys_user_role）
     */
    public void doDelete01() {
        SysRole sysRole = this.getSessionUnwrap().get(SysRole.class, 2L);
        for (SysUser user : sysRole.getUsers()) {
            user.getRoles().remove(sysRole);
        }
        this.getSessionUnwrap().delete(sysRole);
    }

    /**
     * 功能描述：删除用户的一个角色，实现不删除sys_role，仅删除中间表sys_user_role
     */
    public void doDelete02() {
        SysUser sysUser = this.getSessionUnwrap().get(SysUser.class, 1L);
        SysRole sysRole = this.getSessionUnwrap().get(SysRole.class, 2L);
        System.out.println(sysUser.getUserName());
        sysUser.getRoles().forEach(System.out::println);
        // 删除用户的一个角色,不实际删除sys_role表的信息
        sysUser.getRoles().remove(sysRole);
        // sysUser.getRoles().removeIf(o -> o.getName().equals("02"));
    }

    /**
     * 功能描述：删除用户的角色，实现不能删除sys_role，仅删除中间表sys_user_role
     */
    public void doDelete03() {
        SysUser sysUser = this.getSessionUnwrap().get(SysUser.class, 1L);
        sysUser.getRoles().clear();
    }

    public void doUpdate() {
        SysUser sysUser = this.getSessionUnwrap().get(SysUser.class, 1L);
        SysRole sysRole01 = this.getSessionUnwrap().get(SysRole.class, 3L);
        SysRole sysRole102 = this.getSessionUnwrap().get(SysRole.class, 4L);
        sysUser.getRoles().remove(sysRole01);
        sysUser.getRoles().add(sysRole102);
    }

    public void get() {
        SysUser sysUser = this.getSessionUnwrap().get(SysUser.class, 1L);
        this.getSessionUnwrap().close();
        Set<SysRole> roles = sysUser.getRoles();
    }

    public void getDep() {
        SysDep sysDep = this.getSessionUnwrap().get(SysDep.class, 1L);
        Set<SysUser> users = sysDep.getUsers();
        users.forEach(e -> e.getRoles().forEach(r -> System.out.println(r.getName())));
    }

    public void load() {
        // 代理对象，不发送sql语句
        SysUser load = this.getSessionUnwrap().load(SysUser.class, 1L);
        this.getSessionUnwrap().close();
        Set<SysRole> roles = load.getRoles();
    }

    public void merge() {
        SysUser sysUser = (SysUser) this.getSessionUnwrap().merge(new SysUser());
    }

    public void leftJoin() {
        List<SysDep> list = this.getSessionUnwrap().createQuery(" from SysDep dep " +
                " left join fetch dep.users users " +
                " left join fetch users.roles roles " +
                " left join fetch roles.menus menus ", SysDep.class).list();
        System.out.println(list);
    }
}
