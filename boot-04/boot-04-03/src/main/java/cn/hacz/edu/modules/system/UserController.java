package cn.hacz.edu.modules.system;

import cn.hacz.edu.modules.system.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:16:35
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @GetMapping(value = "/getUser")
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("郭冬冬");
        userEntity.setId("1");
        return userEntity;
    }
}
