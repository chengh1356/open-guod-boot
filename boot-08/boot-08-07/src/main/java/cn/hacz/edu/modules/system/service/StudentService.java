package cn.hacz.edu.modules.system.service;

import cn.hacz.edu.modules.system.entity.StudentEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {

    int insert(StudentEntity studentEntity);

    int insertSelective(StudentEntity studentEntity);

    int insertList(List<StudentEntity> studentEntitys);

    int updateByPrimaryKeySelective(StudentEntity studentEntity);

    StudentEntity selectStudentMap(Map<String, Object> map);

    StudentEntity selectStudentObj(StudentEntity studentEntity);

    StudentEntity mapParam(Map<String, Object> params);
}
