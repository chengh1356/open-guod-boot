package cn.hacz.edu.controller;

import cn.hacz.edu.service.UserServiceI;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import cn.hacz.edu.vo.JsonList;
import cn.hacz.edu.vo.UserVo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/10 时间:8:15
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    /**
     * 功能描述：单数据返回
     *
     * @param userVo
     * @return
     */
    @GetMapping(value = "/getUser")
    @JsonView(UserVo.DetailInfo.class)
    public Json getUser(@Valid UserVo userVo) {
        return ResultUtils.successJson(userServiceI.getAgeCount(userVo));
    }

    /**
     * 功能描述：多数据返回
     *
     * @return
     */
    @GetMapping(value = "/getUserList")
    public JsonList getUserList(@Valid UserVo userVo) {
        List<UserVo> userVos = new ArrayList<>();
        UserVo userData = new UserVo();
        userVos.add(userData);
        return ResultUtils.successJsonList(userVos);
    }
}
