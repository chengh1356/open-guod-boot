/**
 *
 */
package cn.hacz.edu.modules.system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project - GitHub整理 Gitee开源系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月20日 时间:上午11:01:42
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Json {
    /**
     * 属性描述：成功标示
     */
    private boolean success;
    /**
     * 属性描述：响应信息
     */
    private String message;
    /**
     * 属性描述：响应码
     */
    private String code;
    /**
     * 属性描述：单条数据
     */
    private Object data;
}
