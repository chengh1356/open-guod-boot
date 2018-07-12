package cn.hacz.edu.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/12 时间:13:46
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/order")
    public String order() {
        logger.info("主线程启动");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("主线程结束");
        return "success";
    }


    @GetMapping(value = "/callAble")
    public Callable<String> callAble() {
        logger.info("主线程启动");
        Callable<String> returns = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程启动");
                Thread.sleep(2000);
                logger.info("副线程启动");
                return "success";
            }
        };
        logger.info("主线程结束");
        return returns;
    }


    public void defaulet(){

    }
}
