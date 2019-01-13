package cn.hacz.edu.hql;

import cn.hacz.edu.mapping.hql2jpql.Category;
import cn.hacz.edu.mapping.hql2jpql.Msg;
import cn.hacz.edu.mapping.hql2jpql.Topic;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/23 时间:20:35
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
@Transactional(rollbackFor = RuntimeException.class)
public class HibernateHQL01 {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 功能描述：
     */
    public Session getSessionUnwrap() {
        return entityManager.unwrap(Session.class);
    }

    /**
     * 功能描述：
     */
    public Session getSessionDelegate() {
        return (Session) entityManager.getDelegate();
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setName("c" + i);
            this.getSessionUnwrap().save(c);
        }
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(1);
            Topic t = new Topic();
            t.setCategory(c);
            t.setTitle("t" + i);
            t.setCreateDate(new Date());
            this.getSessionUnwrap().save(t);
        }
        for (int i = 0; i < 10; i++) {
            Topic t = new Topic();
            t.setId(1);
            Msg m = new Msg();
            m.setCont("m" + i);
            m.setTopic(t);
            this.getSessionDelegate().save(m);
        }
    }

    public void testHQL_02() {
        List<Category> from_category = this.getSessionDelegate().createQuery("from Category", Category.class).list();
        from_category.forEach(e -> System.out.println(e.getName()));

    }

    public void testHQL_03() {
        List<Category> list = this.getSessionUnwrap().createQuery("from Category c where c.name>'c5'", Category.class).list();
        list.forEach(e -> System.out.println(e.getName()));
    }

    public void testHQL_04() {
        List<Category> list = this.getSessionUnwrap().createQuery("from Category c order by c.name desc", Category.class).list();
        list.forEach(e -> System.out.println(e.getName()));
    }

    public void testHQL_05() {
        List<Category> list = this.getSessionUnwrap().createQuery("select distinct c from Category c order by c.name desc", Category.class).list();
        list.forEach(e -> System.out.println(e.getName()));
    }

    public void testHQL_06() {
        List<Category> list = this.getSessionUnwrap().createQuery("from Category c where c.id>:min and c.id<:max", Category.class)
                .setParameter("min", 2)
                .setParameter("max", 10)
                .list();
        list.forEach(e -> System.out.println(e.getName()));
    }

    public void testHQL_07() {
        List<Category> list = this.getSessionUnwrap().createQuery("from Category c where c.id>? and c.id<?", Category.class)
                .setParameter(0, 2)
                .setParameter(1, 10)
                .list();
        list.forEach(e -> System.out.println(e.getName()));
    }

    public void testHQL_08() {
        List<Category> list = this.getSessionUnwrap().createQuery("from Category c order by c.name desc", Category.class)
                .setMaxResults(4)
                .setFirstResult(2)
                .list();
        list.forEach(e -> System.out.println(e.getId() + "-" + e.getName()));
    }

    public void testHQL_09() {
        List<Category> list = this.getSessionUnwrap().createQuery("select c.id,  c.name from Category c order by c.name desc", Category.class)
                .setMaxResults(4)
                .setFirstResult(2)
                .list();
        list.forEach(e -> System.out.println());
    }

    /**
     * 设定fetch type 为lazy后将不会有第二条sql语句
     */
    public void testHQL_10() {
        List<Topic> list = this.getSessionUnwrap().createQuery("from Topic t where t.category.id = 5", Topic.class)
                .list();
        list.forEach(e -> {
            System.out.println(e.getTitle());
            System.out.println(e.getCategory().getName());
        });
    }

    public void testHQL_11() {
        List<Msg> list = this.getSessionUnwrap().createQuery("from Msg m where m.topic.category.id = 5", Msg.class)
                .list();
        list.forEach(e -> {
            System.out.println(e.getCont());
        });
    }

    public void testHQL_12() {
        List list = this.getSessionUnwrap().createQuery("select new cn.hacz.edu.mapping.admin.hql01.MsgInfo(" +
                "m.id," +
                " m.cont," +
                " m.topic.title," +
                " m.topic.category.name" +
                ") " +
                "from Msg m")
                .list();

    }

    /**
     * 为什么不能直接写Category名，而必须写t.category
     * 因为有可能存在多个成员变量（同一个类），需要指明用哪一个成员变量的连接条件来做连接
     */
    public void testHQL_13() {
        List list = this.getSessionUnwrap().createQuery("select t.title, c.name from Topic t join t.category c ").list();
    }

    /**
     * 学习使用uniqueResult
     */
    public void testHQL_14() {
        Query q = this.getSessionDelegate().createQuery("from Msg m where m = :MsgToSearch");
        Msg m = new Msg();
        m.setId(1);
        q.setParameter("MsgToSearch", m);
        Msg mResult = (Msg) q.uniqueResult();
    }

    public void testHQL_15() {
        Query q = this.getSessionDelegate().createQuery("select count(*) from Msg m");
        long count = (Long) q.uniqueResult();
        System.out.println(count);
    }

    public void testHQL_16() {
        Query q = this.getSessionDelegate().createQuery("select max(m.id), min(m.id), avg(m.id), sum(m.id) from Msg m");
        Object[] o = (Object[]) q.uniqueResult();
        System.out.println(o[0] + "-" + o[1] + "-" + o[2] + "-" + o[3]);
    }

    public void testHQL_17() {
        List<Msg> list = this.getSessionDelegate().createQuery("from Msg m where m.id between 3 and 5", Msg.class).list();
    }

    public void testHQL_18() {
        List<Msg> list = this.getSessionDelegate().createQuery("from Msg m where m.id in (3,4, 5)", Msg.class).list();
    }

    /**
     * is null   is not null
     */
    public void testHQL_19() {
        List<Msg> list = this.getSessionDelegate().createQuery("from Msg m where m.cont is null", Msg.class).list();
    }
}