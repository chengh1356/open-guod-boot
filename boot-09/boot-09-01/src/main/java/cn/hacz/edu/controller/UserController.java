package cn.hacz.edu.controller;

import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/24 时间:7:59
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserServiceI userServiceI;

    @GetMapping(value = "/test")
    public void test() {
        stringRedisTemplate.opsForValue().set("郭冬冬", "测试");
    }

    @GetMapping(value = "/index")
    public void index() {
        List<UserEntity> listUser = userServiceI.getListUser();
        System.out.println(listUser);
    }
}
