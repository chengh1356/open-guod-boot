package cn.hacz.edu.controller;

import cn.hacz.edu.dao.HotelDaoI;
import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.hql.CommonHql;
import cn.hacz.edu.mapping.common.CommonReqVo;
import cn.hacz.edu.mapping.common.CommonResVo;
import cn.hacz.edu.mapping.many2one.UserEntity;
import cn.hacz.edu.vo.Json;
import cn.hacz.edu.vo.JsonList;
import cn.hacz.edu.vo.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private UserDaoI userDaoI;

    /**
     * 功能描述：getUserAll
     */
    @RequestMapping(value = "getUserAll")
    public JsonList getUserAll() {
        List<UserEntity> userAllBySql = userDaoI.getUserAllBySql();
        List<UserEntity> userAllByJpl = userDaoI.getUserAllByJpl();
        return ResultUtils.successJsonList();
    }

    /**
     * 功能描述：get
     */
    @RequestMapping(value = "get")
    public Json get() {
        Sort sort = new Sort(Sort.Direction.DESC, "time");
        Page<UserEntity> all = userDaoI.findAll(PageRequest.of(0, 10, sort));
        Page<UserEntity> inOrders = userDaoI.findInOrders(PageRequest.of(0, 10));
        return ResultUtils.successJsonList(inOrders.getContent(), (long) inOrders.getNumberOfElements());
    }

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
        return null;
    }
}
