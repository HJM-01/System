package servlet;

import DAO.AdoptApplicationDAO;
import DAO.UserDao;
import entity.user;
import entity.user;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;


import DAO.AdoptApplicationDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleAdoptServlet", value = "/adopt/simple-submit")
public class SimpleAdoptServlet extends HttpServlet {

    private final AdoptApplicationDAO applicationDAO = new AdoptApplicationDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 获取表单数据
            String userName = request.getParameter("userName");
            String telephone = request.getParameter("telephone");
            String petName = request.getParameter("petName");
            String sex = request.getParameter("sex");
            String email = request.getParameter("email");
            String address = request.getParameter("address");

            // 插入数据库
            boolean success = applicationDAO.simpleCreateApplication(
                    userName, telephone, petName,
                    sex, email, address
            );

            if (success) {
                out.write("申请提交成功");
            } else {
                out.write("申请提交失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("系统错误: " + e.getMessage());
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}