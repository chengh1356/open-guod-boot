package cn.hacz.edu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/1/10 时间:12:42
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    /**
     * 属性描述：用户名称
     */
    private String userName;
    /**
     * 属性描述：用户IP
     */
    private String ip;
    /**
     * 属性描述：密码
     */
    private String password;
}