package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import cn.hacz.edu.modules.sys.repository.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project - 综合客户服务系统
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/9/15 时间:10:18
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_sys_user_site")
@DynamicInsert
@DynamicUpdate
public class SysUserSiteEntity extends BaseEntity {
    @Comment("用户有哪些角色")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_base_user_role", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", nullable = false, updatable = false)})
    private Set<SysRoleEntity> roles = new HashSet<>(0);// 用户有哪些角色

    @Comment("关联用户")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private SysUserEntity user;

    @Comment("关联系统")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private SysSiteEntity site;

    @Comment("授权信息")
    @Column(length = 1000)
    private String token;
}
