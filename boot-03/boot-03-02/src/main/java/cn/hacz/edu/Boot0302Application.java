package cn.hacz.edu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理
 *
 * @author Administrator
 * @version 1.0
 * @date 日期:2019/1/27 时间:12:18
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@Slf4j
@RestController
public class Boot0302Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot0302Application.class, args);
    }

    @GetMapping("/index")
    public String a() {
        log.trace("======trace info");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        return "123";
    }
}
