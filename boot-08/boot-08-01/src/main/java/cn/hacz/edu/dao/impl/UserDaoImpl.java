package cn.hacz.edu.dao.impl;

import cn.hacz.edu.dao.UserDaoI;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:18:35
 * @JDK 1.8
 * @Description 功能模块：
 */
public class UserDaoImpl implements UserDaoI {

    private Connection conn;

    private PreparedStatement pstmt;

    /**
     * 讲解：如果想要使用数据层进行原子性的功能实现，必须要提供connection接口对象操作。另外由于开发中，业务层需要调用数据层，所以数据库的打开和关闭交给业务层处理。
     *
     * @param conn
     */
    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }
}
