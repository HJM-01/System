package user.service.ImpI;
import entity.user;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import entity.user;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.DAO.UserMapper;
import user.service.UserService;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public user findById(Integer id) {
        return userMapper.selectById(id);
    }


    //EntityWrapper用于构建动态 SQL 条件。它提供了链式调用的方法,在运行时动态地构造查询条件
    @Override
    public List<user> findByName(String userName, Integer state) {
        QueryWrapper<user> wrapper = new QueryWrapper<>();
        if (userName != null && !userName.equals("")){
            wrapper.like("userName", userName);//like 方法添加一个模糊查询条件，查询 userName 字段包含 userName 参数值的记录。
        }
        if (state != null){
            wrapper.eq("state", state);//eq 方法添加一个精确查询条件，查询 state 字段等于 state 参数值的记录。
        }
        return userMapper.selectList(wrapper);//调用 userMapper 的 selectList 方法，传入 wrapper 作为参数，执行查询。
    }

    @Override
    public List<user> showName(String userName) {
        QueryWrapper wrapper = new QueryWrapper();
        if(userName != null && !userName.equals("")){
            wrapper.like("userName",userName);
        }
        return userMapper.selectList(wrapper);
    }

    @Override
    public user loginuser(String userName, String password) {
        user user = new user();
        user.setUserName(userName);
        user user1 = userMapper.selectOne(user);
        if (user1 != null && user1.getPassword().equals(password)) {
            return user1;
        }
        return null;
    }


//    @Override
//    public Integer update(user user) {
//        return userMapper.updateById(user);
//    }

//    @Override
//    public PageInfo<user> allUser(String userName ,Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        QueryWrapper<user> wrapper = new QueryWrapper<>();
//        if(userName != null && !"".equals(userName)){
//            wrapper.like("userName",userName);
//        }
//
////        List<user> list = userMapper.selectList(wrapper);
////        PageInfo<user> pageInfo = new PageInfo<>(list);
////        return pageInfo;
//    }

    @Override
    public int add(user user) {
        return userMapper.insert(user);
    }

    @Override
    public int del(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer update(user user) {
        return 0;
    }
}