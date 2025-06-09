package service;


import DAO.UserDao;
import entity.user;

public class UserService {
    private UserDao userDao = new UserDao();

    // 添加用户
    public boolean addUser(user user) {
        int result = userDao.insertUser(user);
        return result > 0;
    }
}
