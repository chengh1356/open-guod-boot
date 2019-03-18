package cn.hacz.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/3/15 时间:16:37
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@EnableScheduling
public class Boot1801Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot1801Application.class, args);
    }
}
