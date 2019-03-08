package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import cn.hacz.edu.annotation.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * project - GitHub整理 Gitee开源系统
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/9/15 时间:10:13
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sys_site")
@DynamicInsert
@DynamicUpdate
public class SysSiteEntity extends BaseEntity {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
    private List<SysUserSiteEntity> users;

    @Comment("系统编码")
    @Column(length = 100, nullable = false)
    private String code;

    @Comment("系统名称")
    @Column(length = 100)
    private String name;

    @Comment("系统路径")
    @Column(length = 100)
    private String url;

    @Comment("系统标识")
    @Column(length = 100)
    private String icon;

    @Comment("授权码")
    @Column(length = 100)
    private String authcode;

    @Comment("系统说明")
    @Column(length = 100)
    private String remark;

    @Comment("系统状态")
    private Integer status;

    @Comment("创建者")
    @ManyToOne(fetch = FetchType.LAZY)
    private SysUserEntity createUser;

    @Comment("更新者")
    @ManyToOne(fetch = FetchType.LAZY)
    private SysUserEntity modifyUser;

    @Comment("拥有人")
    @ManyToOne(fetch = FetchType.LAZY)
    private SysUserEntity user;
}
