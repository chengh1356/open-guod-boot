package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project - GitHub整理 Gitee开源系统
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/15 时间:21:25
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sys_role")
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 排序
     */
    private String orderNum;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 上级角色
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private SysRoleEntity role;
    /**
     * 子角色
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<SysRoleEntity> roleEntities = new HashSet<>();
    /**
     * 角色和用户
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleEntities")
    private Set<SysUserEntity> userEntities = new HashSet<>();
    /**
     * 角色和资源
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_base_role_resource",
            joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", nullable = false, updatable = false)})
    private Set<SysResourceEntity> resourceEntities = new HashSet<>();
}
