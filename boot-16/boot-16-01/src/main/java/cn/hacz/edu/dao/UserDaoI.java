package cn.hacz.edu.dao;

import cn.hacz.edu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/10 时间:9:38
 * @JDK 1.8
 * @Description 功能模块：
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
}
