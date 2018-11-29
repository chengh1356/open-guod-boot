package cn.hacz.edu.mapping.admin;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/29 时间:11:14
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@Entity
@Table(name = "sys_role")
@DynamicUpdate
@DynamicInsert
public class SysRole {
    /**
     * 功能描述：主键id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 属性描述：用户名称
     */
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<SysUser> users = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "sys_role_menu",
            joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", nullable = false, updatable = false)})
    private Set<SysMenu> menus = new HashSet<>();
}
