package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaolmpl implements UserDao {
    @Override
    public int addUsers(User user) throws SQLException {
        User user1 = new User();
        int n=0;
        try(
                Connection conn = getConnection();
                PreparedStatement ptmt= conn.prepareStatement("insert into User values (?,?,?,?,?)");
                ){
            ptmt.setString(1,user1.getUsername());
            ptmt.setString(2,user1.getPassword());
            ptmt.setInt(3,user1.getPhoneNumber());
            n=ptmt.executeUpdate();
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteUsers(User user) throws SQLException {
        return 0;
    }

    @Override
    public User findUsersById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUsers() throws SQLException {
        return List.of();
    }
}
