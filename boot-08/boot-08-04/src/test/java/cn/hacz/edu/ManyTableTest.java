package cn.hacz.edu;

import cn.hacz.edu.modules.system.dao.HotelDaoI;
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
 * @date 日期:2018/12/24 时间:15:23
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ManyTableTest {
    @Autowired
    private HotelDaoI hotelDaoI;
    @Test
    public void test(){
        // hotelDaoI.findCityAndHotelByHQL("test");
    }
}
