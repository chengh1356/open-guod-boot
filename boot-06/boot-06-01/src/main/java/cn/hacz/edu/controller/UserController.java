package cn.hacz.edu.controller;

import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.vo.UserVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:13:39
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @GetMapping(value = "/getUserVo", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public UserEntity getUserVo(UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("郭冬");
        userEntity.setAge(12);
        userEntity.setId(userVo.getId());
        return userEntity;
    }

    @GetMapping(value = "/getUserJson", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public UserEntity getUserJson(@RequestBody UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userVo.getName());
        return userEntity;
    }

    @GetMapping(value = "/getUserMap")
    public UserEntity getUserMap(@RequestParam Map<String, Object> map) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId((String) map.get("id"));
        return userEntity;
    }

    @GetMapping(value = "/getUserMapJson")
    public UserEntity getUserMapJson(@RequestBody Map<String, Object> map) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId((String) map.get("id"));
        return userEntity;
    }

    @GetMapping(value = "/getUserPathVariable/{id}")
    public UserEntity getUserPathVariable(@PathVariable String id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        return userEntity;
    }

    @GetMapping(value = "/getUserRequestParam")
    public UserEntity getUserRequestParam(@RequestParam String id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        return userEntity;
    }

    @GetMapping(value = "/getParam")
    public UserEntity getParam(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        return userEntity;
    }

}
