package cn.hacz.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/19 时间:8:44
 * @JDK 1.8
 * @Description 功能模块：自动生成UUID
 */
@MappedSuperclass
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String userId;
}
