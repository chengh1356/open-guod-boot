package cn.hacz.edu.modules.system.dao;

import cn.hacz.edu.modules.system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/24 时间:8:38
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface UserDaoI extends JpaRepository<UserEntity, Serializable> {
}
