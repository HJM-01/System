package servlet.Manager;

import entity.Admins;
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

@WebServlet("/jsp/admin/byIdManagerServlet")
public class ByIdManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明

        String id = request.getParameter("id");
        Admins admin = null;

        // 通过 JNDI 获取连接池
        try {
            // 1. 获取 JNDI 上下文
            Context ctx = new InitialContext();
            // 2. 查找数据源（名称需与 context.xml 中的 Resource.name 一致）
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
            // 3. 从连接池获取连接
            try (Connection conn = ds.getConnection()) {
                String sql = "select id,adminName,adminPwd,realName,telephone,Email,birthday,sex from admins where id=?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        admin = new Admins(
                                rs.getInt("id"),
                                rs.getString("adminName"),
                                rs.getString("adminPwd"),
                                rs.getString("realName"),
                                rs.getString("telephone"),
                                rs.getString("Email"),
                                rs.getDate("birthday"),
                                rs.getString("sex")
                        );
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
        System.out.println("admin:"+admin);

        request.setAttribute("Admin", admin);
        request.getRequestDispatcher("/jsp/admin/adminadd-updata.jsp").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
