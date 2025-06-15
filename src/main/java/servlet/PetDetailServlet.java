package servlet;

import DAO.PetDAO;
import entity.Pet;
import entity.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/pet/detail")
public class PetDetailServlet extends HttpServlet {
    private PetDAO petDAO = new PetDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. 获取宠物ID（添加参数校验）
            String petIdStr = request.getParameter("id");
            if (petIdStr == null || petIdStr.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/pet/list"); // 重定向到宠物列表页
                return;
            }
            int petId = Integer.parseInt(petIdStr);

            // 2. 获取宠物详情
            Pet pet = petDAO.getPetById(petId);
            if (pet == null) {
                response.sendRedirect(request.getContextPath() + "/pet/list");
                return;
            }
            request.setAttribute("pet", pet);

            // 3. 获取宠物图片列表（假设图片路径以逗号分隔）
            String[] pics = petDAO.getPetPics(petId);
            request.setAttribute("pics", pics);


            // 4. 获取当前登录用户
            HttpSession session = request.getSession();
            user user = (user) session.getAttribute("user");
            request.setAttribute("user", user);

            // 5. 转发到宠物详情页面
            request.getRequestDispatcher("/WEB-INF/views/pet_detail.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // 处理非法参数格式
            response.sendRedirect(request.getContextPath() + "/error?msg=参数格式错误");
        } catch (Exception e) {
            // 处理其他异常
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error?msg=系统错误，请稍后再试");
        }
    }
}