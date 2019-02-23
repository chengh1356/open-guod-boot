package cn.hacz.edu.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * project -
 *
 * @author Administrator
 * @version 1.0
 * @date 日期:2019/2/3 时间:16:17
 * @JDK 1.8
 * @Description 功能模块：
 */
@ConfigurationProperties("hello.service")
public class HelloServiceProperties {
    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
