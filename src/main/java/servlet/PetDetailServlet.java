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

            // 检查宠物是否已被领养
            boolean isAdopted = petDAO.isPetAdopted(petId);
            request.setAttribute("isAdopted", isAdopted);

            // 获取当前登录用户
            HttpSession session = request.getSession(false);
            if (session != null) {
                Integer userId = (Integer) session.getAttribute("userId");
                if (userId != null) {
                    Optional<user> userOpt = userDAO.getUserById(userId); // 直接赋值
                    if (userOpt.isPresent()) {
                        user user = userOpt.get();
                        if (user.getPic() != null && !user.getPic().isEmpty()) {
                            user.setPic(request.getContextPath() + "/image/user/" + user.getPic());
                        }
                        request.setAttribute("user", user);
                    }
                }
            }

            String path = request.getContextPath();
            request.setAttribute("path", path);

//            request.getRequestDispatcher("/adoptionInformange.jsp").forward(request, response);

            System.out.println("[TRACE] 转发前 - request属性: " + request.getAttribute("pet"));
            request.getRequestDispatcher("/jsp/user/adoptionInformange.jsp").forward(request, response);
            System.out.println("[TRACE] 转发后 - 是否执行完成");

        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/error?message=无效的宠物ID格式");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error?message=系统错误");
        }
    }
}