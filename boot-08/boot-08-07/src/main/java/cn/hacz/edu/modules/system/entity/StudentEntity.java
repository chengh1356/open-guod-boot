package cn.hacz.edu.modules.system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * project -
 *
 * @author Administrator
 * @version 1.0
 * @date 日期:2019/1/27 时间:10:06
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    /**
     * 功能描述：主键id
     */
    private Integer id;
    /**
     * 属性描述：姓名
     */
    private String name;
    /**
     * 功能描述：年龄
     */
    private Integer age;
    /**
     * 功能描述：班级号
     */
    private Integer classNum;
}
