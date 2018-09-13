package cn.hacz.edu.modules.sys.controller;

import cn.hacz.edu.modules.sys.dao.UserDaoI;
import cn.hacz.edu.modules.sys.dto.UserVo;
import cn.hacz.edu.modules.sys.entity.UserEntity;
import cn.hacz.edu.modules.sys.service.UserServiceI;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import cn.hacz.edu.vo.JsonList;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
@Api(tags = "UserController-用户管理的增删改查")
public class SysUserController extends AbstractController {
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
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Json doSaveUserJsonObj(@Validated(UserVo.AddUser.class) UserVo userVo) {
        // lang3中的方法，直接输出对象的全部属性值
        logger.info("添加用户接口===>请求参数：[{}]", ReflectionToStringBuilder.toString(userVo));
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userVo, userEntity);
        userEntity.setBirthday(LocalDateTime.now());
        UserEntity save = userDaoI.save(userEntity);
        logger.info("添加用户接口===>响应参数：[{}]", save);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：添加用户
     *
     * @param params
     * @return
     */
    @PostMapping(value = "doSaveUserJsonMapObj")
    @ApiOperation(value = "添加用户", notes = "添加用户")
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
    @ApiOperation(value = "添加用户", notes = "添加用户")
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
    @ApiOperation(value = "添加用户", notes = "添加用户")
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
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Json doSaveUserJsonValueMapStr(@RequestParam MultiValueMap<String, Object> params) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(LocalDateTime.now());
        UserEntity save = userDaoI.save(userEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：删除用户信息
     *
     * @return
     */
    @DeleteMapping(value = "/doDeleteUser/{id}")
    @ApiOperation(value = "删除用户信息", notes = "通过用户ID删除用户信息")
    public Json deleteUser(@PathVariable("id") String id) {
        userDaoI.deleteById(id);
        return ResultUtils.successJson();
    }

    /**
     * 功能描述：更新用户信息
     *
     * @param id
     * @return
     */
    @PutMapping(value = "/doUpdateUser/{id}")
    @ApiOperation(value = "更新用户信息", notes = "通过用户ID更新用户信息")
    public Json doUpdateUser(@PathVariable("id") String id,
                             @RequestBody UserVo userVo) {
        // 先查询出持久化对象
        Optional<UserEntity> byId = userDaoI.findById(id);
        byId.get().setId(id);
        byId.get().setAge(userVo.getAge());
        // 就行保存更新
        UserEntity save = userDaoI.save(byId.get());
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
    @ApiOperation(value = "单数据返回忽略年龄", notes = "通过用户年龄")
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
    @ApiOperation(value = "单数据返回详细信息", notes = "单数据返回详细信息")
    public Json getUserDetail(@Valid UserVo userVo) {
        return ResultUtils.successJson(userServiceI.getAgeCount(userVo));
    }

    /**
     * 功能描述：多数据返回
     *
     * @return
     */
    @GetMapping(value = "/getUserList")
    @ApiOperation(value = "多数据返回", notes = "多数据返回")
    public JsonList getUserList() {
        List<UserEntity> all = userDaoI.findAll();
        return ResultUtils.successJsonList(all);
    }

    /**
     * 功能描述：多数据分页
     *
     * @return
     */
    @GetMapping(value = "/getUserListPage")
    @ApiOperation(value = "多数据分页", notes = "多数据分页")
    public JsonList getUserListPage() {
        // 排序条件
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<UserEntity> all = userDaoI.findAll(PageRequest.of(1, 100, sort));
        return ResultUtils.successJsonList(all);
    }

    /**
     * 功能描述：注解方式执行SQL语句
     *
     * @return
     */
    @PostMapping(value = "/querySelect/{id}")
    @ApiOperation(value = "注解方式执行SQL语句", notes = "注解方式执行SQL语句")
    public Json querySelect(@PathVariable("id") String id) {
        Integer followerNumberById = userDaoI.findFollowerNumberById(id);
        return ResultUtils.successJson(followerNumberById);
    }
}