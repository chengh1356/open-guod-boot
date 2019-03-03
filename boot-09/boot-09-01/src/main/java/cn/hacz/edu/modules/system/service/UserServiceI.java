package cn.hacz.edu.modules.system.service;

import cn.hacz.edu.modules.system.entity.UserEntity;

import java.util.List;

/**
 * @author dong
 * @version 1.0.0
 * @ClassName UserServiceI.java
 * @Description TODO
 * @createTime 2018年07月23日 22:00:00
 */
public interface UserServiceI {
    List<UserEntity> getListUser();
}
