package cn.hacz.edu;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
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
    StringEncryptor encryptor;

    public static void main(String[] args) {
        SpringApplication.run(Boot0703Application.class, args);
    }

    @GetMapping(value = "/getPassword")
    public String getPassword() {
        String url = encryptor.encrypt("xxx.xxx.xxx.xxx");
        String userName = encryptor.encrypt("xxxx");
        String password = encryptor.encrypt("xxxxxx");
        System.out.println("加密用户名：" + url + "加密用户名：" + userName + "加密用户名：" + password);
        return url + ";" + userName + ";" + password;
    }
}
