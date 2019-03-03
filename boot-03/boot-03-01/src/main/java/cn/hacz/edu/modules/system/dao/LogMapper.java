package cn.hacz.edu.modules.system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.hacz.edu.modules.system.entity.LogEntity;

@Mapper
public interface LogMapper {
    int insert(@Param("logEntity") LogEntity logEntity);

    int insertSelective(@Param("logEntity") LogEntity logEntity);

    int insertList(@Param("logEntitys") List<LogEntity> logEntitys);

    int updateByPrimaryKeySelective(@Param("logEntity") LogEntity logEntity);
}
