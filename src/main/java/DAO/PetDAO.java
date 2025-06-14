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
            pstmt.setInt(1, pet.getId());//这个id不是自增吗咋还要
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

    // 根据ID查询宠物详情
    public Pet getPetById(int id) {
        Pet pet = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "SELECT * FROM pet WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setPetName(rs.getString("pet_name"));
                pet.setPetType(rs.getString("pet_type"));
                pet.setSex(rs.getString("sex"));
                pet.setBirthday(rs.getDate("birthday"));
                pet.setPic(rs.getString("pic"));
                pet.setState(rs.getInt("state"));
                pet.setRemark(rs.getString("remark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close((ResultSet) conn, pstmt, (Connection) rs);
        }
        return pet;
    }
    // 获取宠物图片列表（假设图片路径以逗号分隔存储）
    public String[] getPetPics(int id) {
        Pet pet = getPetById(id);
        if (pet != null && pet.getPic() != null) {
            return pet.getPic().split(",");
        }
        return new String[0];
    }

}
