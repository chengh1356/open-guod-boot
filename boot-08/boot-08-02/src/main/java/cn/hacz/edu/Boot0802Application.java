package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/7 时间:15:48
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot0802Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0802Application.class).run(args);
    }
}
