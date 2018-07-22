package cn.hacz.edu.dao;

import cn.hacz.edu.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/22 时间:20:29
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface UserDao {
    int insert(UserEntity userEntity);

    UserEntity getUserById(String id);
}
