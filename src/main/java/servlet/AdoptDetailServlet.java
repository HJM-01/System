package servlet;

import DAO.AdoptApplicationDAO;
import entity.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adopt/submit")
public class AdoptDetailServlet extends HttpServlet {
    private AdoptApplicationDAO applicationDAO = new AdoptApplicationDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应的字符编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            // 检查用户是否登录
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("user") == null) {
                response.getWriter().write("请先登录再提交领养申请！");
                return;
            }

            // 获取表单数据
            String userIdStr = request.getParameter("id");
            String petIdStr = request.getParameter("petId");

            // 参数验证
            if (userIdStr == null || petIdStr == null) {
                response.getWriter().write("参数错误，请重试！");
                return;
            }

            int userId = Integer.parseInt(userIdStr);
            int petId = Integer.parseInt(petIdStr);

            // 验证用户ID与登录用户是否一致（防止跨站请求伪造）
            user user = (user) session.getAttribute("user");
            if (user.getId() != userId) {
                response.getWriter().write("用户信息不匹配，请重新登录！");
                return;
            }

            // 检查是否已提交过申请
            boolean alreadyApplied = applicationDAO.checkApplicationExists(userId, petId);
            if (alreadyApplied) {
                response.getWriter().write("您已提交过该宠物的领养申请，请耐心等待审核！");
                return;
            }

            // 提交领养申请
            boolean success = applicationDAO.addApplication(userId, petId);

            if (success) {
                response.getWriter().write("申请提交成功，请等待审核！");
            } else {
                response.getWriter().write("申请提交失败，请稍后再试！");
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("参数格式错误，请重试！");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("系统错误，请稍后再试！");
        }
    }
}