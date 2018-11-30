package cn.hacz.edu.controller;

import cn.hacz.edu.entity.User;
import cn.hacz.edu.service.UserServiceI;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/18 时间:16:38
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    @GetMapping(value = "/getUser")
    public void getUser() {
        User user = userServiceI.getUser("1");
        System.out.println(user);
    }

    @GetMapping("/all")
    public List<User> findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return userServiceI.findAllUser(pageNum, pageSize);
    }

    /**
     * 功能描述：顺序传参法
     *
     * @param name
     * @param deptId
     * @return
     */
    public User selectUser(String name, int deptId) {
        /**
         * <select id="selectUser" resultMap="UserResultMap">
         *    select * from user
         *    where user_name = #{0} and dept_id = #{1}
         *</select>
         * */
        return null;
    }

    /**
     * 功能描述：@Param注解传参法
     *
     * @param name
     * @param deptId
     * @return
     */
    public User selectUserParam(@Param("userName") String name, @Param("deptId") int deptId) {
        /**
         *<select id="selectUser" resultMap="UserResultMap">
         *
         *
         */
        return null;
    }

    /**
     * 功能描述：Map传参法
     *
     * @param params
     * @return
     */
    public User selectUserMap(Map<String, Object> params) {
        return null;
    }

    /***
     * 功能描述：Java Bean传参法
     * @param params
     * @return
     */
    public User selectUserObj(Map<String, Object> params) {
        return null;
    }
}
