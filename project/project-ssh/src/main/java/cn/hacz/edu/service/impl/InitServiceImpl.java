package cn.hacz.edu.service.impl;

import cn.hacz.edu.dao.*;
import cn.hacz.edu.entity.*;
import cn.hacz.edu.service.InitServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/26 时间:14:22
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class InitServiceImpl implements InitServiceI {
    @Autowired
    private BugTypeDaoI bugTypeDaoI;
    @Autowired
    private ResourceTypeDaoI resourceTypeDaoI;
    @Autowired
    private ResourceDaoI resourceDaoI;
    @Autowired
    private RoleDaoI roleDaoI;
    @Autowired
    private UserDaoI userDaoI;

    @Override
    public void init() {
        initBugType();// 初始化BUG类型

        initResourceType();// 初始化资源类型

        initResource();// 初始化资源

        initRole();// 初始化角色

        initUser();// 初始化用户

    }

    private void initBugType() {
        BugTypeEntity error = new BugTypeEntity();
        error.setBugType(0);
        error.setBugTypeName("错误");
        error.setCreateTime(LocalDateTime.now());
        error.setRemove(false);
        bugTypeDaoI.save(error);
        BugTypeEntity fun = new BugTypeEntity();
        fun.setBugType(1);
        fun.setBugTypeName("功能");
        fun.setCreateTime(LocalDateTime.now());
        fun.setRemove(false);
        bugTypeDaoI.save(fun);
    }

    private void initResourceType() {
        ResourceTypeEntity menu = new ResourceTypeEntity();
        menu.setResourceType(0);
        menu.setResourceTypeName("菜单");
        menu.setCreateTime(LocalDateTime.now());
        menu.setRemove(false);
        resourceTypeDaoI.save(menu);

        ResourceTypeEntity fun = new ResourceTypeEntity();
        fun.setResourceType(1);
        fun.setResourceTypeName("功能");
        fun.setCreateTime(LocalDateTime.now());
        fun.setRemove(false);
        resourceTypeDaoI.save(fun);

        ResourceTypeEntity but = new ResourceTypeEntity();
        but.setResourceType(2);
        but.setResourceTypeName("按钮");
        but.setCreateTime(LocalDateTime.now());
        but.setRemove(false);
        resourceTypeDaoI.save(but);
    }


    private void initResource() {
        // 菜单类型
        ResourceTypeEntity menuType = resourceTypeDaoI.findByResourceType(0);
        // 功能类型
        ResourceTypeEntity funType = resourceTypeDaoI.findByResourceType(1);
        // 按钮类型
        ResourceTypeEntity butType = resourceTypeDaoI.findByResourceType(2);
        ResourceEntity xtgl = new ResourceEntity();
        xtgl.setResourceName("系统管理");
        xtgl.setResourceTypeEntities(menuType);
        xtgl.setSeq(0);
        xtgl.setIcon("/xtgl");
        xtgl.setCreateTime(LocalDateTime.now());
        resourceDaoI.save(xtgl);


        ResourceEntity xtrz = new ResourceEntity();
        xtrz.setResourceName("系统日志");
        xtrz.setRemark("系统日志");
        xtrz.setResourceTypeEntities(funType);
        xtrz.setSeq(0);
        xtrz.setIcon("/rzgl");
        xtrz.setUrl("/logController/log");
        xtrz.setParentId(xtgl);
        xtrz.setCreateTime(LocalDateTime.now());
        resourceDaoI.save(xtrz);

        ResourceEntity zygl = new ResourceEntity();
        zygl.setResourceName("资源管理");
        zygl.setResourceTypeEntities(menuType);
        zygl.setParentId(xtgl);
        zygl.setSeq(1);
        zygl.setIcon("/zygl");
        zygl.setCreateTime(LocalDateTime.now());
        resourceDaoI.save(zygl);
    }

    private void initRole() {
        RoleEntity superAdmin = new RoleEntity();
        superAdmin.setRoleName("超管");
        // 让超管可以访问所有资源
        superAdmin.getResources().addAll(resourceDaoI.findAll());
        superAdmin.setSeq(0);
        superAdmin.setRemark("超级管理员角色，拥有系统中所有的资源访问权限");
        roleDaoI.save(superAdmin);
    }

    private void initUser() {
        // 数据清理
        List<UserEntity> l = userDaoI.find();
        if (l != null && l.size() > 0) {
            for (UserEntity user : l) {
                userDaoI.delete(user);
            }
        }
        // 用户数据添加
        UserEntity admin = new UserEntity();
        admin.setUserName("郭冬冬");
        admin.setUserPassword("123456");
        admin.setCreateTime(LocalDateTime.now());
        // 给用户赋予所有角色
        admin.getRoles().addAll(roleDaoI.findAll());
        userDaoI.save(admin);
    }

}
