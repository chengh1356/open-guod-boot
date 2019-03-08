package cn.hacz.edu.modules.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:21:39
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class TasksController {
    @GetMapping(value = "/tasks")
    public void tasks() {
        System.out.println("定时任务输出");
    }
}
