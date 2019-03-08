package cn.hacz.edu.modules.system;

import cn.hacz.edu.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/17 时间:16:57
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 功能描述：信息
     */
    @GetMapping(value = "userInfo")
    public String userInfo() {
        System.out.println("开始");
        userService.sendSms();
        System.out.println("结束");
        return "info";
    }

}
