package cn.hacz.edu.mapping.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/21 时间:22:51
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "map_tree")
@DynamicInsert
@DynamicUpdate
public class TreeEntity {
    /**
     * 功能描述：主机id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 属性描述：姓名
     */
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TreeEntity parent;

    @OneToMany(mappedBy = "parent",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    private Set<TreeEntity> children = new HashSet<>();
}
