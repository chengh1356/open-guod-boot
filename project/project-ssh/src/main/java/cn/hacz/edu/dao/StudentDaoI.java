package cn.hacz.edu.dao;

import cn.hacz.edu.entity.StudentEntity;
import cn.hacz.edu.vo.student.StudentAddReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/27 时间:16:16
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface StudentDaoI extends JpaRepository<StudentEntity, Serializable> {
    @Query(value = " from StudentEntity s where s.name=:name ")
    List<StudentEntity> findParamsName(@Param("name") String name);

    @Query(value = " from StudentEntity s where s.name like %:name% ")
    List<StudentEntity> findParamsLikeName(@Param("name") String name);

    @Query(value = " from StudentEntity s where s.age=?1 ")
    List<StudentEntity> findParamsAge(Integer name);

    @Query(value = " from StudentEntity s where s.name=:#{#studentAddReq.name} and s.age=:#{#studentAddReq.age} ")
    List<StudentEntity> findParamsVo(@Param("studentAddReq") StudentAddReq studentAddReq);

    @Query("select e from StudentEntity e ORDER BY e.dateTime ASC")
    Page<StudentEntity> findInOrders(Pageable pageable);
}
