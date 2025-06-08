//package DAO;
//
//import entity.User;
//
//import java.sql.*;
//import java.util.List;
//
//import static java.sql.DriverManager.getConnection;
//
//public class UserDaolmpl implements UserDao {
//    @Override
//    public int addUsers(entity.User user) throws SQLException {
//        int n=0;
//        try(
//                Connection conn = getConnection();
//                PreparedStatement ptmt= conn.prepareStatement("INSERT INTO `user` (userName,password,telephone) VALUE(?,?,?)");
//                ){
//            ptmt.setString(1,user.getUserName());
//            ptmt.setString(2,user.getPassword());
//            ptmt.setString(3,user.getTelephone());
//            n=ptmt.executeUpdate();
//        }catch (SQLException se) {
//            se.printStackTrace();
//        }
//        return n;
//    }
//
//    @Override
//    public int deleteUsers(User user) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public User findUsersById(int id) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public List<User> findAllUsers() throws SQLException {
//        return List.of();
//    }
//}
