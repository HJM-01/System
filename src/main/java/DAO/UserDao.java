package DAO;

import entity.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static util.JDBCutil.close;
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
    // 根据ID查询用户信息
    public user getUserById(int id) {
        user user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "SELECT * FROM user WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new user();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setSex(rs.getString("sex"));
                user.setTelephone(rs.getString("telephone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close((ResultSet) conn, pstmt, (Connection) rs);
        }
        return user;
    }

    //登录验证
    public user validateUser(String username, String password) {
        //userName as  user_name给列起别名
        String sql = "SELECT id, userName as  user_name FROM user WHERE userName = ? AND password = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user user = new user();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("userName"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}