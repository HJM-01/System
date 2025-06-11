package DAO;

import entity.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static util.JDBCutil.getConnection;

public class UserDao implements Dao {
    // 插入用户数据
    public int insertUser(user user) {
        String sql = "INSERT INTO user (userName, password, sex, age, telephone, email, address, pic, state) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSex());
            pstmt.setInt(4, user.getAge());
            pstmt.setString(5, user.getTelephone());
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getAddress());
            pstmt.setString(8, user.getPic());
//            pstmt.setInt(9, user.getState());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            // 使用日志框架记录异常信息
            // Log.error("Error inserting user data", e);
            e.printStackTrace();
            return 0;
        }
    }
}