package servlet.Manager;

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

@WebServlet("/jsp/admin/updateManagerServlet")
public class UpdateManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明

        String id = request.getParameter("id");
        String adminName = request.getParameter("adminName");
        String adminPwd=request.getParameter("adminPwd");
        String realName=request.getParameter("realName");
        String Email = request.getParameter("Email");
        String telephone = request.getParameter("telephone");
        String birthday=request.getParameter("birthday");
        String sex=request.getParameter("sex");

        // 通过 JNDI 获取连接池
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

            try (Connection conn = ds.getConnection()) {
                String sql = "update admins set adminName=?,adminPwd=?,realName=?, Email=?, telephone=?,birthday=?,sex=? where id=?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, adminName);
                    pstmt.setString(2, adminPwd);
                    pstmt.setString(3, realName);
                    pstmt.setString(4, Email);
                    pstmt.setString(5, telephone);
                    pstmt.setString(6, birthday);
                    pstmt.setString(7, sex);
                    pstmt.setString(8, id);
                    //头像，描述

                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        request.setAttribute("message", "修改成功！");
                        request.getRequestDispatcher("/jsp/admin/FindAllManagerServlet").forward(request, response);
                    } else {
                        request.setAttribute("message", "修改失败，请重新修改。");
                        request.getRequestDispatcher("/jsp/admin/FindAllManagerServlet").forward(request, response);
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("message", "系统错误：无法找到数据库配置！");
            request.getRequestDispatcher("/jsp/admin/FindAllManagerServlet").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "数据库操作失败：" + e.getMessage());
            request.getRequestDispatcher("/jsp/admin/FindAllManagerServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

