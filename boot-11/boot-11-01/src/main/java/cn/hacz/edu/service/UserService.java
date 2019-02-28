package cn.hacz.edu.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/17 时间:17:03
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class UserService {
    @Async
    public void sendSms() {
        int a = 10 / 0;
    }
}
