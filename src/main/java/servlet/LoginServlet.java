package servlet;

import DAO.UserDao;
import entity.user;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "LoginServlet", value = "/jsp/login")
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
        // 显示登录页面
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
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
                response.sendRedirect("/jsp/admin/admin.jsp");
                redirectToTargetPage(request, response);
            } else {
                request.setAttribute("errorMessage", "用户名或密码错误");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "系统错误，请稍后再试");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void redirectToTargetPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String redirect = request.getParameter("redirect");
        if (redirect != null && !redirect.isEmpty()) {
            try {
                // 双重解码确保URL正确
                String decodedRedirect = URLDecoder.decode(redirect, "UTF-8");
                // 防止开放重定向漏洞
                if (decodedRedirect.startsWith(request.getContextPath()) ||
                        decodedRedirect.startsWith("/")) {
                    response.sendRedirect(decodedRedirect);
                } else {
                    response.sendRedirect(request.getContextPath() + "/adoptionInformange.jsp");
                }
            } catch (Exception e) {
                response.sendRedirect(request.getContextPath() + "/adoptionInformange.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/adoptionInformange.jsp");
        }
    }
    }