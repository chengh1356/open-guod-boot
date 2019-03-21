package cn.hacz.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/3/21 时间:17:06
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@RestController
public class Boot1901Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot1901Application.class, args);
    }

    /**
     * 功能描述：测试方法
     */
    @RequestMapping(value = "/test")
    public String test() {
        return "hello docker info";
    }
}
