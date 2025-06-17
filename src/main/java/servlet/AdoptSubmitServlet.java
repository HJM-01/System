package servlet;

import DAO.AdoptApplicationDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileStore;

@WebServlet(name = "AdoptSubmitServlet", value = "/adopt/submit")
public class AdoptSubmitServlet extends HttpServlet {
    // 明确拒绝GET请求

    private final AdoptApplicationDAO applicationDAO = new AdoptApplicationDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//设置了HTTP状态码为405 Method Not Allowed
        resp.setContentType("application/json");
        resp.getWriter().write("{\"error\":\"GET method not allowed\"}");//返回了JSON格式的错误信息。
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int userId = (Integer) session.getAttribute("userId");
            int petId = Integer.parseInt(request.getParameter("petId"));

            if (applicationDAO.checkApplicationExists(userId, petId)) {
                out.write("您已提交过该宠物的领养申请，请耐心等待审核！");
                return;
            }

            if (applicationDAO.addApplication(userId, petId)) {
                out.write("申请提交成功，请等待审核！");
            } else {
                out.write("申请提交失败，请稍后再试！");
            }
        } catch (NumberFormatException e) {
            out.write("参数格式错误，请重试！");
        } catch (Exception e) {
            e.printStackTrace();
            out.write("系统错误，请稍后再试！");
        }
    }
}