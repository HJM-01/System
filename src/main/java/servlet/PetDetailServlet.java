package servlet;

import DAO.PetDAO;
import DAO.UserDao;
import entity.Pet;
import entity.user;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "PetDetailServlet", value = "/pet/detail")
public class PetDetailServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAO();
    private final UserDao userDAO = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PetDetailServlet被调用，参数id=" + request.getParameter("id"));
        String petIdStr = request.getParameter("id");

        if (petIdStr == null || petIdStr.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/error?message=缺少宠物ID参数");
            return;
        }

        try {
            int petId = Integer.parseInt(petIdStr);
            Optional<Pet> petOpt = petDAO.getPetById(petId);

            if (petOpt.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/error?message=未找到指定宠物");
                return;
            }

            Pet pet = petOpt.get();
            request.setAttribute("pet", pet);

            // 获取宠物图片
            String[] pics = petDAO.getPetPics(petId);
            if (pics == null || pics.length == 0) {
                System.out.println("未找到宠物图片，petId=" + petId);
                pics = new String[]{request.getContextPath() + "/image/default.jpg"}; // 设置默认图片
            }
            request.setAttribute("pics", pics);

            // 获取当前登录用户
            HttpSession session = request.getSession(false);
            if (session != null) {
                Integer userId = (Integer) session.getAttribute("userId");
                if (userId != null) {
                    Optional<user> userOpt = userDAO.getUserById(userId);
                    if (userOpt.isPresent()) {
                        user user = userOpt.get();
                        if (user.getPic() != null && !user.getPic().isEmpty()) {
                            user.setPic(request.getContextPath() + "/image/user/" + user.getPic());
                        }
                        request.setAttribute("user", user);
                    }
                }
            }

            request.getRequestDispatcher("/adoptionInformange.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/error?message=无效的宠物ID格式");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error?message=系统错误");
        }
    }
}