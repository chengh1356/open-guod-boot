package cn.hacz.edu.entity;

import cn.hacz.edu.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/15 时间:21:27
 * @JDK 1.8
 * @Description 功能模块：菜单资源实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "1601_resource")
public class ResourceEntity extends BaseEntity {
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * URL地址
     */
    private String url;
    /**
     * 资源类型（0：目录；1：菜单；2：按钮）
     */
    private String type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private String orderNum;
    /**
     * 所属资源，父菜单ID，一级菜单为0
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private ResourceEntity resource;
    /**
     * 下级资源
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource")
    private Set<ResourceEntity> resourceEntities = new HashSet<>();
    /**
     * 资源与角色
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "resourceEntities")
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
