package cn.hacz.edu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/11/4 时间:15:53
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
@ConfigurationProperties(prefix = "guodd")
public class ObjectProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
