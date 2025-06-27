// PetEditServlet.java
package servlet;

import DAO.PetDAO;
import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/petEdit")
public class PetEditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 获取宠物ID
            int petId = Integer.parseInt(request.getParameter("id"));

            // 查询宠物信息
            PetDAO petDAO = new PetDAO();
            Pet pet = petDAO.getPetById(petId).orElse(null);

            if (pet == null) {
                request.setAttribute("error", "未找到该宠物信息");
                request.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(request, response);
                return;
            }

            // 将宠物信息存入request
            request.setAttribute("pet", pet);

            // 转发到编辑页面
            request.getRequestDispatcher("/jsp/admin/admin-3edit.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "加载编辑页面失败: " + e.getMessage());
            request.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(request, response);
        }
    }
}
