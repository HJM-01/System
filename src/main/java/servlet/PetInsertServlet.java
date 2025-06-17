package servlet;

import DAO.PetDAO;
import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/pet")
@MultipartConfig
public class PetInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        // 获取表单数据
        String petName = request.getParameter("petName");
        String petType = request.getParameter("petType");
        String sex = request.getParameter("sex");
        String birthdayStr = request.getParameter("birthday");
        String stateStr = request.getParameter("state");
        String remark = request.getParameter("remark");

        // 处理日期
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 处理领养状态
        int state = Integer.parseInt(stateStr);

        // 处理图片上传（这里简单假设存储图片路径）
        Part filePart = request.getPart("petPic");
        String pic = filePart.getSubmittedFileName(); // 简单存储文件名

        // 创建 Pet 对象
        Pet pet = new Pet(null, petName, petType, sex, birthday, pic, state, remark);

        // 插入数据到数据库
        PetDAO petDAO = new PetDAO();
        int result = petDAO.insertPet(pet);

        if (result > 0) {
            // 插入成功，重定向到列表页面
            response.sendRedirect(request.getContextPath() + "/jsp/admin/admin-3.jsp");
        } else {
            // 插入失败，返回错误信息
            response.getWriter().write("插入宠物信息失败，请稍后重试！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
