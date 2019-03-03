package cn.hacz.edu.modules.system.entity;

import cn.hacz.edu.base.entity.BaseEntiy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sys_resource")
@DynamicInsert
@DynamicUpdate
public class ResourceEntity extends BaseEntiy {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private ResourceEntity parentId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentId")
    private Set<ResourceEntity> resourceEntities = new HashSet<>(0);

    @Column(name = "resourceName", nullable = false, length = 100)
    private String resourceName;

    @Column(name = "seq")
    private Integer seq;

    @Column(name = "remark", length = 200)
    private String remark;

    @Column(name = "url", length = 200)
    private String url;

    @Column(name = "icon", length = 100)
    private String icon;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "resources")
    private Set<RoleEntity> roleEntities = new HashSet<>(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_type_id", nullable = false)
    private ResourceTypeEntity resourceTypeEntities;
}
