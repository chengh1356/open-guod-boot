package cn.hacz.edu.deferredResult;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/12 时间:14:09
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        while (true) {
            if(true){}
        }
    }
}
