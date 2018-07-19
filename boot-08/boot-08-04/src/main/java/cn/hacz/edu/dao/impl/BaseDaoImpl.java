package cn.hacz.edu.dao.impl;

import cn.hacz.edu.dao.BaseDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/19 时间:17:17
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class BaseDaoImpl<T> implements BaseDaoI<T> {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 功能描述：获得当前事物的session
     *
     * @return
     */
    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
