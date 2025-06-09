package DAO;


import entity.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static util.JDBCutil.getConnection;

public class UserDao {
    // 插入用户数据
    public int insertUser(user user) {
        String sql = "INSERT INTO user " +
                "(id, userName, password, sex, age, telephone, email, address, pic, state) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getSex());
            pstmt.setInt(5, user.getAge());
            pstmt.setString(6, user.getTelephone());
            pstmt.setString(7, user.getEmail());
            pstmt.setString(8, user.getAddress());
            pstmt.setString(9, user.getPic());
            pstmt.setInt(10, user.getState());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}