package DAO;

import entity.Pet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

import static util.JDBCutil.getConnection;

public class AdoptApplicationDAO implements Dao {

    // 创建领养申请记录
    public boolean simpleCreateApplication(String userName, String petName,String sex,
                                           String telephone, String email,
                                           String address) throws SQLException {
        String sql = "INSERT INTO adopt " +
                "(username, petName,sex, telephone, email, address) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, petName);
            pstmt.setString(3, sex);
            pstmt.setString(4, telephone);
            pstmt.setString(5, email);
            pstmt.setString(6, address);

            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public DataSource getDataSource() {
        return Dao.super.getDataSource();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return Dao.super.getConnection();
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
    public boolean deletePet(int petId) {
        return false;
    }

    @Override
    public Optional<Pet> getPetById(int petId) {
        return Optional.empty();
    }

    @Override
    public List<Pet> getPetsByStatus(int i) {
        return List.of();
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

