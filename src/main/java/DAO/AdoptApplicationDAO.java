package DAO;

import entity.Pet;

import java.sql.*;
import java.util.Optional;

import static util.JDBCutil.getConnection;

public class AdoptApplicationDAO implements Dao {

    // 创建领养申请记录
    public boolean simpleCreateApplication(String userName, String telephone,
                                           String petName, String sex,
                                           String email, String address,
                                           String petId) throws SQLException {
        String sql = "INSERT INTO adoption_applications " +
                "(user_name, telephone, pet_name, sex, email, address, pet_id, application_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, telephone);
            pstmt.setString(3, petName);
            pstmt.setString(4, sex);
            pstmt.setString(5, email);
            pstmt.setString(6, address);
            pstmt.setString(7, petId);

            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean addApplication(int userId, int petId) {
        return false;
    }

    // 检查是否已存在申请记录
    public boolean checkApplicationExists(int userId, int petId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM adoption_applications WHERE user_id = ? AND pet_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, petId);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    @Override
    public int insertPet(Pet pet) {
        return 0;
    }

    @Override
    public Optional<Pet> getPetById(int petId) {
        return Optional.empty();
    }

    // 根据用户名和电话获取用户ID
    public Integer getUserIdByNameAndPhone(String userName, String telephone) throws SQLException {
        String sql = "SELECT id FROM user WHERE userName = ? AND telephone = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, telephone);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt("id") : null;
            }
        }
    }
}

