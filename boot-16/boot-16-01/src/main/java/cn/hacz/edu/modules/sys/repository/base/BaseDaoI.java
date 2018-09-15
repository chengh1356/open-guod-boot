package cn.hacz.edu.modules.sys.repository.base;


import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class BaseDaoI<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public Serializable save(T o1) {
        BaseEntity o = (BaseEntity) o1;
        o.setCreateTime(LocalDateTime.now());
        o.setUpdateTime(o.getCreateTime());
        if (o.getRemove() == null) {
            o.setRemove(false);
        }
        return getCurrentSession().save(o);
    }


    public T get(Class<T> c, Serializable id) {
        return (T) getCurrentSession().get(c, id);
    }


    public T load(Class<T> c, Serializable id) {
        return (T) getCurrentSession().load(c, id);
    }


    public T get(String hql) {
        Query q = getCurrentSession().createQuery(hql);
        List<T> l = q.list();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }


    public T get(String hql, Map<String, Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        List<T> l = q.list();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }


    public void delete(T o) {
        if (o != null) {
            getCurrentSession().delete(o);
        }
    }


    public void update(T o1) {
        BaseEntity o = (BaseEntity) o1;
        o.setUpdateTime(LocalDateTime.now());
        getCurrentSession().update(o);
    }


    public List<T> find(String hql) {
        Query q = getCurrentSession().createQuery(hql);
        return q.list();
    }


    public List<T> find(String hql, Map<String, Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return q.list();
    }


    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }


    public List<T> find(String hql, int page, int rows) {
        Query q = getCurrentSession().createQuery(hql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }


    public Long count(String hql) {
        Query q = getCurrentSession().createQuery(hql);
        return (Long) q.uniqueResult();
    }


    public Long count(String hql, Map<String, Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return (Long) q.uniqueResult();
    }


    public int execute(String hql) {
        Query q = getCurrentSession().createQuery(hql);
        return q.executeUpdate();
    }


    public int execute(String hql, Map<String, Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return q.executeUpdate();
    }


    public List<Map<String, Object>> findBySql(String sql) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    public List<Map<String, Object>> findBySql(String sql, int page, int rows) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    public List<Map<String, Object>> findBySql(String sql, Map<String, Object> params) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    public List<Map<String, Object>> findBySql(String sql, Map<String, Object> params, int page, int rows) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    public int executeSql(String sql) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        return q.executeUpdate();
    }


    public int executeSql(String sql, Map<String, Object> params) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return q.executeUpdate();
    }


    public BigInteger countBySql(String sql) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        return (BigInteger) q.uniqueResult();
    }


    public BigInteger countBySql(String sql, Map<String, Object> params) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                Object obj = params.get(key);
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    q.setParameterList(key, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    q.setParameterList(key, (Object[]) obj);
                } else {
                    q.setParameter(key, obj);
                }
            }
        }
        return (BigInteger) q.uniqueResult();
    }


    public T get(String hql, Object... params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
        List<T> l = q.list();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }


    public List<T> find(String hql, Object... params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
        return q.list();
    }


    public Long count(String hql, Object... params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
        return (Long) q.uniqueResult();
    }


    public int execute(String hql, Object... params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
        return q.executeUpdate();
    }


    public List<Map<String, Object>> findBySql(String sql, List<Object> params) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    public int executeSql(String sql, Object... params) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
        return q.executeUpdate();
    }


    public List<Map<String, Object>> findBySql(String sql, Object... params) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
        return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    public Map<String, Object> getBySql(String sql, Object... params) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }

        List<Map<String, Object>> l = q.setFirstResult(0).setMaxResults(10).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }


    public Map<String, Object> getBySql(String sql) {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);

        List<Map<String, Object>> l = q.setFirstResult(0).setMaxResults(10).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

}