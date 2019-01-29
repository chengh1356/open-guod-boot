package cn.hacz.edu.service;

import java.util.List;
import cn.hacz.edu.entity.LogEntity;
public interface LogService{

    int insert(LogEntity logEntity);

    int insertSelective(LogEntity logEntity);

    int insertList(List<LogEntity> logEntitys);

    int updateByPrimaryKeySelective(LogEntity logEntity);
}
