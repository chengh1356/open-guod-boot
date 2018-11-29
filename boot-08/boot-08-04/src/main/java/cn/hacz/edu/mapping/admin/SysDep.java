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
 * @date 日期:2018/11/29 时间:19:13
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@Entity
@Table(name = "sys_dep")
@DynamicUpdate
@DynamicInsert
public class SysDep {
    /**
     * 功能描述：主键id
     */
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "sysDep")
    private Set<SysUser> users = new HashSet<>();
}
