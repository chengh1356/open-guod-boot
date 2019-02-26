package cn.hacz.edu.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tb_sys_user")
@DynamicInsert
@DynamicUpdate
public class UserEntity extends BaseEntiy {
    @Column(name = "userName", unique = true, nullable = false, length = 100)
    private String userName;

    @Column(name = "userPassword", nullable = false, length = 100)
    private String userPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_sys_user_role",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)})
    private Set<RoleEntity> roles = new HashSet<>(0);
}