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
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/29 时间:11:14
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@Entity
@Table(name = "sys_user")
@DynamicUpdate
@DynamicInsert
public class SysUser {
    /**
     * 功能描述：主键id
     */
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "dep_id")
    private SysDep sysDep;
    /**
     * 属性描述：用户名称
     */
    private String userName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)})
    private Set<SysRole> roles = new HashSet<>();
}
