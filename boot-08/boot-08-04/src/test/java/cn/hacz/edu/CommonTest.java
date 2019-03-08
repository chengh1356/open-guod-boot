package cn.hacz.edu;

import cn.hacz.edu.hql.CommonHql;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/19 时间:8:44
 * @JDK 1.8
 * @Description 功能模块：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {
    @Autowired
    private CommonHql commonHql;

    @Test
    public void test() {
        commonHql.save();
    }
}
