package cn.hacz.edu.modules.system.service.impl;

import cn.hacz.edu.modules.system.dao.UserDaoI;
import cn.hacz.edu.modules.system.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:15:06
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserDaoI userDaoI;
}
