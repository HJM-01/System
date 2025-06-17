package DAO;

import entity.Pet;

import java.sql.*;

public class AdoptApplicationDAO implements Dao{
    public boolean addApplication(int userId, int petId) {
        String sql = "INSERT INTO adopt_application (user_id, pet_id, state) VALUES (?, ?, 0)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, petId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkApplicationExists(int userId, int petId) {
        String sql = "SELECT COUNT(*) FROM adopt_application WHERE user_id = ? AND pet_id = ? AND state != 2";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, petId);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int insertPet(Pet pet) {
        return 0;
    }
}