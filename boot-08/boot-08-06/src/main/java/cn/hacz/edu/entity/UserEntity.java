package cn.hacz.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/22 时间:19:49
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private String id;
    private String name;
    private Integer age;
}
