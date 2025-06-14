package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static util.JDBCutil.close;
import static util.JDBCutil.getConnection;

public class AdoptApplicationDAO {
    // 添加领养申请
    public boolean addApplication(int userId, int petId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean result = false;
        try {
            conn = getConnection();
            String sql = "INSERT INTO adopt_application (user_id, pet_id) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, petId);
            int affectedRows = pstmt.executeUpdate();
            result = affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close((ResultSet) conn, pstmt, null);
        }
        return result;
    }
    // 检查用户是否已提交过该宠物的领养申请
    public boolean checkApplicationExists(int userId, int petId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            conn = getConnection();
            String sql = "SELECT 1 FROM adopt_application WHERE user_id = ? AND pet_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, petId);
            rs = pstmt.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close((ResultSet) conn, pstmt, (Connection) rs);
        }

        return exists;
    }
}
