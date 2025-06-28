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

@WebServlet("/jsp/admin/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明

        String id = request.getParameter("id");

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

            try (Connection conn = ds.getConnection()) {
                String sql = "delete from user where id=?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, id);

                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        request.setAttribute("message", "删除成功！");
                        request.getRequestDispatcher("/jsp/admin/FindAllUserServlet").forward(request, response);
                    } else {
                        request.setAttribute("message", "删除失败，请重新删除。");
                        request.getRequestDispatcher("/jsp/admin/FindAllUserServlet").forward(request, response);
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("message", "系统错误：无法找到数据库配置！");
            request.getRequestDispatcher("/jsp/admin/FindAllUserServlet").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "数据库操作失败：" + e.getMessage());
            request.getRequestDispatcher("/jsp/admin/FindAllUserServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
