package servlet.UserMaServlet;
import entity.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/jsp/admin/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        user user = null;
        ArrayList<user> userArrayList = new ArrayList<>();
//        记账号数
        int n=0;

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
            try (Connection conn = ds.getConnection()) {
                String sql = "select id,userName,sex,age,telephone, Email,address from user";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        user = new user(
                                rs.getInt("id"),
                                rs.getString("userName"),
                                rs.getString("sex"),
                                rs.getInt("age"),
                                rs.getString("telephone"),
                                rs.getString("Email"),
                                rs.getString("address")
                        );
                        n++;
                        userArrayList.add(user);
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
            response.getWriter().write("系统错误：无法找到数据库配置！");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("数据库操作失败：" + e.getMessage());
        }

        request.setAttribute("n",n);
        request.setAttribute("userArrayList", userArrayList);
        request.getRequestDispatcher("/jsp/admin/admin-1.jsp").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

