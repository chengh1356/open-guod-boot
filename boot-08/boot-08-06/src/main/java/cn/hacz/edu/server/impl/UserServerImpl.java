package cn.hacz.edu.server.impl;

import cn.hacz.edu.repository.UserDaoI;
import cn.hacz.edu.server.UserServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/11 时间:11:29
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class UserServerImpl implements UserServerI {
    @Autowired
    private UserDaoI userDaoI;
}
