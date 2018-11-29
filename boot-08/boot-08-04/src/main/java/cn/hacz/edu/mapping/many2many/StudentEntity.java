package cn.hacz.edu.mapping.many2many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
 * @date 日期:2018/11/21 时间:22:41
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "map_student")
@DynamicInsert
@DynamicUpdate
public class StudentEntity {
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

    @ManyToMany(mappedBy = "students")
    private Set<TeacherEntity> teachers = new HashSet<>();
}
