package servlet;

import entity.Admins;
import entity.Pet;
import jakarta.servlet.ServletException;
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

public class petServlet22 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明
        Pet pet = null;
        ArrayList<Pet> petArrayList = new ArrayList<>();
        // 通过 JNDI 获取连接池
        try {
            // 1. 获取 JNDI 上下文
            Context ctx = new InitialContext();
            // 2. 查找数据源（名称需与 context.xml 中的 Resource.name 一致）
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
            // 3. 从连接池获取连接
            try (Connection conn = ds.getConnection()) {
                String sql = "select * from pet";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        pet = new Pet(
                                rs.getInt("id"),
                                rs.getString("petName"),
                                rs.getString("petType"),
                                rs.getString("sex"),
                                rs.getDate("birthday"),
                                rs.getString("pic"),
                                rs.getInt("state"),
                                rs.getString("remark")
                        );
                        petArrayList.add(pet);

                        System.out.println("图片：");
                        System.out.println(pet.getPic());
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
        System.out.println("图片：");
        System.out.println(petArrayList.get(1).getPic());
        request.setAttribute("pets",petArrayList);
        request.getRequestDispatcher("/jsp/admin/admin-3.jsp").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
