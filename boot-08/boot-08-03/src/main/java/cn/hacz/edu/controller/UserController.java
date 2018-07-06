package cn.hacz.edu.controller;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:15:07
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceI userServiceI;
    @Autowired
    private UserDaoI userDaoI;

    @PostMapping(value = "/getUser")
    public List<UserEntity> getUser() {
        List<UserEntity> all = userDaoI.findAll();
        return all;
    }
}
