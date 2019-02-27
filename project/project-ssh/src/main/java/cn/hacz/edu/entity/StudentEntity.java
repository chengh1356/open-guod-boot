package cn.hacz.edu.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/27 时间:16:12
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@Entity
@Table(name = "tb_student")
@DynamicInsert
@DynamicUpdate
public class StudentEntity extends BaseEntiy {
    /**
     * 属性描述：姓名
     */
    private String name;
    /**
     * 功能描述：年龄
     */
    private Integer age;
    /**
     * 属性描述：日期
     */
    private LocalDateTime dateTime;
    /**
     * 属性描述：时间
     */
    private LocalDate date;


}
