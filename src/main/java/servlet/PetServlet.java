package servlet;

import DAO.PetDAO;
import entity.Pet;
import service.PetService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class PetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws SecurityException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                insertPet(req, resp);
                break;
            default:
                resp.getWriter().println("未知操作");
        }
    }

    private void insertPet(HttpServletRequest req, HttpServletResponse resp)
            throws SecurityException, IOException {
        try {
            Pet pet = new Pet();
            pet.setPetName(req.getParameter("petName"));
            pet.setPetType(req.getParameter("petType"));
            pet.setSex(req.getParameter("sex"));

            String birthdayStr = req.getParameter("birthday");
            if (birthdayStr != null && !birthdayStr.isEmpty()) {
                pet.setBirthday(new Date(Long.parseLong(birthdayStr)));
            }

            pet.setRemark(req.getParameter("remark"));
            pet.setState(Integer.parseInt(req.getParameter("state")));

            // 处理文件上传（即使暂时不使用，也需确保解析）
            try {
                req.getPart("petPic");
            } catch (Exception e) {
                // 暂时忽略
            }

            PetService service = new PetService();
            int result = service.insertPet(pet);

            if (result > 0) {
                resp.sendRedirect("admin-3.jsp");
            } else {
                resp.getWriter().println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("错误：" + e.getMessage());
        }
    }
}
