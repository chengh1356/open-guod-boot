package cn.hacz.edu.service;

/**
 * project -
 *
 * @author Administrator
 * @version 1.0
 * @date 日期:2019/2/3 时间:16:15
 * @JDK 1.8
 * @Description 功能模块：
 */
public class HelloService {
    private String prefix;
    private String suffix;

    public HelloService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String say(String text) {
        return String.format("%s , hi , %s , %s", prefix, text, suffix);
    }
}
