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
    // 根据用户ID获取用户信息
    public Optional<user> getUserById(int userId) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user user = new user();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setTelephone(rs.getString("telephone"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("address"));
                user.setPic(rs.getString("pic"));
                user.setState(rs.getInt("state"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    // 在UserDao中添加
    public Optional<user> getUserByNameAndid(String id, String userName) throws SQLException {
        String sql = "SELECT * FROM user WHERE userName = ? AND id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userName);
            stmt.setString(2, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user user = new user();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setSex(rs.getString("sex"));
                    user.setAge(rs.getInt("age"));
                    user.setTelephone(rs.getString("telephone"));
                    user.setEmail(rs.getString("Email"));
                    user.setAddress(rs.getString("address"));
                    user.setPic(rs.getString("pic"));
                    user.setState(rs.getInt("state"));
                    return Optional.of(user);
                }
            }
        }
        return Optional.empty();
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


    @Override
    public boolean addApplication(int userId, int petId) {
        return false;
    }

    @Override
    public boolean checkApplicationExists(int userId, int petId) {
        return false;
    }

    @Override
    public int insertPet(Pet pet) {
        return 0;
    }

    @Override
    public Optional<Pet> getPetById(int petId) {
        return Optional.empty();
    }

}