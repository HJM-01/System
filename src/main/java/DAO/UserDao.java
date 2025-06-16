package DAO;

import entity.Pet;
import entity.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


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
    public Optional<user> getUserById(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "SELECT id, user_name as userName, sex, telephone, email, address FROM user WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user user = new user();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setSex(rs.getString("sex"));
                user.setTelephone(rs.getString("telephone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, conn);
        }
        return Optional.empty();
    }

    @Override
    public int insertPet(Pet pet) {
        return 0;
    }
    public user validateUser(String username, String password) {
        String sql = "SELECT id, userName  FROM user WHERE userName = ? AND password = ?";

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