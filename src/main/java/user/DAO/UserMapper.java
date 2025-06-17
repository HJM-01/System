package user.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.user;


public interface UserMapper extends BaseMapper<user> {
    user selectOne(user user);
}