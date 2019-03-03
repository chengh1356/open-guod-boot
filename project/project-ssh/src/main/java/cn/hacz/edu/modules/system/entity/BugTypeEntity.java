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
@Table(name = "tb_sys_bug_type")
@DynamicInsert
@DynamicUpdate
public class BugTypeEntity extends BaseEntiy {
    @Column(name = "bugTypeName", length = 100)
    private String bugTypeName;
    /**
     * 功能描述：buyType
     */
    private Integer bugType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bugTypeEntities")
    private Set<BugEntity> bugEntities = new HashSet<>(0);
}
