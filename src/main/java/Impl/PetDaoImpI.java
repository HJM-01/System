//package Impl;
//
//import DAO.PetDAO;
//import entity.Pet;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//public class PetDaoImpI implements PetDAO {
//    @Override
//    public Pet findByName(int petName) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public List<Pet> findPetList() throws SQLException {
//        return List.of();
//    }
//
//    @Override
//    public int addPet(Pet pet) throws SQLException {
//        String sql = "insert into pet(petName, petType, sex, birthday, pic, state, remark) values(?,?,?,?,?,?,?)";
//        int n = 0;
//        try (
//                Connection conn = getConnection();
//                PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, pet.getPetName());
//            ps.setString(2, pet.getPetType());
//            ps.setString(3, pet.getSex());
//            ps.setDate(4, pet.getBirthday() != null ? new java.sql.Date(pet.getBirthday().getTime()) : null);
//            ps.setString(5, pet.getPic()); // 图片路径
//            ps.setInt(6, pet.getState() != null ? pet.getState() : 1); // 默认未领养
//            ps.setString(7, pet.getRemark());
//            n = ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return n;
//    }
//}
