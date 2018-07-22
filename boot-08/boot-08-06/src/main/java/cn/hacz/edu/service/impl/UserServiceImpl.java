package cn.hacz.edu.service.impl;

import cn.hacz.edu.dao.UserDao;
import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/22 时间:20:35
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserById(String id) {
        return userDao.getUserById(id);
    }
}
