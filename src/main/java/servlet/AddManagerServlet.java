package servlet;

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

@WebServlet("/jsp/admin/admin-1add")
public class AddManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明

        String adminname = request.getParameter("adminName");
        String Email = request.getParameter("Email");
        String telephone = request.getParameter("telephone");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");

        // 通过 JNDI 获取连接池
        try {
            // 1. 获取 JNDI 上下文
            Context ctx = new InitialContext();
            // 2. 查找数据源（名称需与 context.xml 中的 Resource.name 一致）
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
            // 3. 从连接池获取连接
            try (Connection conn = ds.getConnection()) {
                String sql = "INSERT INTO admins (adminName, Email, telephone,realName,sex) VALUES (?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, adminname);
                    pstmt.setString(2, Email);
                    pstmt.setString(3, telephone);
                    pstmt.setString(4, realName);
                    pstmt.setString(5, sex);
                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        response.getWriter().write("添加成功！");
                    } else {
                        response.getWriter().write("添加失败，请重新添加。");
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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
