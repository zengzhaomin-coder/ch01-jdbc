package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtils {

    private static String driver;   // 驱动
    private static String dbUrl;    // 数据库 url
    private static String dbUser;   // 用户名
    private static String dbPwd;    // 密码

    // 三大对象
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // 读取属性文件中的信息:使用 Properties 类,配合流进行操作
    static {
        // 返回跟本类相关的资源（以流方式返回）
        InputStream inStream = DbUtils.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inStream);
            // 读取:根据关键字得到值
            driver = properties.getProperty("jdbc.driver");
            dbUrl = properties.getProperty("jdbc.dbUrl");
            dbUser = properties.getProperty("jdbc.dbUser");
            dbPwd = properties.getProperty("jdbc.dbPwd");

            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 加载驱动程序类
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 返回连接的方法
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 增删改的方法
    public int executeUpdate(String sql,Object...args) throws SQLException {
        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        }
        return preparedStatement.executeUpdate();
    }

    // 查询的方法
    public ResultSet executeQuery(String sql, Object... args) throws SQLException {
        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        }
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    // 关闭对象的方法，并且释放资源
    public void closeAll() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
