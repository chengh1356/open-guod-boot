package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/19 时间:17:13
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot0804Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0804Application.class).run(args);
    }
}