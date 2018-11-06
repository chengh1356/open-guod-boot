package cn.hacz.edu.repository.base;


import cn.hacz.edu.repository.parameter.Operator;
import cn.hacz.edu.repository.parameter.Predicate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author guod
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private EntityManager entityManager;

    private static final String NOT_RESULT = "没有查到结果集";

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> get(ID id) {
        Assert.notNull(id, "ID不能为空");
        Class<T> domainType = getDomainClass();
        return Optional.ofNullable(entityManager.find(domainType, id));
    }

    @Override
    public Optional<T> get(String jpql) {
        Class<T> domainType = getDomainClass();
        TypedQuery<T> createQuery = entityManager.createQuery(jpql, domainType);
        List<T> resultList = createQuery.getResultList();
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Optional<T> get(String jpql, Map<String, Object> params) {
        List<T> resultList = find(jpql, params, null);
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }

    @Override
    public Optional<T> get(String jpql, Object... params) {
        List<T> resultList = find(jpql, params, null);
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }

    @Override
    public List<T> find(String jpql) {
        Class<T> domainType = getDomainClass();
        return find(jpql, domainType, new Object[]{}, null);
    }

    @Override
    public List<T> find(String jpql, Map<String, Object> params) {
        Class<T> domainType = getDomainClass();
        return find(jpql, domainType, params, null);
    }

    @Override
    public List<T> find(String jpql, Object... params) {
        Class<T> domainType = getDomainClass();
        return find(jpql, domainType, params, null);
    }

    @Override
    public List<T> find(String jpql, Pageable pageable) {
        Class<T> domainType = getDomainClass();
        return find(jpql, domainType, new HashMap<>(), pageable);
    }

    @Override
    public List<T> find(String jpql, Map<String, Object> params, Pageable pageable) {
        Class<T> domainType = getDomainClass();
        return find(jpql, domainType, params, pageable);
    }

    @Override
    public List<T> find(String jpql, Pageable pageable, Object... params) {
        Class<T> domainType = getDomainClass();
        return find(jpql, domainType, params, pageable);
    }

    @Override
    public List<T> find(String jpql, Object[] params, Pageable pageable) {
        Class<T> domainType = getDomainClass();
        return find(jpql, domainType, params, pageable);
    }

    @Transactional
    public void delete(T entity) {
        Assert.notNull(entity, "被删除的对象不能为空");
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    @Transactional
    public <S extends T> S update(S entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void deleteById(ID id) {
        Assert.notNull(id, "ID不能为空");
        delete(get(id).orElseThrow(() -> new EmptyResultDataAccessException(String.format("No %s entity with id %s exists!", getDomainClass().getTypeName(), id), 1)));
    }

    @Override
    public <O> List<O> find(String jpql, Class<O> clazz) {
        return find(jpql, clazz, new HashMap<>(), null);
    }

    @Override
    public <O> List<O> find(String jpql, Class<O> clazz, Pageable pageable) {
        return find(jpql, clazz, new HashMap<>(), pageable);
    }

    @Override
    public <O> List<O> find(String jpql, Class<O> clazz, Map<String, Object> params) {
        return find(jpql, clazz, params, null);
    }

    @Override
    public <O> List<O> find(String jpql, Class<O> clazz, Map<String, Object> params, Pageable pageable) {
        TypedQuery<O> query = entityManager.createQuery(jpql, clazz);

        if (params != null) {
            for (Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @Override
    public <O> List<O> find(String jpql, Class<O> clazz, Object... params) {
        return find(jpql, clazz, params, null);
    }

    @Override
    public <O> List<O> find(String jpql, Class<O> clazz, Pageable pageable, Object... params) {
        return find(jpql, clazz, params, pageable);
    }

    @Override
    public <O> List<O> find(String jpql, Class<O> clazz, Object[] params, Pageable pageable) {
        TypedQuery<O> query = entityManager.createQuery(jpql, clazz);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <O> O find(String jpql, TypeReference<O> type) {
        Type t = type.getType();
        TypedQuery<O> query = entityManager.createQuery(jpql, (Class<O>) t);
        return query.getSingleResult();


    }

    @Override
    @Transactional
    public int execute(String hql) {
        return execute(hql, new Object[]{});
    }

    @Override
    @Transactional
    public int execute(String hql, Map<String, Object> params) {
        Query query = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public int execute(String hql, Object... params) {
        Query query = entityManager.createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.executeUpdate();
    }

    @Override
    public <O> Optional<O> get(String jpql, Class<O> clazz) {
        TypedQuery<O> createQuery = entityManager.createQuery(jpql, clazz);
        List<O> resultList = createQuery.getResultList();

        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));

    }

    @Override
    public <O> Optional<O> get(String jpql, Class<O> clazz, Map<String, Object> params) {
        List<O> resultList = find(jpql, clazz, params, null);
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }

    @Override
    public <O> Optional<O> get(String jpql, Class<O> clazz, Object... params) {
        List<O> resultList = find(jpql, clazz, params, null);
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }

    @Override
    public <O> Optional<O> getBySql(String sql, Class<O> clazz) {
        Query query = entityManager.createNativeQuery(sql, clazz);
        List<O> resultList = query.getResultList();
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }


    @Override
    public <O> Optional<O> getBySql(String sql, Class<O> clazz, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(sql, clazz);

        if (params != null && !params.isEmpty()) {
            for (Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        List<O> resultList = query.getResultList();
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }

    @Override
    public <O> Optional<O> getBySql(String sql, Class<O> clazz, Object... params) {
        Query query = entityManager.createNativeQuery(sql, clazz);

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }

        List<O> resultList = query.getResultList();
        Assert.notEmpty(resultList, NOT_RESULT);
        return Optional.ofNullable(resultList.get(0));
    }


    @Override
    public <O> List<O> findBySql(String sql, Class<O> clazz) {
        return findBySql(sql, clazz, new HashMap<>(), null);
    }

    @Override
    public <O> List<O> findBySql(String sql, Class<O> clazz, Pageable pageable) {
        return findBySql(sql, clazz, new HashMap<>(), pageable);
    }

    @Override
    public <O> List<O> findBySql(String sql, Class<O> clazz, Map<String, Object> params) {
        return findBySql(sql, clazz, params, null);
    }

    @Override
    public <O> List<O> findBySql(String sql, Class<O> clazz, Map<String, Object> params, Pageable pageable) {
        Query query = entityManager.createNativeQuery(sql, clazz);
        if (params != null) {
            for (Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @Override
    public <O> List<O> findBySql(String sql, Class<O> clazz, Object... params) {
        return findBySql(sql, clazz, params, null);
    }

    @Override
    public <O> List<O> findBySql(String sql, Class<O> clazz, Pageable pageable, Object... params) {
        return findBySql(sql, clazz, params, pageable);
    }

    @Override
    public <O> List<O> findBySql(String sql, Class<O> clazz, Object[] params, Pageable pageable) {
        Query query = entityManager.createNativeQuery(sql, clazz);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }


    @Override
    public int executeBySql(String sql) {
        return executeBySql(sql, new Object[]{});
    }

    @Override
    public int executeBySql(String sql, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.executeUpdate();
    }

    @Override
    public int executeBySql(String sql, Object... params) {
        Query query = entityManager.createNativeQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.executeUpdate();
    }

    @Override
    public List<Object[]> findBySql(String sql, Object[] params, Pageable pageable) {
        Query query = entityManager.createNativeQuery(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @Override
    public List<Object[]> findBySql(String sql, Map<String, Object> params, Pageable pageable) {
        Query query = entityManager.createNativeQuery(sql);
        if (params != null) {
            for (Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @Override
    public List<Object[]> findBySql(String sql, Object... params) {
        return findBySql(sql, params, null);
    }

    @Override
    public List<Object[]> findBySql(String sql, Pageable pageable, Object... params) {
        return findBySql(sql, params, pageable);
    }


    @Override
    public List<Object[]> findBySql(String sql) {
        return findBySql(sql, new Object[]{}, null);
    }

    @Override
    public List<Object[]> findBySql(String sql, Pageable pageable) {
        return findBySql(sql, new Object[]{}, pageable);
    }

    @Override
    public List<Object[]> findBySql(String sql, Map<String, Object> params) {
        return findBySql(sql, params, null);
    }

    @Override
    public Optional<Object[]> getBySql(String sql, Map<String, Object> params) {
        List<Object[]> findBySql = findBySql(sql, params, null);
        Assert.notEmpty(findBySql, NOT_RESULT);
        return Optional.ofNullable(findBySql.get(0));
    }

    @Override
    public Optional<Object[]> getBySql(String sql, Object... params) {
        List<Object[]> findBySql = findBySql(sql, params, null);
        Assert.notEmpty(findBySql, NOT_RESULT);
        return Optional.ofNullable(findBySql.get(0));
    }

    // ====================guod扩展=================

    @Override
    public T findOne(String condition, Object... values) {
        if (isEmpty(condition)) {
            throw new NullPointerException("条件不能为空!");
        }
        T result = null;
        try {
            // result = (T) Query.createQuery(condition, values).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public Page<T> findAll(Iterable<Predicate> predicates, Operator operator, Pageable pageable) {
        return null;
    }


}
