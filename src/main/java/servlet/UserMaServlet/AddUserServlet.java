package servlet.UserMaServlet;

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
import java.sql.SQLException;

@WebServlet("/jsp/admin/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明

        String userName = request.getParameter("userName");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String telephone = request.getParameter("telephone");
        String Email = request.getParameter("Email");
        String address=request.getParameter("address");

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
            try (Connection conn = ds.getConnection()) {
                String sql = "INSERT INTO user (userName,password,sex,age,telephone, Email,address) VALUES (?,?,?,?,?,?,?)";

                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, userName);
                    pstmt.setString(2, password);
                    pstmt.setString(3, sex);
                    pstmt.setString(4, age);
                    pstmt.setString(5, telephone);
                    pstmt.setString(6, Email);
                    pstmt.setString(7, address);

                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        request.setAttribute("message", "添加成功！");
                        request.getRequestDispatcher("/jsp/admin/FindAllUserServlet").forward(request, response);
                    } else {
                        request.setAttribute("message", "添加失败，请重新添加。");
                        request.getRequestDispatcher("/jsp/admin/admin-1add.jsp").forward(request, response);
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("message", "系统错误：无法找到数据库配置！");
            request.getRequestDispatcher("/jsp/admin/admin-1add.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "数据库操作失败：" + e.getMessage());
            request.getRequestDispatcher("/jsp/admin/admin-1add.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
