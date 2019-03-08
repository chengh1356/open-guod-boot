package cn.hacz.edu.hql;

import cn.hacz.edu.mapping.many2one.GroupEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * project - GitHub整理
 *
 * @author
 * @version 1.0
 * @date 日期:2018/11/26 时间:8:01
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class HibernateHQL02 {
    @PersistenceContext
    private EntityManager entityManager;

    public Session getSession() {
        return this.entityManager.unwrap(Session.class);
    }

    /**
     * is not empty & is empty
     */
    public void testHQL_20() {
        List<GroupEntity> list = this.getSession().createQuery("from GroupEntity g where g.users is not empty", GroupEntity.class).list();
        list.forEach(System.out::println);
    }


    /**
     * like查询（_name、%name、%name%）
     */
    public void testHQL_21() {
        List<GroupEntity> list = this.getSession().createQuery("from GroupEntity g where g.name like '%5'", GroupEntity.class).list();
        list.forEach(System.out::println);
    }

    public void testHQL_22() {
        Query query = this.getSession().createQuery("select " +
                "lower(g.name) ," +
                "upper(g.name) ," +
                "trim(g.name)," +
                "concat(g.name, '***')," +
                "length(g.name)" +
                "from GroupEntity g");
        List list = query.list();
    }

    public void testHQL_23() {
        Query query = this.getSession().createQuery("select current_date, current_time, current_timestamp, t.id from Topic t");
        List list = query.list();
        for (Object o : list) {
            Object[] arr = (Object[]) o;
            System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2] + " | " + arr[3]);
        }
    }
}
