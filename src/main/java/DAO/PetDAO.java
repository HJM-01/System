package DAO;//package DAO;

import entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static util.JDBCutil.close;
import static util.JDBCutil.getConnection;

public class PetDAO {
    public int insertPet(Pet pet) {
        String sql = "INSERT INTO pet (id, petName, petType, sex, birthday, pic, state, remark) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pet.getId());
            pstmt.setString(2, pet.getPetName());
            pstmt.setString(3, pet.getPetType()); // 若前端无该字段，可设默认值或调整
            pstmt.setString(4, pet.getSex());
            pstmt.setDate(5, new java.sql.Date(pet.getBirthday().getTime()));
            pstmt.setString(6, pet.getPic());
            pstmt.setInt(7, pet.getState());
            pstmt.setString(8, pet.getRemark());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close((ResultSet) conn, pstmt, null);
        }
        return result;
    }
}