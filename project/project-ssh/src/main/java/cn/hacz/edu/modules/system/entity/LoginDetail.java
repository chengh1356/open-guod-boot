package cn.hacz.edu.modules.system.entity;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/28 时间:16:01
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface LoginDetail {
    String getUserName();
    String getUserPassword();
    boolean enable();
}
