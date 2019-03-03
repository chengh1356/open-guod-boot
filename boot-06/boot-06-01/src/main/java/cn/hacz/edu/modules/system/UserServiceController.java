package cn.hacz.edu.modules.system;

import cn.hacz.edu.modules.system.entity.UserEntity;
import cn.hacz.edu.modules.system.vo.UserVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * project -
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:13:39
 * @JDK 1.8
 * @Description 功能模块：服务端
 */
@RestController
public class UserServiceController {

    @PostMapping(value = "/getServiceUserVo", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public UserEntity getUserVo(UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userVo.getName());
        userEntity.setAge(userVo.getAge());
        userEntity.setId(userVo.getId());
        return userEntity;
    }

    @PostMapping(value = "/getServiceUserJson", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public UserEntity getUserJson(@RequestBody UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userVo.getName());
        userEntity.setAge(userVo.getAge());
        return userEntity;
    }

    @PostMapping(value = "/getServiceUserMap")
    public UserEntity getUserMap(@RequestParam Map<String, Object> map) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId((String) map.get("id"));
        return userEntity;
    }

    @PostMapping(value = "/getServiceUserMapJson")
    public UserEntity getUserMapJson(@RequestBody Map<String, Object> map) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId((String) map.get("id"));
        return userEntity;
    }

    @GetMapping(value = "/geServicetUserPathVariable/{id}")
    public UserEntity getUserPathVariable(@PathVariable String id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        return userEntity;
    }

    @PostMapping(value = "/getServiceUserRequestParam")
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
