package cn.hacz.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/9 时间:21:10
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot0203Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Boot0203Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Boot0203Application.class);
    }
}
