package servlet.AdoptionApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/jsp/admin/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String sourcePage = (String) session.getAttribute("ApplicationPAGE");

        String id = request.getParameter("id");
        String action = request.getParameter("action");
        Integer status = 0;

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

            try (Connection conn = ds.getConnection()) {
                String sql = "update adopt set status=? where id=?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    String a="yes";
                    String b="no";
                    if(a.equals(action)){
                        status=1;
                    }else if(b.equals(action)){
                        status=2;
                    }
                    pstmt.setInt(1, status);
                    pstmt.setString(2, id);

                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        request.setAttribute("message", "操作成功！");

                        if ("/jsp/admin/Adoption_Application.jsp".equals(sourcePage)) {
                            request.getRequestDispatcher("/jsp/admin/Adoption_Application.jsp").forward(request, response);
                        }else if ("/jsp/admin/admin-agree.jsp.jsp".equals(sourcePage)) {
                            request.getRequestDispatcher("/jsp/admin/admin-agree.jsp").forward(request, response);
                        }else{
                            request.getRequestDispatcher("/jsp/admin/admin-disagree.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("message", "操作失败，请重新操作。");

                        if ("/jsp/admin/Adoption_Application.jsp".equals(sourcePage)) {
                            request.getRequestDispatcher("/jsp/admin/Adoption_Application.jsp").forward(request, response);
                        }else if ("/jsp/admin/admin-agree.jsp.jsp".equals(sourcePage)) {
                            request.getRequestDispatcher("/jsp/admin/admin-agree.jsp").forward(request, response);
                        }else{
                            request.getRequestDispatcher("/jsp/admin/admin-disagree.jsp").forward(request, response);
                        }
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("message", "系统错误：无法找到数据库配置！");

            if ("/jsp/admin/Adoption_Application.jsp".equals(sourcePage)) {
                request.getRequestDispatcher("/jsp/admin/Adoption_Application.jsp").include(request, response);
            }else if ("/jsp/admin/admin-agree.jsp.jsp".equals(sourcePage)) {
                request.getRequestDispatcher("/jsp/admin/admin-agree.jsp").include(request, response);
            }else{
                request.getRequestDispatcher("/jsp/admin/admin-disagree.jsp").include(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "数据库操作失败：" + e.getMessage());

            if ("/jsp/admin/Adoption_Application.jsp".equals(sourcePage)) {
                request.getRequestDispatcher("/jsp/admin/Adoption_Application.jsp").include(request, response);
            }else if ("/jsp/admin/admin-agree.jsp.jsp".equals(sourcePage)) {
                request.getRequestDispatcher("/jsp/admin/admin-agree.jsp").include(request, response);
            }else{
                request.getRequestDispatcher("/jsp/admin/admin-disagree.jsp").include(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


