package cn.hacz.edu;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:15:17
 * @JDK 1.8
 * @Description 功能模块：测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaWhereTest {
    @Autowired
    private UserDaoI userDaoI;

    @Test
    public void test() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("guod");
        userEntity.setBirthday(LocalDateTime.now());
        userEntity.setBirthdayStart(new Date());
        userEntity.setBirthdayEnd(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
        UserEntity save = userDaoI.save(userEntity);
        System.out.println(save.getBirthday());
    }
}