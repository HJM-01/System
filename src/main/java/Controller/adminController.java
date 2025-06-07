package Controller;

import com.google.protobuf.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import your.package.name.Admins; // 替换为实际的 Admins 类的包路径
import your.package.name.Message; // 替换为实际的 Message 类的包路径
import your.package.name.FileLoad; // 替换为实际的 FileLoad 类的包路径
import your.package.name.AdminService; // 替换为实际的 AdminService 类的包路径

//传统的servlet
//import java.util.ArrayList;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/showPics")
//public class ShowPicsServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 创建一个图片路径列表
//        List<String> pics = new ArrayList<>();
//        pics.add("image1.jpg");
//        pics.add("image2.jpg");
//        pics.add("image3.jpg");
//
//        // 将图片列表设置到请求作用域
//        request.setAttribute("pics", pics);
//
//        // 转发请求到JSP页面
//        request.getRequestDispatcher("/showPics.jsp").forward(request, response);
//    }
//}
public class adminController {
    @RequestMapping("/create")
    @ResponseBody
    public Message add(Admins admins, MultipartFile file){
        String pic = FileLoad.uploadAdminPic(file);
        admins.setPic(pic);
        int add = adminService.add(admins);
        if(add>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }
