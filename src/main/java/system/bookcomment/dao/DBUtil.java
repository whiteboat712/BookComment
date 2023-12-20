package system.bookcomment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String driver="com.mysql.cj.jdbc.Driver";
    static String ul="jdbc:mysql://localhost:3306/book_comment";
    static String user="root";
    static String pwd="123456";
    // static Connection con;

    static {
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ul,user,pwd);
    }

    // 关闭数据库连接
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
