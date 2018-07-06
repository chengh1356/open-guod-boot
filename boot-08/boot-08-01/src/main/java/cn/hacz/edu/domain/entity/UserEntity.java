package cn.hacz.edu.domain.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:18:15
 * @JDK 1.8
 * @Description 功能模块：用户实体
 */
@Data
public class UserEntity {
    private String id;
    private String name;
    private Integer age;
    private LocalDate birthday;
}
