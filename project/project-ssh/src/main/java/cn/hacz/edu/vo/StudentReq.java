package cn.hacz.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/27 时间:16:23
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentReq  {
    /**
     *  功能描述：id
     */
    private Integer id;

    /**
     *  属性描述：name
     */
    private String name;
    
    /**
     *  功能描述：年龄
     */
    private Integer age;

}
