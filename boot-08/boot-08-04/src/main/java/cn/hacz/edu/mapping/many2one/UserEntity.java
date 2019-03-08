package cn.hacz.edu.mapping.many2one;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * project - GitHub整理 多对一（数据库表设计：在多方加外键，在一方加冗余）
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/21 时间:21:56
 * @JDK 1.8
 * @Description 功能模块：用户（多的一方：一个用户只能属于一个分组）
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "map_user")
@DynamicInsert
@DynamicUpdate
public class UserEntity {
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
     * 属性描述：用户组
     * 规律02：双向关系要在程序中设置双向关联
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private GroupEntity group;
}
