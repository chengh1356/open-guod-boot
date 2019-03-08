package cn.hacz.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/29 时间:10:39
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@RestController
public class Boot0301Application {
    private static Logger log = LoggerFactory.getLogger(Boot0301Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Boot0301Application.class, args);
    }

    @GetMapping("/")
    public String a() {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        return "123";
    }
}
