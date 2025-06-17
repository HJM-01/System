package DAO;

import entity.Pet;
import util.JDBCutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PetDAO implements Dao {

    @Override
    public int insertPet(Pet pet) {
        String sql = "INSERT INTO pet (petName, petType, sex, birthday, pic, state, remark) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = JDBCutil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pet.getPetName());
            pstmt.setString(2, pet.getPetType());
            pstmt.setString(3, pet.getSex());
            pstmt.setDate(4, new java.sql.Date(pet.getBirthday().getTime()));
            pstmt.setString(5, pet.getPic());
            pstmt.setInt(6, pet.getState());
            pstmt.setString(7, pet.getRemark());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return affectedRows;
        } catch (SQLException e) {
            throw new DataAccessException("插入宠物失败", e);
        }
    }

    @Override
    public Optional<Pet> getPetById(int petId) {
        System.out.println("[DEBUG] Querying pet ID: " + petId);
        String sql = "SELECT * FROM pet WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, petId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pet pet = mapRowToPet(rs);//映射（转换）为一个 Pet 类型的对象。
                    System.out.println("[DEBUG] Found pet: " + pet); // 检查查询结果
                    return Optional.of(mapRowToPet(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("[ERROR] Database error: " + e.getMessage());
            throw new DataAccessException("查询宠物失败, ID: " + petId, e);
        }
        return Optional.empty();
    }

    public boolean isPetAdopted(int petId) {
        String sql = "SELECT state FROM adoptAnimal WHERE petId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, petId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("state") != AdoptionStatus.PENDING;
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("查询领养状态失败, 宠物ID: " + petId, e);
        }
        return false;
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pets.add(mapRowToPet(rs));
            }
        } catch (SQLException e) {
            throw new DataAccessException("获取所有宠物失败", e);
        }
        return pets;
    }

    public List<Pet> searchPets(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllPets();
        }

        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE petName LIKE ? OR petType LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String likePattern = "%" + keyword + "%";
            pstmt.setString(1, likePattern);
            pstmt.setString(2, likePattern);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    pets.add(mapRowToPet(rs));
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("搜索宠物失败, 关键字: " + keyword, e);
        }
        return pets;
    }

    private Pet mapRowToPet(ResultSet rs) throws SQLException {
        Pet pet = new Pet();
        pet.setId(rs.getInt("id"));
        pet.setPetName(rs.getString("petName"));
        pet.setPetType(rs.getString("petType"));
        pet.setSex(rs.getString("sex"));
        pet.setBirthday(rs.getDate("birthday"));
        pet.setPic(rs.getString("pic"));
        pet.setState(rs.getInt("state"));
        pet.setRemark(rs.getString("remark"));
        return pet;
    }

    @Override
    public boolean addApplication(int userId, int petId) {
        return false;
    }

    @Override
    public boolean checkApplicationExists(int userId, int petId) {
        return false;
    }
}

interface AdoptionStatus {
    int PENDING = 1;
    int APPROVED = 2;
    int REJECTED = 3;
}

class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

}