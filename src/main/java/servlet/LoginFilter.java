//package servlet;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//
//@WebFilter(urlPatterns = {"/adopt/*", "/user/*"})
//public class LoginFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        HttpSession session = httpRequest.getSession(false);
//
//        if (session == null || session.getAttribute("userId") == null) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
//            return;
//        }
//
//        chain.doFilter(request, response);
//    }
//}
//
