package cn.hacz.edu.server;

import cn.hacz.edu.modules.system.entity.UserEntity;

import java.util.List;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/11 时间:11:28
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserServerI {
    List<UserEntity> find();
}
