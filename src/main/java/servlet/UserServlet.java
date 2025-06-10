package servlet;


import DAO.UserDao;
import entity.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;
@MultipartConfig()
@WebServlet("/jsp/admin/adminAdd1")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求和响应编码
        resp.setContentType("text/html;charset=UTF-8");

        // 从表单获取参数
        user user = new user();
//        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUserName(req.getParameter("userName"));
//        user.setPassword(req.getParameter("password"));
        user.setSex(req.getParameter("sex"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setTelephone(req.getParameter("telephone"));
        user.setEmail(req.getParameter("email"));

//        user.setAddress(req.getParameter("address"));
//        user.setPic(req.getParameter("pic"));
//        user.setState(Integer.parseInt(req.getParameter("state")));

        // 调用Service层处理业务逻辑
        if (userService.addUser(user)) {
            resp.getWriter().println("用户添加成功");
        } else {
            resp.getWriter().println("用户添加失败");
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}