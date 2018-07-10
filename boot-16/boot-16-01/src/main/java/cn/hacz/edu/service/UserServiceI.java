package cn.hacz.edu.service;

import cn.hacz.edu.vo.UserVo;

import javax.validation.Valid; /**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/10 时间:9:34
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserServiceI {
    UserVo getAgeCount(@Valid UserVo userVo);
}
