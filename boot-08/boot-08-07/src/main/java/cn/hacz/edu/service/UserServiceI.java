package cn.hacz.edu.service;

import cn.hacz.edu.entity.User;

import java.util.List;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/18 时间:16:37
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserServiceI {
    User getUser(String id);

    List<User> findAllUser(int pageNum, int pageSize);
}
