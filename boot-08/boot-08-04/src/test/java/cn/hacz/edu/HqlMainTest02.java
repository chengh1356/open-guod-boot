package cn.hacz.edu;

import cn.hacz.edu.hql.HibernateHQL02;
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
 * @date 日期:2018/11/26 时间:21:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HqlMainTest02 {
    @Autowired
    private HibernateHQL02 hibernateHQL02;

    @Test
    public void testHQL_20() {
        hibernateHQL02.testHQL_20();
    }

    @Test
    public void testHQL_21() {
        hibernateHQL02.testHQL_21();
    }

    @Test
    public void testHQL_22() {
        hibernateHQL02.testHQL_22();
    }

    @Test
    public void testHQL_23() {
        hibernateHQL02.testHQL_23();
    }
}
