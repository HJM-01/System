package user.service;


//import com.github.pagehelper.PageInfo;
import entity.AdoptAnimal;

public interface AdoptAnimalService {
    Integer create(AdoptAnimal adoptAnimal);
//    PageInfo<AdoptAnimal> all(String adoptTime,Integer pageNum, Integer pageSize);
    int update(Integer id, Integer state);

    void createAdopt(AdoptAnimal adopt);
//    PageInfo<AdoptAnimal> allAdoptAnimal(String userName,Integer pageNum,Integer pageSize, Integer state);
}
