package cn.hacz.edu.controller;

import cn.hacz.edu.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/22 时间:20:35
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceI userServiceI;
}
