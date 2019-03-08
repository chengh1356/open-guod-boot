package cn.hacz.edu.server.impl;

import cn.hacz.edu.modules.system.entity.UserEntity;
import cn.hacz.edu.repository.UserDaoI;
import cn.hacz.edu.server.UserServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project - GitHub整理 综合客户服务系统
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

    @Override
    public List<UserEntity> find() {
        QPageRequest qPageRequest = new QPageRequest(1, 4);
        List<UserEntity> userEntities = userDaoI.find("", UserEntity.class, qPageRequest);
        return userEntities;
    }
}
