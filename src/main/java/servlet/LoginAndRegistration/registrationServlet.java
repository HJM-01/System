package servlet.LoginAndRegistration;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String secondPassword = request.getParameter("SecondPassword");
        String telephone = request.getParameter("phoneNumber");

        // 客户端验证
        if (!password.equals(secondPassword)) {
            request.setAttribute("Message","两次输入的密码不一致！");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/registration.jsp");
            rd.forward(request,response);
            return;
        }

        // 通过 JNDI 获取连接池
        try {
            // 1. 获取 JNDI 上下文
            Context ctx = new InitialContext();
            // 2. 查找数据源（名称需与 context.xml 中的 Resource.name 一致）
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
            // 3. 从连接池获取连接
            try (Connection conn = ds.getConnection()) {
                String sql = "INSERT INTO user (username, password, telephone) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    pstmt.setString(3, telephone);
                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        request.setAttribute("Message", "注册成功");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
                        rd.forward(request,response);
                    } else {
                        request.setAttribute("Message", "注册失败，请重新注册。");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/registration.jsp");
                        rd.forward(request,response);
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("Message", "系统错误：无法找到数据库配置！");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/registration.jsp");
            rd.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("Message", "数据库操作失败：" + e.getMessage());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/registration.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}