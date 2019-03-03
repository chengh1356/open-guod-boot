package cn.hacz.edu.modules.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.hacz.edu.modules.system.entity.TeacherEntity;
import cn.hacz.edu.modules.system.dao.TeacherEntityMapper;
import cn.hacz.edu.modules.system.service.TeacherEntityService;

@Service
public class TeacherEntityServiceImpl implements TeacherEntityService{

    @Resource
    private TeacherEntityMapper teacherEntityMapper;

    @Override
    public int insert(TeacherEntity teacherEntity){
        return teacherEntityMapper.insert(teacherEntity);
    }

    @Override
    public int insertSelective(TeacherEntity teacherEntity){
        return teacherEntityMapper.insertSelective(teacherEntity);
    }

    @Override
    public int insertList(List<TeacherEntity> teacherEntitys){
        return teacherEntityMapper.insertList(teacherEntitys);
    }

    @Override
    public int updateByPrimaryKeySelective(TeacherEntity teacherEntity){
        return teacherEntityMapper.updateByPrimaryKeySelective(teacherEntity);
    }
}
