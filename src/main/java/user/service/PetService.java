package user.service;

import user.DAO.PetDAO;
import entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface PetService {
//    PageInfo<Pet> pets(Integer pageNum, Integer pagesize);

    Pet findById(Integer id);

    Integer create(Pet pet);

//    PageInfo<Pet> allPet(String petType, Integer pageNum, Integer pageSize);

    int add(Pet pet);

    int update(Pet pet);

    int del(Integer id);
}


//public interface PetService {//ageNum 表示当前页码  pagesize 表示每页显示的记录数  PageInfo<Pet> 是一个包含分页信息的对象。
//    PageInfo<Pet> pets(Integer pageNum, Integer pagesize);//该方法用于获取宠物信息的分页数据。
//    Pet findById(Integer id);
//    Integer create(Pet pet);
//    PageInfo<Pet> allPet(String petType, Integer pageNum, Integer pageSize);
//    int add(Pet pet);
//    int update(Pet pet);
//    int del(Integer id);
//}

