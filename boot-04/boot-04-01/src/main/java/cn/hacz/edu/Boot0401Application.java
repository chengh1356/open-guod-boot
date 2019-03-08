package cn.hacz.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理 filter、interceptor、aop
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/11 时间:21:01
 * @JDK 1.8
 * @Description 功能模块：AOP使用的主要是动态代理 ， 过滤器使用的主要是反射 ；拦截器使用的主要是回调 。
 */
@SpringBootApplication
@RestController
public class Boot0401Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot0401Application.class, args);
    }

    /**
     * 执行顺序 ：过滤前 - 拦截前 - aspect 开始执行- controller逻辑处理
     * 结束顺序：aspect结束 - 拦截结束 - 过滤结束
     * Filter 是 java web 里面的，肯定获取不到 spring 里面 Controller 的信息。
     * Interceptor、Aspect 是和 spring 相关的，所以能获取到 Controller 的信息。
     */
    @GetMapping(value = "/index")
    public String index() {
        System.out.println("进入后台服务");
        return "hello filter";
    }


}
