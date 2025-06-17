package user.DAO;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.AdoptAnimal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdoptAnimalMapper extends BaseMapper<AdoptAnimal> {
        List<AdoptAnimal> all(@Param("adoptTime")String adoptTime);

}
