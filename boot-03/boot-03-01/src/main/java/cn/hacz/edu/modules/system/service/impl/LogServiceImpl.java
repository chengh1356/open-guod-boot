package cn.hacz.edu.modules.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.hacz.edu.modules.system.entity.LogEntity;
import cn.hacz.edu.modules.system.dao.LogMapper;
import cn.hacz.edu.modules.system.service.LogService;

@Service
public class LogServiceImpl implements LogService{

    @Resource
    private LogMapper logMapper;

    @Override
    public int insert(LogEntity logEntity){
        return logMapper.insert(logEntity);
    }

    @Override
    public int insertSelective(LogEntity logEntity){
        return logMapper.insertSelective(logEntity);
    }

    @Override
    public int insertList(List<LogEntity> logEntitys){
        return logMapper.insertList(logEntitys);
    }

    @Override
    public int updateByPrimaryKeySelective(LogEntity logEntity){
        return logMapper.updateByPrimaryKeySelective(logEntity);
    }
}
