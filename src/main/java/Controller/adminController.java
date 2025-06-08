//package Controller;
//
//
////传统的servlet
//import java.util.ArrayList;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/showPics")
//public class adminController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 创建一个图片路径列表
////        List<String> pics = new ArrayList<>();
////        pics.add("image1.jpg");
////        pics.add("image2.jpg");
////        pics.add("image3.jpg");
//        String pic = FileLoad.uploadAdminPic(file);
//        admins.setPic(pic);
//
//        // 将图片列表设置到请求作用域
//        request.setAttribute("pics", pics);
//
//        // 转发请求到JSP页面
//        request.getRequestDispatcher("/showPics.jsp").forward(request, response);
//    }
//}
//
