package cn.hacz.edu.entity;

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
@Table(name = "tb_sys_role")
@DynamicInsert
@DynamicUpdate
public class RoleEntity extends BaseEntiy {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private RoleEntity parentId;

    @Column(name = "roleName", nullable = false, length = 100)
    private String roleName;

    @Column(name = "remark", length = 200)
    private String remark;

    @Column(name = "seq")
    private Integer seq;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<RoleEntity> roles = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_sys_role_resource",
            joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", nullable = false, updatable = false)})
    private Set<ResourceEntity> resources = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<UserEntity> userEntities = new HashSet<>(0);
}
