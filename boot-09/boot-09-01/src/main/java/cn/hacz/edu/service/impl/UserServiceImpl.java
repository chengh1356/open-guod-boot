package cn.hacz.edu.service.impl;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dong
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2018年07月23日 22:01:00
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserDaoI userDaoI;

    @Override
    @Cacheable
    public List<UserEntity> getListUser() {
        return userDaoI.findAll();
    }
}