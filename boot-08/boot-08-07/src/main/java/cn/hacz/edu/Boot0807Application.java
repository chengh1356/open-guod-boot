package cn.hacz.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/18 时间:11:58
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@MapperScan(value = "cn.hacz.edu.modules.system.dao")
public class Boot0807Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot0807Application.class, args);
    }
}
