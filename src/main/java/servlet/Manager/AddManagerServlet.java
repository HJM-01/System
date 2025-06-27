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

@WebServlet("/jsp/admin/adminadd-addServlet")
public class AddManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明

        String adminname = request.getParameter("adminName");
        String adminPwd=request.getParameter("adminPwd");
        String Email = request.getParameter("Email");
        String telephone = request.getParameter("telephone");
        String sex=request.getParameter("sex");

//        System.out.println("接收到的参数:");
//        System.out.println("adminName: " + adminname);
//        System.out.println("adminPwd: " + adminPwd);
//        System.out.println("Email: " + Email);
//        System.out.println("telephone: " + telephone);
//        System.out.println("sex: " + sex);



        // 通过 JNDI 获取连接池
        try {
            // 1. 获取 JNDI 上下文
            Context ctx = new InitialContext();
            // 2. 查找数据源（名称需与 context.xml 中的 Resource.name 一致）
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
            // 3. 从连接池获取连接
            try (Connection conn = ds.getConnection()) {
                String sql = "INSERT INTO admins (adminName,adminPwd, Email, telephone,sex) VALUES (?,?,?,?,?)";
                //                    System.out.println("执行的SQL: " + sql);s
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, adminname);
                    pstmt.setString(2, adminPwd);
                    pstmt.setString(3, Email);
                    pstmt.setString(4, telephone);
                    pstmt.setString(5, sex);

                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        request.setAttribute("message", "添加成功！");
                        request.getRequestDispatcher("/jsp/admin/FindAllManagerServlet").forward(request, response);
                    } else {
                        request.setAttribute("message", "添加失败，请重新添加。");
                        request.getRequestDispatcher("/jsp/admin/adminadd-add.jsp").forward(request, response);
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("message", "系统错误：无法找到数据库配置！");
            request.getRequestDispatcher("/jsp/admin/adminadd-add.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "数据库操作失败：" + e.getMessage());
            request.getRequestDispatcher("/jsp/admin/adminadd-add.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
