package servlet;

import DAO.PetDAO;
import entity.Pet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adoption/list") // 修改为统一路径
public class AdoptionListServlet extends HttpServlet {
    private PetDAO petDAO = new PetDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException {
        try {
            List<Pet> petList = petDAO.getPetsByStatus(0); // 获取待领养宠物
            request.setAttribute("petList", petList);
            request.getRequestDispatcher("/jsp/user/adoptionList.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/error?code=A001");
        }
    }
}