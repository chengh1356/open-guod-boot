package cn.hacz.edu.modules.system.service;

import java.util.List;
import cn.hacz.edu.modules.system.entity.LogEntity;
public interface LogService{

    int insert(LogEntity logEntity);

    int insertSelective(LogEntity logEntity);

    int insertList(List<LogEntity> logEntitys);

    int updateByPrimaryKeySelective(LogEntity logEntity);
}
