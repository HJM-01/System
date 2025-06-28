package servlet.AdoptionApplication;
import entity.Adopt;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/jsp/admin/FindApplicationServlet")
public class FindApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明

        HttpSession session = request.getSession();
        String sourcePage = (String) session.getAttribute("ApplicationPAGE");

        Adopt adopt = null;
        ArrayList<Adopt> adoptArrayList = new ArrayList<>();

        // 通过 JNDI 获取连接池
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

            try (Connection conn = ds.getConnection()) {
                String sql = "select * from adopt where status=?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    if ("/jsp/admin/Adoption_Application.jsp".equals(sourcePage)) {
                        // PAGE1 专属处理逻辑
                        int n=0;
                        pstmt.setInt(1,n);
                    }else if ("/jsp/admin/admin-agree.jsp.jsp".equals(sourcePage)) {
                        int n=1;
                        pstmt.setInt(1,n);
                    }else{
                        int n=2;
                        pstmt.setInt(1,n);
                    }
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        adopt = new Adopt(
                                rs.getInt("id"),
                                rs.getString("userName"),
                                rs.getString("petName"),
                                rs.getString("sex"),
                                rs.getString("telephone"),
                                rs.getString("email"),
                                rs.getString("address"),
                                rs.getString("status")
                        );
                        adoptArrayList.add(adopt);
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
        request.setAttribute("adoptList", adoptArrayList);

        if ("/jsp/admin/Adoption_Application.jsp".equals(sourcePage)) {
            request.getRequestDispatcher("/jsp/admin/Adoption_Application.jsp").forward(request, response);
        }else if ("/jsp/admin/admin-agree.jsp.jsp".equals(sourcePage)) {
            request.getRequestDispatcher("/jsp/admin/admin-agree.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/jsp/admin/admin-disagree.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

