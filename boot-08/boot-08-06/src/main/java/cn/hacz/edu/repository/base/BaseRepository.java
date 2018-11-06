package cn.hacz.edu.repository.base;


import cn.hacz.edu.repository.parameter.Operator;
import cn.hacz.edu.repository.parameter.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@NoRepositoryBean
public interface BaseRepository<T, ID> extends Repository<T, ID> {

    <S extends T> S save(S entity);

    void delete(T entity);

    <S extends T> S update(S entity);

    void deleteById(ID id);

    Optional<T> get(ID id);

    Optional<T> get(String jpql);

    <O> Optional<O> get(String jpql, Class<O> clazz);

    <O> Optional<O> get(String jpql, Class<O> clazz, Map<String, Object> params);

    <O> Optional<O> get(String jpql, Class<O> clazz, Object... params);

    Optional<T> get(String jpql, Map<String, Object> params);

    Optional<T> get(String jpql, Object... params);

    List<T> find(String jpql);

    List<T> find(String jpql, Pageable pageable);

    List<T> find(String jpql, Map<String, Object> params);

    List<T> find(String jpql, Map<String, Object> params, Pageable pageable);

    List<T> find(String jpql, Object... params);

    List<T> find(String jpql, Pageable pageable, Object... params);

    List<T> find(String jpql, Object[] params, Pageable pageable);

    <O> List<O> find(String jpql, Class<O> clazz);

    <O> List<O> find(String jpql, Class<O> clazz, Pageable pageable);

    <O> List<O> find(String jpql, Class<O> clazz, Map<String, Object> params);

    <O> List<O> find(String jpql, Class<O> clazz, Map<String, Object> params, Pageable pageable);

    <O> List<O> find(String jpql, Class<O> clazz, Object... params);

    <O> List<O> find(String jpql, Class<O> clazz, Pageable pageable, Object... params);

    <O> List<O> find(String jpql, Class<O> clazz, Object[] params, Pageable pageable);

    <O> O find(String jpql, TypeReference<O> type);

    int execute(String jpql);

    int execute(String jpql, Map<String, Object> params);

    int execute(String jpql, Object... params);

    //	Optional<T> getBySql(String sql);

    <O> Optional<O> getBySql(String sql, Class<O> clazz);

    <O> Optional<O> getBySql(String sql, Class<O> clazz, Map<String, Object> params);

    <O> Optional<O> getBySql(String sql, Class<O> clazz, Object... params);

    Optional<Object[]> getBySql(String sql, Map<String, Object> params);

    Optional<Object[]> getBySql(String sql, Object... params);

    List<Object[]> findBySql(String sql);

    List<Object[]> findBySql(String sql, Pageable pageable);

    List<Object[]> findBySql(String sql, Map<String, Object> params);

    List<Object[]> findBySql(String sql, Map<String, Object> params, Pageable pageable);

    List<Object[]> findBySql(String sql, Object... params);

    List<Object[]> findBySql(String sql, Pageable pageable, Object... params);

    List<Object[]> findBySql(String sql, Object[] params, Pageable pageable);

    <O> List<O> findBySql(String sql, Class<O> clazz);

    <O> List<O> findBySql(String sql, Class<O> clazz, Pageable pageable);

    <O> List<O> findBySql(String sql, Class<O> clazz, Map<String, Object> params);

    <O> List<O> findBySql(String sql, Class<O> clazz, Map<String, Object> params, Pageable pageable);

    <O> List<O> findBySql(String sql, Class<O> clazz, Object... params);

    <O> List<O> findBySql(String sql, Class<O> clazz, Pageable pageable, Object... params);

    <O> List<O> findBySql(String sql, Class<O> clazz, Object[] params, Pageable pageable);


    int executeBySql(String sql);

    int executeBySql(String sql, Map<String, Object> params);

    int executeBySql(String sql, Object... params);

    // ====================guod扩展=================

    T findOne(String condition, Object... objects);

    Page<T> findAll(Iterable<Predicate> predicates, Operator operator, Pageable pageable);

}
