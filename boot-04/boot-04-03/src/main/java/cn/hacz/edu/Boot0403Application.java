package cn.hacz.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:16:29
 * @JDK 1.8
 * @Description 功能模块：
 */

@SpringBootApplication
public class Boot0403Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0403Application.class).run(args);
    }
}
