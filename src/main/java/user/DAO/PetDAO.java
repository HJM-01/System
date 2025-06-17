package user.DAO;

import entity.Pet;

import java.util.List;

public interface PetDAO {
    Pet findById(Long id);
    List<Pet> findAll();
    List<String> findPetPics(Long id); // 添加此方法声明
    void insert(Pet pet);
    void update(Pet pet);
    void delete(Long id);
}