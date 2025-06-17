// PetUpdateServlet.java
package servlet;

import DAO.PetDAO;
import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/petUpdate")
public class PetUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            // 获取表单数据
            int id = Integer.parseInt(request.getParameter("id"));
            String petName = request.getParameter("petName");
            String petType = request.getParameter("petType");
            String sex = request.getParameter("sex");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            int state = Integer.parseInt(request.getParameter("state"));
            String remark = request.getParameter("remark");

            // 创建Pet对象
            Pet pet = new Pet();
            pet.setId(id);
            pet.setPetName(petName);
            pet.setPetType(petType);
            pet.setSex(sex);
            pet.setBirthday(birthday);
            pet.setState(state);
            pet.setRemark(remark);

            // 获取原始宠物信息，保留原有图片路径
            PetDAO petDAO = new PetDAO();
            Pet originalPet = petDAO.getPetById(id).orElse(null);

            if (originalPet != null) {
                // 保持原有图片路径不变
                pet.setPic(originalPet.getPic());
            }

            // 调用DAO更新宠物信息
            boolean success = petDAO.updatePet(pet);

            if (success) {
                request.setAttribute("message", "猫咪信息更新成功");
            } else {
                request.setAttribute("error", "猫咪信息更新失败");
            }

            // 转发到列表页面
            request.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "更新过程中发生错误: " + e.getMessage());
            request.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(request, response);
        }
    }
}
