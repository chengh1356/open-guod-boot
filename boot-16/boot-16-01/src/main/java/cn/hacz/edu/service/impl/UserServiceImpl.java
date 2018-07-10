package cn.hacz.edu.service.impl;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.enums.ResultEnum;
import cn.hacz.edu.exception.SelfException;
import cn.hacz.edu.service.UserServiceI;
import cn.hacz.edu.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/10 时间:9:35
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserDaoI userDaoI;

    @Override
    public UserVo getAgeCount(@Valid UserVo userVo) {
        UserEntity userEntity = userDaoI.getOne(userVo.getId());
        if (userEntity.getAge() <= 12) {
            throw new SelfException(ResultEnum.ERROR_VALUE);
        }
        // entity中的数据copy到vo中
        BeanUtils.copyProperties(userEntity, userVo);
        return userVo;
    }
}
