package cn.hacz.edu.mapping.many2one;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project - 多对一（数据库表设计：在多方加外键，在一方加冗余）
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/21 时间:21:55
 * @JDK 1.8
 * @Description 功能模块：分组（一的一方：一个分组可以有多个用户）
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "map_group")
@DynamicInsert
@DynamicUpdate
public class GroupEntity {
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
    /**
     * 属性描述：用戶
     * 规律02：双向关系要在程序中设置双向关联
     */
    @OneToMany(mappedBy = "group", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    Set<UserEntity> users = new HashSet<>();
}
