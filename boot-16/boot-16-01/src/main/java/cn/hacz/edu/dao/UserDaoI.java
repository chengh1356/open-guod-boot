package cn.hacz.edu.dao;

import cn.hacz.edu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/10 时间:9:38
 * @JDK 1.8
 * @Description 功能模块：数据库操作
 */
@Repository
public interface UserDaoI extends JpaRepository<UserEntity, Serializable> {
    /**
     * 功能描述：根据年龄查询
     *
     * @param age
     * @return
     */
    UserEntity findAllByAge(Integer age);

    /**
     * 功能描述：
     *
     * @param id
     * @return
     */
    @Transactional(timeout = 10)
    @Query("select u from UserEntity u where u.id = ?1")
    UserEntity findById(Integer id);


    /**
     * 功能描述：
     *
     * @param id
     * @return
     */
    Long countById(Integer id);

    /**
     * 功能描述：
     *
     * @param id
     * @return
     */
    @Query(" select count(t) from UserEntity t where t.id = ?1")
    Integer findFollowerNumberById(Integer id);
}
