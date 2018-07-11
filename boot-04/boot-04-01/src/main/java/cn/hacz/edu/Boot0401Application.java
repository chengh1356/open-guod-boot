package cn.hacz.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/11 时间:21:01
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@RestController
public class Boot0401Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot0401Application.class, args);
    }

    @GetMapping(value = "/index")
    public String index() {
        System.out.println("进入后台服务");
        return "hello filter";
    }


}
