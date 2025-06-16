package DAO;//package DAO;

import entity.Pet;
import util.JDBCutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.JDBCutil.*;

public class PetDAO {
    public int insertPet(Pet pet) {
        String sql = "INSERT INTO pet (id, petName, petType, sex,birthday,/* pic, */ state, remark) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pet.getPetName());
            pstmt.setString(2, pet.getPetType());
            pstmt.setString(3, pet.getSex());
            pstmt.setDate(4, new java.sql.Date(pet.getBirthday().getTime()));
            pstmt.setInt(5, pet.getState());
            pstmt.setString(6, pet.getRemark());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close((ResultSet) conn, pstmt, null);
        }
        return result;
    }
//查询所有的pet
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

    //查询所有的pet
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet";

        try (
                Connection conn=JDBCutil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetType(rs.getString("petType"));
                pet.setBirthday(rs.getDate("birthday"));
                pet.setSex(rs.getString("sex"));
                pet.setPic(rs.getString("pic"));
                pet.setState(rs.getInt("state"));
                pet.setRemark(rs.getString("remark"));

                pets.add(pet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // 根据名称模糊查询商品
    public List<Pet> searchPets(String keyword) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn=JDBCutil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pet pet = new Pet();
                    pet.setId(rs.getInt("id"));
                    pet.setPetName(rs.getString("petName"));
                    pet.setPetType(rs.getString("petType"));
                    pet.setBirthday(rs.getDate("birthday"));
                    pet.setSex(rs.getString("sex"));
                    pet.setPic(rs.getString("pic"));
                    pet.setState(rs.getInt("state"));
                    pet.setRemark(rs.getString("remark"));
                    pets.add(pet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
}
