package cn.hacz.edu.dao;

import cn.hacz.edu.mapping.many2one.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/22 时间:19:30
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface UserDaoI extends JpaRepository<UserEntity, Serializable> {
    @Query(value = "select * from map_user", nativeQuery = true)
    List<UserEntity> getUserAllBySql();

    @Query(value = "from UserEntity")
    List<UserEntity> getUserAllByJpl();

    @Query("select e from UserEntity e ORDER BY e.time ASC")
    Page<UserEntity> findInOrders(Pageable pageable);
}
