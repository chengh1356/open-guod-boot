package cn.hacz.edu.modules.system.dao;

import cn.hacz.edu.modules.system.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherEntityMapper {
    int insert(@Param("teacherEntity") TeacherEntity teacherEntity);

    int insertSelective(@Param("teacherEntity") TeacherEntity teacherEntity);

    int insertList(@Param("teacherEntitys") List<TeacherEntity> teacherEntitys);

    int updateByPrimaryKeySelective(@Param("teacherEntity") TeacherEntity teacherEntity);
}
