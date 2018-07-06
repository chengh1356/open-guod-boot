package cn.hacz.edu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:18:21
 * @JDK 1.8
 * @Description 功能模块：
 */
public class DataBaseConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123654";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql:///test";
    private Connection connection = null;

    /**
     * 功能描述：构造器主要目的是进行数据库连接
     */
    private DataBaseConnection() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述：取得一个数据库连接对象，这个对象在构造方法中取得
     *
     * @return Connection接口对象
     */
    private Connection getConnection() {
        return this.connection;
    }

    /**
     * 功能描述：关闭数据库连接
     */
    private void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 功能模块：测试类
     *
     * @param args
     */
    public static void main(String[] args) {
        DataBaseConnection baseConnection = new DataBaseConnection();
        Connection connection = baseConnection.getConnection();
        baseConnection.close();
        System.out.println(connection);
    }

}
