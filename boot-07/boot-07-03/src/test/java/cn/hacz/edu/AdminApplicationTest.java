package cn.hacz.edu;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/26 时间:9:30
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminApplicationTest {
    @Autowired
    StringEncryptor encryptor;

    @Test
    public void test() {
        String encrypt = encryptor.encrypt("123456");
        System.out.println(encrypt);
    }
}
