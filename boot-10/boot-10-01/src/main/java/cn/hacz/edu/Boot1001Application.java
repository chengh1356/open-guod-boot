package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:21:35
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@EnableScheduling
public class Boot1001Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot1001Application.class).run(args);
    }
}
