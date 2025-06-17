//package servlet;
//
//import entity.Admins;
//import entity.Pet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class petServlet22 extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/html;charset=UTF-8"); // 建议加上编码声明
//        Pet pet = null;
//        ArrayList<Pet> petArrayList = new ArrayList<>();
//        // 通过 JNDI 获取连接池
//        try {
//            // 1. 获取 JNDI 上下文
//            Context ctx = new InitialContext();
//            // 2. 查找数据源（名称需与 context.xml 中的 Resource.name 一致）
//            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");
//            // 3. 从连接池获取连接
//            try (Connection conn = ds.getConnection()) {
//                String sql = "select * from pet";
//                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                    ResultSet rs = pstmt.executeQuery();
//                    while (rs.next()) {
//                        pet = new Pet(
//                                rs.getInt("id"),
//                                rs.getString("petName"),
//                                rs.getString("petType"),
//                                rs.getString("sex"),
//                                rs.getDate("birthday"),
//                                rs.getString("pic"),
//                                rs.getInt("state"),
//                                rs.getString("remark")
//                        );
//                        petArrayList.add(pet);
//
//                        System.out.println("图片：");
//                        System.out.println(pet.getPic());
//                    }
//                }
//            }
//        } catch (NamingException e) {
//            e.printStackTrace();
//            response.getWriter().write("系统错误：无法找到数据库配置！");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.getWriter().write("数据库操作失败：" + e.getMessage());
//        }
//        System.out.println("图片：");
//        System.out.println(petArrayList.get(1).getPic());
////        if(petArrayList.isEmpty()) {
////            petArrayList.add(new Admins(1, "测试管理员", "test@example.com", "123456789", "男"));
////        }
//        request.setAttribute("pets",petArrayList);
//        request.getRequestDispatcher("/jsp/admin/admin-3.jsp").include(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//}
package servlet;

import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 配置文件上传参数
//@WebServlet(/admin-3add)
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class petServlet22 extends HttpServlet {
    // 上传文件存储路径，可根据实际情况修改
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // 获取操作类型，默认为查询
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        // 根据操作类型执行不同的处理
        if ("insert".equals(action)) {
            insertPet(request, response);
        } else {
            listPets(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // 插入宠物信息
    private void insertPet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = new Pet();
        List<String> errors = new ArrayList<>();

        // 获取表单数据
        String petName = request.getParameter("petName");
        String petType = request.getParameter("petType");
        String sex = request.getParameter("sex");
        String birthdayStr = request.getParameter("birthday");
        String stateStr = request.getParameter("state");
        String remark = request.getParameter("remark");

//        if (!errors.isEmpty()) {
//            request.setAttribute("errors", errors);
//            request.setAttribute("pet", pet);
//            request.getRequestDispatcher("/jsp/admin/add-pet.jsp").forward(request, response);
//            return;
//        }

        // 处理日期格式
        Date birthday = null;
        try {
            if (birthdayStr != null && !birthdayStr.isEmpty()) {
                birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
            }
        } catch (ParseException e) {
            errors.add("日期格式不正确");
            request.setAttribute("errors", errors);
            request.setAttribute("pet", pet);
            request.getRequestDispatcher("/jsp/admin/add-pet.jsp").forward(request, response);
            return;
        }

        // 处理状态
        int state = 0;
        try {
            state = Integer.parseInt(stateStr);
        } catch (NumberFormatException e) {
            errors.add("领养状态不正确");
            request.setAttribute("errors", errors);
            request.setAttribute("pet", pet);
            request.getRequestDispatcher("/jsp/admin/add-pet.jsp").forward(request, response);
            return;
        }

        // 处理图片上传
        String pic = null;
        try {
            Part filePart = request.getPart("petPic");
            if (filePart != null && filePart.getSize() > 0) {
                // 获取文件名
                String fileName = getFileName(filePart);
                if (fileName != null && !fileName.isEmpty()) {
                    // 确保上传目录存在
                    String uploadPath = request.getServletContext().getRealPath("/") + UPLOAD_DIR;
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }

                    // 保存文件
                    String filePath = uploadPath + File.separator + fileName;
                    filePart.write(filePath);

                    // 保存图片路径到数据库
                    pic = UPLOAD_DIR + "/" + fileName;
                }
            }
        } catch (IOException | ServletException e) {
            errors.add("图片上传失败：" + e.getMessage());
            request.setAttribute("errors", errors);
            request.setAttribute("pet", pet);
            request.getRequestDispatcher("/jsp/admin/add-pet.jsp").forward(request, response);
            return;
        }
        // 调用DAO方法插入数据
        try {
            // 通过 JNDI 获取连接池
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

            try (Connection conn = ds.getConnection()) {
                // 实际应用中应该将数据库操作封装到DAO类中
                String sql = "INSERT INTO pet (petName, petType, sex, birthday, pic, state, remark) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    pstmt.setString(1,petName);
                    pstmt.setString(2, petType);
                    pstmt.setString(3, sex);
                    if (pet.getBirthday() != null) {
                        pstmt.setDate(4, new java.sql.Date(pet.getBirthday().getTime()));
                    } else {
                        pstmt.setDate(4, null);
                    }
                    pstmt.setString(5, pic);
                    pstmt.setInt(6, state);
                    pstmt.setString(7, remark);

                    int affectedRows = pstmt.executeUpdate();

                    if (affectedRows > 0) {
                        // 插入成功，重定向到列表页面
                        response.sendRedirect(request.getContextPath() + "/admin-3add.jsp");
                        return;
                    } else {
                        errors.add("插入失败，请重试");
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            errors.add("数据库操作失败：" + e.getMessage());
            e.printStackTrace();
        }

        // 插入失败，返回表单页面并显示错误
        request.setAttribute("errors", errors);
        request.setAttribute("pet", pet);
        request.getRequestDispatcher("/jsp/admin/admin-3add.jsp").forward(request, response);
    }

                        // 查询宠物列表
                        private void listPets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                            // 创建宠物对象列表，用于存储从数据库查询的结果
                            List<Pet> petArrayList = new ArrayList<>();

                            try {
                                Context ctx = new InitialContext();
                                // 从数据源获取数据库连接，并使用try-with-resources自动关闭连接
                                DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Animals");

                                try (Connection conn = ds.getConnection()) {
                                    String sql = "SELECT * FROM pet";
                                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                        ResultSet rs = pstmt.executeQuery();// 执行查询并获取结果集
                                        // 遍历结果集，将每条记录转换为Pet对象
                                        while (rs.next()) {
                                            Pet pet = new Pet(
                                                    rs.getInt("id"),
                                                    rs.getString("petName"),
                                                    rs.getString("petType"),
                                                    rs.getString("sex"),
                                                    rs.getDate("birthday"),
                                                    rs.getString("pic"),
                                                    rs.getInt("state"),
                                                    rs.getString("remark")
                                            );
                                            // 将构造好的Pet对象添加到列表中
                                            petArrayList.add(pet);
                                        }
                                    }
                                }
                            } catch (NamingException | SQLException e) {
                                e.printStackTrace();
                                request.setAttribute("error", "系统错误：无法获取宠物列表");
                            }
                            // 将查询到的宠物列表存储在request对象中，供JSP页面使用
                            request.setAttribute("pets", petArrayList);
                            // 将请求转发到admin-3.jsp页面进行视图渲染
                            request.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(request, response);
                        }

    // 从Part对象获取文件名
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 2, element.length() - 1);
            }
        }
        return null;
    }
}
