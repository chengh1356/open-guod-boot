package cn.hacz.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * project - spring boot
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/6/8 时间:18:13
 * @JDK 1.8
 * @Description 功能模块：spring boot的hello world入门
 */
@SpringBootApplication
@Controller
public class Boot01Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot01Application.class, args);
    }
}
