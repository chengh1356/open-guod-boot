package cn.hacz.edu.modules.system.entity;

import javax.persistence.*;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/19 时间:8:57
 * @JDK 1.8
 * @Description 功能模块：
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
}
