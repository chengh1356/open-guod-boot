package cn.hacz.edu.jpql;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/24 时间:8:29
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
@Transactional(rollbackFor = RuntimeException.class)
public class JpaJPQL {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void testJPQL_01() {
    }
}
