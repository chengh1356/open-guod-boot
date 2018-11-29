package cn.hacz.edu;

import cn.hacz.edu.hql.HibernateHQL03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/26 时间:21:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HqlMainTest03 {
    @Autowired
    private HibernateHQL03 hibernateHQL03;

    @Test
    public void testHQL01() {
        hibernateHQL03.doSaveUser();
    }

    @Test
    public void testHQL02() {
        hibernateHQL03.getDelete01();
    }

    @Test
    public void testHQL03() {
        hibernateHQL03.getDelete02();
    }

    @Test
    public void testHQL04() {
        hibernateHQL03.getDelete03();
    }

    @Test
    public void testHQL05() {
        hibernateHQL03.merge();
    }

    @Test
    public void testHQL06() {
        hibernateHQL03.get();
    }

    @Test
    public void testHQL07() {
        // 没有发送sql语句
        hibernateHQL03.load();
    }

}
