package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/12/17 时间:16:56
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@EnableAsync
public class Boot1101Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot1101Application.class).run(args);
    }
}
