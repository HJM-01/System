package servlet;

import DAO.PetDAO;
import entity.Pet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "PetDetailServlet", value = "/pet/detail")
public class PetDetailServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petIdStr = request.getParameter("id");
//        String petIdStr = "1";

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

            // 将单条宠物数据存入request
            request.setAttribute("pet", petOpt.get());

            // 转发到详情页
            request.getRequestDispatcher("/jsp/user/adoptionInformange.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/error?message=无效的宠物ID格式");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error?message=系统错误");
        }
    }
}