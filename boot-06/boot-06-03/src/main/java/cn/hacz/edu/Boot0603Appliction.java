package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/22 时间:19:24
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
public class Boot0603Appliction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(Boot0603Appliction.class).properties("server.port=" + port).run(args);
    }
}
