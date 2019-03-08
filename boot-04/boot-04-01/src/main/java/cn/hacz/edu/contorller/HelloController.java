package cn.hacz.edu.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/12/4 时间:21:07
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class HelloController {
    @GetMapping(value = "/sayHello")
    public String sayHello(String name) {
        System.out.println("name" + name);
        return "hello" + name;
    }
}
