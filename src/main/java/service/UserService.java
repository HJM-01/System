package service;


import DAO.UserDao;
import entity.user;

public class UserService {
    private UserDao userDao = new UserDao();

    // 判断添加用户是否成功
    public boolean addUser(user user) {
        int result = userDao.insertUser(user);
        return result > 0;
    }
}
