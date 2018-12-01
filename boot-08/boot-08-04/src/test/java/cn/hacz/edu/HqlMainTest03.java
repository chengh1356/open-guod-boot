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
    public void doInit() {
        hibernateHQL03.doInit();
    }

    @Test
    public void doDelete01() {
        hibernateHQL03.doDelete01();
    }

    @Test
    public void doDelete02() {
        hibernateHQL03.doDelete02();
    }

    @Test
    public void doDelete03() {
        hibernateHQL03.doDelete03();
    }

    @Test
    public void merge() {
        hibernateHQL03.merge();
    }

    @Test
    public void get() {
        hibernateHQL03.get();
    }

    @Test
    public void getDep() {
        hibernateHQL03.getDep();
    }

    @Test
    public void load() {
        // 没有发送sql语句
        hibernateHQL03.load();
    }

    @Test
    public void leftJoin(){
        hibernateHQL03.leftJoin();
    }

}
