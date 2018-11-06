package cn.hacz.edu.repository.base;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/6 时间:11:45
 * @JDK 1.8
 * @Description 功能模块：
 */
public class BaseDaoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDaoI<T, ID> {
    private EntityManager entityManager;

    public BaseDaoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

}
