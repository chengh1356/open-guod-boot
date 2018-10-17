package cn.hacz.edu;

import cn.hacz.edu.properties.PayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/3 时间:21:53
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@RestController
public class Boot0102Application {
    @Autowired
    private PayProperties payProperties;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0102Application.class).run(args);
    }

    @GetMapping(value = "/test")
    public String test() {
        return payProperties.getPayName();
    }
}
