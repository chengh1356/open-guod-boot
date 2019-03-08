package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/9 时间:14:49
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot0701Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0701Application.class).run(args);
    }
}
