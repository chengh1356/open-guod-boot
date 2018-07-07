package cn.hacz.edu.dao;

import cn.hacz.edu.domain.entity.StudentEntity;

import java.util.List;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/7 时间:15:58
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface UserDaoI {

    int add(StudentEntity studentEntity);

    int delete(Integer id);

    int update(Integer id, StudentEntity studentEntity);

    StudentEntity getUserById(Integer id);

    List<StudentEntity> getUserList();
}
