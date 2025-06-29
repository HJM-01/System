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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/jsp/admin/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        从前端获取是管理员还是用户
        String identity=request.getParameter("identity");


        if("user".equals(identity)){
            try {
                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

                try (Connection conn = ds.getConnection()) {
                    String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, username);
                        pstmt.setString(2, password);

                        try (ResultSet rs = pstmt.executeQuery()) {
                            if (rs.next()) {
                                //转发到用户后台
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/user/home.jsp");
                                rd.forward(request, response);
                            } else {
                                //登录失败
                                request.setAttribute("errorMessage", "登录失败，请重新检查！");
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
                                rd.forward(request, response);
                            }
                        }
                    }
                }
            } catch (NamingException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "系统错误：数据库配置问题");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
                rd.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "数据库操作失败：" + e.getMessage());
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
                rd.forward(request, response);
            }
        }else if("admin".equals(identity)){
            try {
                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

                try (Connection conn = ds.getConnection()) {
                    String sql = "SELECT * FROM admins WHERE adminName = ? AND adminPwd= ?";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, username);
                        pstmt.setString(2, password);

                        try (ResultSet rs = pstmt.executeQuery()) {
                            if (rs.next()) {
                                // 转发到管理员后台
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/admin-1.jsp");
                                rd.forward(request, response);
                            } else {
                                // 登录失败
                                request.setAttribute("errorMessage", "登录失败，请重新检查！");
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
                                rd.forward(request, response);
                            }
                        }
                    }
                }
            } catch (NamingException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "系统错误：数据库配置问题");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
                rd.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "数据库操作失败：" + e.getMessage());
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
                rd.forward(request, response);
            }
        }else{
            request.setAttribute("errorMessage", "身份错误！请选择！");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}