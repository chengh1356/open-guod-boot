package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:25
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot1601Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot1601Application.class).run(args);
    }
}
