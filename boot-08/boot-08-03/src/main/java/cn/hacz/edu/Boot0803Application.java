package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:14:03
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot0803Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0803Application.class).run(args);
    }
}
