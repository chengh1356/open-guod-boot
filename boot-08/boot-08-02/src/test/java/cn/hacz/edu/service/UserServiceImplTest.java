package cn.hacz.edu.service;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.domain.entity.StudentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/7 时间:16:05
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserServiceI userServiceI;
    @Autowired
    private UserDaoI userDaoI;

    @Test
    public void insert() throws Exception {
        userServiceI.insert("guod", 22);
    }

    @Test
    public void deleteByName() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(12);
        studentEntity.setName("java");
        userDaoI.add(studentEntity);
    }

}