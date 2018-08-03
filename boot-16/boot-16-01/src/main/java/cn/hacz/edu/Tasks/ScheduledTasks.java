package cn.hacz.edu.Tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/10 时间:10:18
 * @JDK 1.8
 * @Description 功能模块：定时任务模块
 */
@Component
public class ScheduledTasks {
    @Scheduled(fixedRate = 500000000)
    public void testTasks() {
        System.out.println("定时任务");
    }
}
