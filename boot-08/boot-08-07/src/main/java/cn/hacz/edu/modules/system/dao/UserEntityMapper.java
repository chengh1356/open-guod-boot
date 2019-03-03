package cn.hacz.edu.modules.system.dao;

import cn.hacz.edu.modules.system.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserEntityMapper {
    int saveUser(Map<String, Object> params);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    int deleteByPrimaryKey(Integer userId);

    int updateByPrimaryKey(UserEntity record);

    int updateByPrimaryKeySelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer userId);

}