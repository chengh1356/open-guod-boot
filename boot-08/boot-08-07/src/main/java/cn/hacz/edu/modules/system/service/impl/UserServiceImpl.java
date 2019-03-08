package cn.hacz.edu.modules.system.service.impl;

import cn.hacz.edu.modules.system.dao.UserEntityMapper;
import cn.hacz.edu.modules.system.entity.UserEntity;
import cn.hacz.edu.modules.system.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/21 时间:16:52
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public int save(UserEntity user) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", user.getUserName());
        return userEntityMapper.saveUser(map);
    }
}
