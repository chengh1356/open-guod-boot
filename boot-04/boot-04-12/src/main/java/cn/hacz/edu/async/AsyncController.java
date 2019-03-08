package cn.hacz.edu.async;

import cn.hacz.edu.deferredResult.DeferredResultHolder;
import cn.hacz.edu.deferredResult.MockQueue;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * project - GitHub整理
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
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

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
        Callable<String> returns = () -> {
            logger.info("副线程启动");
            Thread.sleep(2000);
            logger.info("副线程启动");
            return "success";
        };
        logger.info("主线程结束");
        return returns;
    }

    @GetMapping(value = "/deferredResult")
    public DeferredResult<String> deferredResult() {
        logger.info("主线程启动");
        String random = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(random);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(random, result);
        logger.info("主线程结束");
        return result;
    }
}
