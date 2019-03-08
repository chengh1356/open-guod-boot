package cn.hacz.edu.modules.system.dao.impl;

import cn.hacz.edu.modules.system.dao.BaseDaoI;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/19 时间:18:52
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class BaseDaoImpl<T> implements BaseDaoI<T> {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 功能描述：通过entityManager获得当前事物的session
     *
     * @return
     */
    public Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

}
