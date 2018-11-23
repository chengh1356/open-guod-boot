package cn.hacz.edu.server.impl;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.mapping.entity.many2one.GroupEntity;
import cn.hacz.edu.mapping.entity.many2one.UserEntity;
import cn.hacz.edu.server.UserServerI;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/22 时间:19:32
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class UserServerImpl implements UserServerI {
    @Autowired
    private UserDaoI userDaoI;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void doSaveUser() {
        GroupEntity group = new GroupEntity();
        group.setName("组02");
        UserEntity user = new UserEntity();
        user.setName("用户02");
        user.setGroup(group);
        userDaoI.save(user);
    }

    @Override
    public UserEntity doGetUser() {
        System.out.println(entityManager);
        Session session = (Session) entityManager.getDelegate();
        System.out.println(session);
        return userDaoI.findById(2).get();
    }
}
