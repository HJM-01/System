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

    @Override
    public Pet getPetById(Long id) {
        return petMapper.selectById(id);
    }
}
