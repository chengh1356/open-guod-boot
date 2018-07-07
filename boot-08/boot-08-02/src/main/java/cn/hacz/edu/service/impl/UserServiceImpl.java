package cn.hacz.edu.service.impl;

import cn.hacz.edu.domain.entity.StudentEntity;
import cn.hacz.edu.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/7 时间:15:59
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(String name, Integer age) {
        String sql = "insert into student(name, age) values(?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from student where name = ?", name);
    }

    @Override
    public List<StudentEntity> getStudentAll() {
        String sql = "SELECT * FROM student WHERE id = 1";
        RowMapper<StudentEntity> rowMapper = new BeanPropertyRowMapper<>(StudentEntity.class);
        List<StudentEntity> query = jdbcTemplate.query(sql, rowMapper, 1);
        return query;
    }
}