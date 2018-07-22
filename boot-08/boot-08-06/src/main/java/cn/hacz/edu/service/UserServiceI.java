package cn.hacz.edu.service;

import cn.hacz.edu.entity.UserEntity;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/22 时间:20:34
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserServiceI {
    UserEntity getUserById(String id);
}
