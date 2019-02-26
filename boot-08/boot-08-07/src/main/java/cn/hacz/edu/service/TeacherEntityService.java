package cn.hacz.edu.service;

import java.util.List;
import cn.hacz.edu.entity.TeacherEntity;
public interface TeacherEntityService{

    int insert(TeacherEntity teacherEntity);

    int insertSelective(TeacherEntity teacherEntity);

    int insertList(List<TeacherEntity> teacherEntitys);

    int updateByPrimaryKeySelective(TeacherEntity teacherEntity);
}
