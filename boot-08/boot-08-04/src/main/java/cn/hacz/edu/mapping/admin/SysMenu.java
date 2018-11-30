package cn.hacz.edu.mapping.admin;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/29 时间:11:14
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@Entity
@Table(name = "sys_menu")
@DynamicUpdate
@DynamicInsert
public class SysMenu {
    /**
     * 功能描述：主键id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 属性描述：菜单名称
     */
    private String name;

    @ManyToMany(mappedBy = "menus", cascade = {CascadeType.ALL})
    private Set<SysRole> roles = new HashSet<>();

}
