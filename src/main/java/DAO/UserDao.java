package DAO;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao {
    public int addUsers(User user)throws SQLException;
    public int deleteUsers(User user)throws SQLException;
    public User findUsersById(int id)throws SQLException;
    public List<User> findAllUsers()throws SQLException;
}
