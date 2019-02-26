/**
 *
 */
package cn.hacz.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project - Gitee开源系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月20日 时间:上午11:02:17
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonList extends Json {
    /**
     * 属性描述：多条数据
     */
    private Object dataRows;
    /**
     * 属性描述：总条数
     */
    private Long total;
}
