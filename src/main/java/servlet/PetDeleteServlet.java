package servlet;

import DAO.PetDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/petDelete")
public class PetDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        try {
            // 获取宠物ID
            int petId = Integer.parseInt(request.getParameter("id"));

            // 调用DAO删除宠物
            PetDAO petDAO = new PetDAO();
            boolean success = petDAO.deletePet(petId);

            if (success) {
                request.setAttribute("message", "宠物删除成功");
            } else {
                request.setAttribute("error", "宠物删除失败");
            }

            // 重定向到宠物列表页面
            request.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "删除过程中发生错误: " + e.getMessage());
            request.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(request, response);
        }
    }
}
