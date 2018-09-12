package cn.hacz.edu.controller;

import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.server.UserServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/11 时间:11:33
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private UserServerI userServerI;

    @RequestMapping(value = "/test")
    public Object test(@Validated Object object) {
        List<UserEntity> userEntities = userServerI.find();
        System.out.println(userEntities);
        return null;
    }
}
