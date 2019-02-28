package cn.hacz.edu.service;

import cn.hacz.edu.vo.base.ApiResult;
import cn.hacz.edu.vo.user.UserAddReq;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:12:42
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserServiceI {
    ApiResult addUser(UserAddReq userAddReq);

    ApiResult userData();

    ApiResult userRoleData();

    ApiResult userResourceData();
}
