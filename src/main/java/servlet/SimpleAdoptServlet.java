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

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 1. 获取所有表单数据
            String userName = request.getParameter("userName");
            String telephone = request.getParameter("telephone");
            String petName = request.getParameter("petName");
            String sex = request.getParameter("sex");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String petId = request.getParameter("petId");

            // 2. 直接插入数据库
            boolean success = applicationDAO.simpleCreateApplication(
                    userName, telephone, petName,
                    sex, email, address, petId
            );

            if (success) {
                out.write("申请提交成功");
            } else {
                out.write("申请提交失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.write("系统错误");
        }
    }
}