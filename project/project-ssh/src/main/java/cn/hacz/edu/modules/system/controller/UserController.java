package cn.hacz.edu.modules.system.controller;

import cn.hacz.edu.base.vo.ApiResult;
import cn.hacz.edu.base.vo.Data;
import cn.hacz.edu.modules.system.dao.UserDaoI;
import cn.hacz.edu.modules.system.entity.LoginDetail;
import cn.hacz.edu.modules.system.service.UserServiceI;
import cn.hacz.edu.modules.system.vo.user.UserLoginReq;
import cn.hacz.edu.util.TokenDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:12:41
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private UserDaoI userDaoI;

    @Value("${token.header}")
    private String tokenHeader;

    /**
     * 功能描述：
     */
    @RequestMapping(value = "login")
    public ApiResult login(@RequestBody UserLoginReq userLoginReq) {
        LoginDetail loginDetail = userDaoI.findByUserName(userLoginReq.getUserName());
        ApiResult apiResult = checkAccount(userLoginReq, loginDetail);
        if (apiResult != null) {
            return apiResult;
        }
        return ApiResult.ok().data(new Data().addObj(tokenHeader, userServiceI.generateToken((TokenDetail) loginDetail)));
    }

    private ApiResult checkAccount(UserLoginReq userLoginReq, LoginDetail loginDetail) {
        if (loginDetail == null) {
            return ApiResult.error(434, "账号不存在！");
        } else {
            if (loginDetail.enable() == false) {
                return ApiResult.error(452, "账号在黑名单中！");
            }
            if (!loginDetail.getUserPassword().equals(userLoginReq.getUserPassword())) {
                return ApiResult.error(438, "密码错误！");
            }
        }
        return null;
    }

    /**
     * 功能描述：获取用户数据表格
     */
    @RequestMapping(value = "/userData")
    public ApiResult userData() {
        return userServiceI.userData();
    }

    /**
     * 功能描述：获取用户角色
     */
    @RequestMapping(value = "/userRoleData")
    public ApiResult userRoleData() {
        return userServiceI.userRoleData();
    }

    /**
     * 功能描述：获取用户资源
     */
    @RequestMapping(value = "/userResourceData")
    public ApiResult userResourceData() {
        return userServiceI.userResourceData();
    }
}
