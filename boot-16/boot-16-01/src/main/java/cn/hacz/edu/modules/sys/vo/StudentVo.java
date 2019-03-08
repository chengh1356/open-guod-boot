package cn.hacz.edu.modules.sys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project - GitHub整理 Gitee开源系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/16 时间:10:14
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {
    /**
     * 属性描述：姓名
     */
    private String name;
    /**
     * 功能描述：年龄
     */
    private Integer age;
}
