package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project -
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
@Table(name = "1601_role")
public class RoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
        private String roleName;
    /**
     * 排序
     */
    private String orderNum;
    /**
     * 上级角色
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private RoleEntity role;
    /**
     * 子角色
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<RoleEntity> roleEntities = new HashSet<>();
    /**
     * 角色和用户
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleEntities")
    private Set<UserEntity> userEntities = new HashSet<>();
    /**
     * 角色和资源
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_resource",
            joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", nullable = false, updatable = false)})
    private Set<ResourceEntity> resourceEntities = new HashSet<>();
}
