package cn.hacz.edu.service.impl;

import cn.hacz.edu.dao.UserMapper;
import cn.hacz.edu.entity.User;
import cn.hacz.edu.service.UserServiceI;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        // 将参数传给这个方法就可以实现物理分页了，非常简单。new PageInfo(users);
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}
