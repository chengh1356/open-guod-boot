package cn.hacz.edu.service;

import cn.hacz.edu.vo.BaseOperationRes;
import cn.hacz.edu.vo.JsonList;
import cn.hacz.edu.vo.UserReq;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/26 时间:12:42
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserServiceI {
    BaseOperationRes addUser(UserReq userReq);

    JsonList userData();

    JsonList userRoleData();

    JsonList userResourceData();
}
