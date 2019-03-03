package cn.hacz.edu.modules.system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/29 时间:11:02
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity {
    /**
     *  功能描述：id
     */
    private Integer id;
    
    /**
     *  属性描述：name
     */
    private String name;
    /**
     *  属性描述：info
     */
    private String info;
}
