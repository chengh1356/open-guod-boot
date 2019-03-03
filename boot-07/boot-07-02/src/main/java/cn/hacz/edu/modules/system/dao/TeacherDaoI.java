package cn.hacz.edu.modules.system.dao;

import cn.hacz.edu.modules.system.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/9 时间:15:36
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface TeacherDaoI extends JpaRepository<TeacherEntity, Serializable> {
}
