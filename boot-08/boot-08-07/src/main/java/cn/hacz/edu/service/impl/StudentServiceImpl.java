package cn.hacz.edu.service.impl;

import cn.hacz.edu.model.StudentEntity;
import cn.hacz.edu.mapper.StudentMapper;
import cn.hacz.edu.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int insert(StudentEntity studentEntity) {
        return studentMapper.insert(studentEntity);
    }

    @Override
    public int insertSelective(StudentEntity studentEntity) {
        return studentMapper.insertSelective(studentEntity);
    }

    @Override
    public int insertList(List<StudentEntity> studentEntitys) {
        return studentMapper.insertList(studentEntitys);
    }

    @Override
    public int updateByPrimaryKeySelective(StudentEntity studentEntity) {
        return studentMapper.updateByPrimaryKeySelective(studentEntity);
    }

    @Override
    public StudentEntity selectStudentMap(Map<String, Object> map) {
        return studentMapper.getStudentMap(map);
    }

    @Override
    public StudentEntity selectStudentObj(StudentEntity studentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", studentEntity.getName());
        map.put("age", studentEntity.getAge());
        return studentMapper.getStudentBean(map);
    }
}
