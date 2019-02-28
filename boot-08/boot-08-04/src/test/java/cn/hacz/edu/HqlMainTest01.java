package cn.hacz.edu;

import cn.hacz.edu.hql.HibernateHQL01;
import org.hibernate.Session;
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
 * @date 日期:2018/11/23 时间:20:57
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HqlMainTest01 {
    @Autowired
    private HibernateHQL01 hibernateHQL;

    /**
     * 功能描述：获取session的两种方式
     */
    @Test
    public void testHQL_01() {
        Session sessionUnwrap = hibernateHQL.getSessionUnwrap();
        Session sessionUnwrap1 = hibernateHQL.getSessionUnwrap();
        System.out.println(sessionUnwrap + "\n" + sessionUnwrap1);
    }

    @Test
    public void init() {
        hibernateHQL.init();
    }

    /**
     * 功能描述：查询表信息
     */
    @Test
    public void testHQL_02() {
        hibernateHQL.testHQL_02();
    }

    @Test
    public void testHQL_03() {
        hibernateHQL.testHQL_03();
    }

    @Test
    public void testHQL_04() {
        hibernateHQL.testHQL_04();
    }

    @Test
    public void testHQL_05() {
        hibernateHQL.testHQL_05();
    }

    @Test
    public void testHQL_06() {
        hibernateHQL.testHQL_06();
    }

    @Test
    public void testHQL_07() {
        hibernateHQL.testHQL_07();
    }

    @Test
    public void testHQL_08() {
        hibernateHQL.testHQL_08();
    }

    @Test
    public void testHQL_09() {
        hibernateHQL.testHQL_09();
    }

    @Test
    public void testHQL_10() {
        hibernateHQL.testHQL_10();
    }

    @Test
    public void testHQL_11() {
        hibernateHQL.testHQL_11();
    }

    @Test
    public void testHQL_12() {
        hibernateHQL.testHQL_12();
    }

    @Test
    public void testHQL_13() {
        hibernateHQL.testHQL_13();
    }

    @Test
    public void testHQL_14() {
        hibernateHQL.testHQL_14();
    }

    @Test
    public void testHQL_15() {
        hibernateHQL.testHQL_15();
    }

    @Test
    public void testHQL_16() {
        hibernateHQL.testHQL_16();
    }

    @Test
    public void testHQL_17() {
        hibernateHQL.testHQL_17();
    }

    @Test
    public void testHQL_18() {
        hibernateHQL.testHQL_18();
    }

    @Test
    public void testHQL_19() {
        hibernateHQL.testHQL_19();
    }

}
