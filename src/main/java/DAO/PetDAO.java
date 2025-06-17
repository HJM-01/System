package DAO;

import entity.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static util.JDBCutil.close;

public class PetDAO implements Dao {
    public Optional<Pet> getPetById(int petId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "SELECT id, pet_name as petName, pet_type as petType, sex, birthday, remark FROM pet WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, petId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetType(rs.getString("petType"));
                pet.setSex(rs.getString("sex"));
                pet.setBirthday(rs.getDate("birthday"));
                pet.setRemark(rs.getString("remark"));
                return Optional.of(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, conn);
        }
        return Optional.empty();
    }

    public String[] getPetPics(int petId) {
        List<String> pics = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT pic FROM pet WHERE id = ?")) {

            pstmt.setInt(1, petId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String picStr = rs.getString("pic");
                    if (picStr != null && !picStr.isEmpty()) {
                        // 根据您的数据，图片是以逗号分隔的字符串
                        return picStr.split(",");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    @Override
    public int insertPet(Pet pet) {
        return 0;
    }

}