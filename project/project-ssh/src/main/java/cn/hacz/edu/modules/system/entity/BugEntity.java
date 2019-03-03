package cn.hacz.edu.modules.system.entity;

import cn.hacz.edu.base.entity.BaseEntiy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sys_bug")
@DynamicInsert
@DynamicUpdate
public class BugEntity extends BaseEntiy {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bug_type_id")
    private BugTypeEntity bugTypeEntities;
    @Column(name = "name", length = 100)
    private String bugName;
}
