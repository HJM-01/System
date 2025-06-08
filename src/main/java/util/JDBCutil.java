package util;


import java.sql.*;

public class JDBCutil {

    private static final String QD="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/animal_system?serverTimezone=GMT%2B8";
    private static final String USE="root";
    private static final String PAS="123456";
//静态代码块部分
    static {
        try{
            Class.forName(QD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取链接方法
    public static Connection getConnection(){
        Connection con=null;
        try{
            con= DriverManager.getConnection(URL,USE,PAS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    //资源关闭方法
    public static void close(ResultSet rs, PreparedStatement st, Connection con){
        try{
            if(rs!=null){
            rs.close();
        }
            if(st!=null){
            st.close();
        }
            if(con!=null){
            con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
