package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:29
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "1601_user")
@DynamicInsert
@DynamicUpdate
public class UserEntity extends BaseEntity {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 出生日期
     */
    private LocalDateTime birthday;
    private Integer age;
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 个人邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String userIcon;
    /**
     * 状态 0：禁用;1：正常
     */
    private String status;
    /**
     * 一个用户可以有多个角色
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)})
    private Set<RoleEntity> roleEntities = new HashSet<>();
}