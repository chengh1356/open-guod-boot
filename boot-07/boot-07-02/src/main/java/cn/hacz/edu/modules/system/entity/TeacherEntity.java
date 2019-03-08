package cn.hacz.edu.modules.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/9 时间:15:24
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "0702Teacher")
public class TeacherEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private Integer age;
}
