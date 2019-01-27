package cn.hacz.edu.service;

import cn.hacz.edu.model.StudentEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {

    int insert(StudentEntity studentEntity);

    int insertSelective(StudentEntity studentEntity);

    int insertList(List<StudentEntity> studentEntitys);

    int updateByPrimaryKeySelective(StudentEntity studentEntity);

    StudentEntity selectStudent(Map<String, Object> map);
}
