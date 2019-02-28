package cn.hacz.edu;

import cn.hacz.edu.dao.HotelDaoI;
import cn.hacz.edu.mapping.many2one.GroupEntity;
import cn.hacz.edu.server.GroupServerI;
import cn.hacz.edu.server.UserServerI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/22 时间:16:53
 * @JDK 1.8
 * @Description 功能模块：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpqlTest {
    @Autowired
    private GroupServerI groupServerI;
    @Autowired
    private UserServerI userServerI;


    @Test
    public void doSaveGroup() {
        groupServerI.doSaveGroup();
    }

    @Test
    public void doSaveUser() {
        userServerI.doSaveUser();
    }

    @Test
    public void doGetUser() {
        userServerI.doGetUser();
    }

    @Test
    public void doGetGroup() {
        GroupEntity groupEntity = groupServerI.doGetGroup();
        groupEntity.getUsers().forEach(System.out::println);
    }

}
