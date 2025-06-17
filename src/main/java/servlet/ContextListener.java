package servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//这个监听器确保在应用程序启动时建立数据库连接，并在应用程序停止时关闭连接。
@WebListener
public class ContextListener implements ServletContextListener {

    private static Connection connection;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (connection != null) {
            try {
                // 关闭数据库连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
