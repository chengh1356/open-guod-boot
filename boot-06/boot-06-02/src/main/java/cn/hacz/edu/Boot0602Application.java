package cn.hacz.edu;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/22 时间:19:17
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@EnableAdminServer
public class Boot0602Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0602Application.class).run(args);
    }
}
