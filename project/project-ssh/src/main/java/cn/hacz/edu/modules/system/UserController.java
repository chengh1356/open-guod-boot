package cn.hacz.edu.modules.system;

import cn.hacz.edu.service.UserServiceI;
import cn.hacz.edu.vo.base.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
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
     *  功能描述：获取用户资源
     */
    @RequestMapping(value = "/userResourceData")
    public ApiResult userResourceData(){
        return userServiceI.userResourceData();
    }
}
