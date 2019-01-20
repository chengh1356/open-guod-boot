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
	public List<User> findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
		return userServiceI.findAllUser(pageNum, pageSize);
	}

	/**
	 * 功能描述：方法1：顺序传参法
	 *
	 * @param name
	 * @param deptId
	 * @return
	 */
	public User selectUser(String name, int deptId) {
		/**
		 * <select id="selectUser" resultMap="UserResultMap"> select * from user where
		 * user_name = #{0} and dept_id = #{1} </select> <br/>
		 * #{}里面的数字代表你传入参数的顺序，这种方法不建议使用，sql层表达不直观，且一旦顺序调整容易出错。
		 */
		return null;
	}

	/**
	 * 功能描述：方法2：@Param注解传参法
	 *
	 * @param name
	 * @param deptId
	 * @return
	 */
	public User selectUserParam(@Param("userName") String name, @Param("deptId") int deptId) {
		/**
		 * <select id="selectUser" resultMap="UserResultMap"> select * from user where
		 * user_name = #{userName} and dept_id = #{deptId} </select> <br/>
		 * #{}里面的名称对应的是注解@Param括号里面修饰的名称，这种方法在参数不多的情况还是比较直观的，推荐使用。
		 */
		return null;
	}

	/**
	 * 功能描述：方法3：Map传参法
	 *
	 * @param params
	 * @return
	 */
	public User selectUserMap(Map<String, Object> params) {
		/**
		 * <select id="selectUser" parameterType="java.util.Map" resultMap=
		 * "UserResultMap"> select * from user where user_name = #{userName} and dept_id
		 * = #{deptId} </select> <br/>
		 * #{}里面的名称对应的是Map里面的key名称，这种方法适合传递多个参数，且参数易变能灵活传递的情况。
		 */
		return null;
	}

	/***
	 * 功能描述：方法4：Java Bean传参法
	 * 
	 * @param params
	 * @return
	 */
	public User selectUserObj(Map<String, Object> params) {
		/**
		 * <select id="selectUser" parameterType="com.test.User" resultMap=
		 * "UserResultMap"> select * from user where user_name = #{userName} and dept_id
		 * = #{deptId} </select>
		 * #{}里面的名称对应的是User类里面的成员属性，这种方法很直观，但需要建一个实体类，扩展不容易，需要加属性，看情况使用。
		 */
		return null;
	}
}
