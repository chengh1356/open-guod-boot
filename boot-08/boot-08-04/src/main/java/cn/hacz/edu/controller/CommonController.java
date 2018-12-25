package cn.hacz.edu.controller;

import cn.hacz.edu.dao.HotelDaoI;
import cn.hacz.edu.hql.CommonHql;
import cn.hacz.edu.mapping.common.CommonReqVo;
import cn.hacz.edu.mapping.common.CommonResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/12/19 时间:9:01
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class CommonController {
    @Autowired
    private CommonHql commonHql;
    @Autowired
    private HotelDaoI hotelDaoI;

    /**
     * 功能描述：
     */
    @RequestMapping(value = "/useTime")
    public Object useTime(@RequestBody CommonReqVo commonReqVo) {
        List<CommonResVo> time = commonHql.getTime(commonReqVo);
        return time;
    }

    /**
     * 功能描述：多表
     */
    @RequestMapping(value = "/hotelDaoI")
    public Object hotelDaoI(@RequestBody @Validated Object object) {
        return hotelDaoI.findCityAndHotelByHQLResultObj("test");
    }
}
