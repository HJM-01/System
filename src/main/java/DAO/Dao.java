package DAO;

import entity.Pet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface Dao {
    default DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Animals");
        } catch (NamingException ne) {
            System.out.println("异常" + ne);
        }
        return dataSource;
    }

    default Connection getConnection() throws SQLException {
        DataSource dataSource = getDataSource();
        if (dataSource == null) {
            throw new SQLException("Data source not available");
        }
        return dataSource.getConnection();
    }

    static void close(ResultSet rs, PreparedStatement st, Connection con) {
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

    boolean addApplication(int userId, int petId);

    boolean checkApplicationExists(int userId, int petId) throws SQLException;

    int insertPet(Pet pet);

    boolean deletePet(int petId);

    Optional<Pet> getPetById(int petId);
}
