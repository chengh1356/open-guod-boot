package cn.hacz.edu.factory;

import cn.hacz.edu.modules.system.dao.UserDaoI;
import cn.hacz.edu.modules.system.dao.impl.UserDaoImpl;

import java.sql.Connection;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:18:33
 * @JDK 1.8
 * @Description 功能模块：DAO工厂模式
 */
public class DaoFactory {
    /**
     * 功能描述：
     *
     * @param connection
     * @return
     */
    public static UserDaoI getUserDaoInstance(Connection connection) {
        return new UserDaoImpl(connection);
    }
}
