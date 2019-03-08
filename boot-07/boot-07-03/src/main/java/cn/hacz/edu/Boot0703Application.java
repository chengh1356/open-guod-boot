package cn.hacz.edu;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/26 时间:8:53
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@RestController
public class Boot0703Application {

    @Autowired
    StringEncryptor encryptors;

    public static void main(String[] args) {
        SpringApplication.run(Boot0703Application.class, args);
    }

    @PostMapping(value = "/getPassword")
    public String getPassword(@RequestBody UserVo userVo) {
        String ip = encryptors.encrypt(userVo.getIp());
        String userName = encryptors.encrypt(userVo.getUserName());
        String password = encryptors.encrypt(userVo.getPassword());
        System.out.println("加密用户名：" + ip + "加密用户名：" + userName + "加密用户名：" + password);
        return "加密用户名：" + ip + "；加密用户名：" + userName + "；加密用户名：" + password;
    }
}
