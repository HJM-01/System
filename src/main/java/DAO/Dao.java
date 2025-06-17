package DAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Dao {
    private DataSource getDataSource(){
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource=(DataSource) context.lookup("java:comp/env/jdbc/Animals");
        }catch (NamingException ne){
            System.out.println("异常"+ne);
        }
        return dataSource;
    }

    public default Connection getConnection() throws SQLException {
        DataSource dataSource = getDataSource();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        }catch (SQLException sqle){
            System.out.println("异常" +sqle);
        }
        return conn;
    }
    public static void close(ResultSet rs, PreparedStatement st, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.cancel();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


