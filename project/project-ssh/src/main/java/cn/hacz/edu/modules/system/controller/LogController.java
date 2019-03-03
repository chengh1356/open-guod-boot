package cn.hacz.edu.modules.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/27 时间:12:34
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@Slf4j
public class LogController {
    /**
     * 功能描述：
     */
    @GetMapping(value = "/log")
    public String log() {
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "log";
    }
}
