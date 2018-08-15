package cn.hacz.edu.controller;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.service.UserServiceI;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import cn.hacz.edu.vo.JsonList;
import cn.hacz.edu.vo.UserVo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UserDaoI userDaoI;

    /**
     * 功能描述：添加用户
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "doSaveUserJsonObj")
    public Json doSaveUserJsonObj(@Validated(UserVo.AddUser.class) UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userVo, userEntity);
        userEntity.setBirthday(LocalDateTime.now());
        UserEntity save = userDaoI.save(userEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：添加用户
     *
     * @param params
     * @return
     */
    @PostMapping(value = "doSaveUserJsonMapObj")
    public Json doSaveUserJsonMapObj(@RequestParam Map<String, Object> params) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(LocalDateTime.now());
        userEntity.setUserName((String) params.get("name"));
        UserEntity save = userDaoI.save(userEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：添加用户
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "doSaveUserJsonStr")
    public Json doSaveUserJsonStr(@RequestBody @Validated(UserVo.AddUser.class) UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(LocalDateTime.now());
        UserEntity save = userDaoI.save(userEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：添加用户
     *
     * @param params
     * @return
     */
    @PostMapping(value = "doSaveUserJsonMapStr")
    public Json doSaveUserJsonMapStr(@RequestBody Map<String, Object> params) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(LocalDateTime.now());
        UserEntity save = userDaoI.save(userEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：添加用户
     *
     * @param params
     * @return
     */
    @PostMapping(value = "doSaveUserJsonValueMapStr")
    public Json doSaveUserJsonValueMapStr(@RequestParam MultiValueMap<String, Object> params) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(LocalDateTime.now());
        UserEntity save = userDaoI.save(userEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：单数据返回忽略年龄
     *
     * @param userVo
     * @return
     */
    @GetMapping(value = "/getUserBase")
    @JsonView(UserVo.BaseInfo.class)
    public Json getUserBase(@Validated(UserVo.BaseInfo.class) UserVo userVo) {
        return userServiceI.getAgeCount(userVo);
    }

    /**
     * 功能描述：单数据返回详细信息
     *
     * @param userVo
     * @return
     */
    @GetMapping(value = "/getUserDetail")
    @JsonView(UserVo.DetailInfo.class)
    public Json getUserDetail(@Valid UserVo userVo) {
        return ResultUtils.successJson(userServiceI.getAgeCount(userVo));
    }

    /**
     * 功能描述：多数据返回
     *
     * @return
     */
    @GetMapping(value = "/getUserList")
    public JsonList getUserList(@Valid UserVo userVo) {
        List<UserEntity> all = userDaoI.findAll();
        return ResultUtils.successJsonList(all);
    }

    /**
     * 功能描述：删除用户信息
     *
     * @return
     */
    @DeleteMapping(value = "/deleteUser")
    public Json deleteUser(@RequestParam("var1") Long var1) {
        System.out.println(var1);
        return ResultUtils.successJson();
    }


    @PostMapping(value = "test")
    public Json test() {
        Integer followerNumberById = userDaoI.findFollowerNumberById(1);
        return ResultUtils.successJson(followerNumberById);
    }
}
