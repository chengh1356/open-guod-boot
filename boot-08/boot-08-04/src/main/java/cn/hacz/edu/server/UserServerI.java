package cn.hacz.edu.server;

import cn.hacz.edu.mapping.entity.many2one.UserEntity;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/22 时间:19:32
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserServerI {
    void doSaveUser();

    UserEntity doGetUser();
}