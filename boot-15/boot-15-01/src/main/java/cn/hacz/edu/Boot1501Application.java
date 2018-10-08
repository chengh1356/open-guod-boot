package cn.hacz.edu;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/30 时间:8:19
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Boot1501Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot1501Application.class).run(args);
    }
}
