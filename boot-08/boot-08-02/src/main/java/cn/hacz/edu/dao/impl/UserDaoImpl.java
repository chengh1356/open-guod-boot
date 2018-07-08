package cn.hacz.edu.dao.impl;

import cn.hacz.edu.dao.UserDaoI;
import cn.hacz.edu.domain.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/7 时间:21:33
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDaoI {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public int add(StudentEntity studentEntity) {
        return jdbcTemplate.update("insert into student(name, age,create_date_time) values(?, ?, ?)",
                studentEntity.getName(), studentEntity.getAge(), new Date());
    }

    @Override
    @Transactional
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from student where id = ?", id);
    }

    @Override
    @Transactional
    public int update(Integer id, StudentEntity studentEntity) {
        return jdbcTemplate.update("update student set name = ? ,age = ? where id = ? ", studentEntity.getName(), studentEntity.getAge(), id);
    }

    @Override
    public StudentEntity getUserById(Integer id) {
        List<StudentEntity> list = jdbcTemplate.query("select * from student where id = ?", new Object[]{id}, new BeanPropertyRowMapper(StudentEntity.class));
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<StudentEntity> getUserList() {
        List<StudentEntity> list = jdbcTemplate.query("select * from student", new Object[]{}, new BeanPropertyRowMapper(StudentEntity.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }

    }
}
