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
@Table(name = "tb_sys_resource_type")
@DynamicInsert
@DynamicUpdate
public class ResourceTypeEntity extends BaseEntiy {
    @Column(name = "resourceTypeName", nullable = false, length = 100)
    private String resourceTypeName;
    /**
     *  功能描述：resourceType
     */
    private Integer resourceType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resourceTypeEntities")
    private Set<ResourceEntity> resourceEntities = new HashSet<>(0);
}