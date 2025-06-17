package user.service.ImpI;

import entity.Pet;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.DAO.PetMapper;
import user.service.PetService;


import java.util.List;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    @Resource
    private PetMapper petMapper;

//    @Override
//    public PageInfo<Pet> pets(Integer pageNum, Integer pagesize) {
//        PageHelper.startPage(pageNum, pagesize);
//        List<Pet> pets = petMapper.selectList(null);
//        PageInfo<Pet> pageInfo = new PageInfo<Pet>(pets, 3);
//        return pageInfo;
//    }

    @Override
    public Pet findById(Integer id) {
        return petMapper.selectById(id);
    }

    @Override
    public Integer create(Pet pet) {
        return petMapper.insert(pet);
    }

//    @Override
//    public PageInfo<Pet> allPet(String petType, Integer pageNum, Integer pageSize) {
//        // 开始分页
//        PageHelper.startPage(pageNum, pageSize);
//
//        // 创建实体包装器
//        EntityWrapper<Pet> wrapper = new EntityWrapper<>();
//
//        // 判断宠物类型是否为空或空字符串
//        if (petType != null && !"".equals(petType)) {
//            // 根据宠物类型进行模糊查询
//            wrapper.like("petType", petType);
//        }

//        // 查询宠物列表
//        List<Pet> pets = petMapper.selectList(wrapper);
//
//        // 创建分页信息对象
//        PageInfo<Pet> pageInfo = new PageInfo<>(pets, 3);
//
//        // 返回分页信息对象
//        return pageInfo;
//    }


    @Override
    public int add(Pet pet) {
        return petMapper.insert(pet);
    }

    @Override
    public int update(Pet pet) {
        return petMapper.updateById(pet);
    }

    @Override
    public int del(Integer id) {
        return petMapper.deleteById(id);
    }
}
