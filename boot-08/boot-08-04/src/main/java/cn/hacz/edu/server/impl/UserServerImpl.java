package cn.hacz.edu.server.impl;

import cn.hacz.edu.modules.system.dao.UserDaoI;
import cn.hacz.edu.mapping.many2one.GroupEntity;
import cn.hacz.edu.mapping.many2one.UserEntity;
import cn.hacz.edu.server.UserServerI;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/22 时间:19:32
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
@Transactional
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
        Session unwrap = entityManager.unwrap(Session.class);
        Query from_userEntity = unwrap.createQuery("from UserEntity");
        List list = from_userEntity.list();
        for (Object o : list) {
            System.out.println("001" + o);
        }
        Session session = (Session) entityManager.getDelegate();
        String hql = "from UserEntity";
        Query from_userEntity1 = session.createQuery(hql);
        List list1 = from_userEntity1.list();
        for (Object o : list1) {
            System.out.println("002" + o);
        }
        System.out.println(unwrap);
        System.out.println(session);
        return userDaoI.findById(2).get();
    }
}
