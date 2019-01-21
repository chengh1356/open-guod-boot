package cn.hacz.edu.controller;

import cn.hacz.edu.model.UserEntity;
import cn.hacz.edu.service.UserServiceI;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/18 时间:16:38
 * @JDK 1.8
 * @Description 功能模块：传参类型
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    /**
     * 功能描述：添加操作
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(UserEntity user) {
        return userServiceI.save(user);
    }

    /**
     * 功能描述：#{}、${}区别
     * #{} 在预处理时，会把参数部分用一个占位符?代替
     * ${} 则只是简单的字符串替换
     */
    @RequestMapping(value = "/difference")
    public Object difference(@RequestBody Object object) {
        return null;
    }

    /**
     * 功能描述：方法1：顺序传参法
     *
     * @param name
     * @param deptId
     * @return
     */
    public void selectUser(String name, int deptId) {
        /**
         * <select id="selectUser" resultMap="UserResultMap"> select * from user where
         * user_name = #{0} and dept_id = #{1} </select> <br/>
         * #{}里面的数字代表你传入参数的顺序，这种方法不建议使用，sql层表达不直观，且一旦顺序调整容易出错。
         */
    }

    /**
     * 功能描述：方法2：@Param注解传参法
     *
     * @param name
     * @param deptId
     * @return
     */
    public void selectUserParam(@Param("userName") String name, @Param("deptId") int deptId) {
        /**
         * <select id="selectUser" resultMap="UserResultMap"> select * from user where
         * user_name = #{userName} and dept_id = #{deptId} </select> <br/>
         * #{}里面的名称对应的是注解@Param括号里面修饰的名称，这种方法在参数不多的情况还是比较直观的，推荐使用。
         */
    }

    /**
     * 功能描述：方法3：Map传参法
     *
     * @param params
     * @return
     */
    public void selectUserMap(Map<String, Object> params) {
        /**
         * <select id="selectUser" parameterType="java.util.Map" resultMap=
         * "UserResultMap"> select * from user where user_name = #{userName} and dept_id
         * = #{deptId} </select> <br/>
         * #{}里面的名称对应的是Map里面的key名称，这种方法适合传递多个参数，且参数易变能灵活传递的情况。
         */
    }

    /***
     * 功能描述：方法4：Java Bean传参法
     *
     * @param params
     * @return
     */
    public void selectUserObj(Map<String, Object> params) {
        /**
         * <select id="selectUser" parameterType="com.test.User" resultMap="UserResultMap">
         * select * from user where user_name = #{userName} and dept_id = #{deptId}
         * </select>
         * #{}里面的名称对应的是User类里面的成员属性，这种方法很直观，但需要建一个实体类，扩展不容易，需要加属性，看情况使用。
         */
    }
}