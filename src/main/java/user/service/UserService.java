package user.service;

import entity.user;


import java.util.List;
//接口扣的各方法
public interface UserService {
    List<user> findByName(String userName, Integer state);
    List<user> showName(String userName);
    //登录
    user loginuser(String userName,String password);
    //注册
    int add(user user);
    //修改
//    Integer update(user user);
    user findById(Integer id);
//    PageInfo<user> allUser(String userName, Integer pageNum, Integer pageSize);
    int del(Integer id);

    Integer update(user user);
}
