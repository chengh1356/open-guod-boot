package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/20 时间:14:01
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot0604Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0604Application.class).run(args);
    }
}
