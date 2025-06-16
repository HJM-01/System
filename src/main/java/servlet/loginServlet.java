package servlet;

import DAO.UserDao;
import entity.user;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 显示登录页面，如果已登录则跳转
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            redirectToTargetPage(request, response);
            return;
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        try {
            // 验证用户登录
            user user = userDao.validateUser(username, password);
            if (user != null) {
                // 创建会话
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
                session.setAttribute("userName", user.getUserName());

                // 记住我功能
                if ("on".equals(rememberMe)) {
                    Cookie userIdCookie = new Cookie("userId", String.valueOf(user.getId()));
                    userIdCookie.setMaxAge(7 * 24 * 60 * 60); // 7天有效期
                    userIdCookie.setPath("/");
                    response.addCookie(userIdCookie);
                }

                // 登录成功后重定向
                redirectToTargetPage(request, response);
            } else {
                request.setAttribute("errorMessage", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "系统错误，请稍后再试");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void redirectToTargetPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String redirect = request.getParameter("redirect");
        if (redirect != null && !redirect.isEmpty()) {
            // 解码URL防止特殊字符问题
            response.sendRedirect(java.net.URLDecoder.decode(redirect, "UTF-8"));
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    // 可选：添加注销功能
    @WebServlet("/logout")
    public static class LogoutServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 使会话失效
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

            // 清除记住我cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("userId".equals(cookie.getName())) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        break;
                    }
                }
            }

            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}