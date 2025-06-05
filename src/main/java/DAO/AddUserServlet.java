package DAO;

public class AddUserServlet {
}


//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//        import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.sql.PreparedStatement;
//
////插入数据库
//@WebServlet(name="Registration",value = "/login.jsp")
//public class Registration extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
////            InitialContext异常
//            Context context = new InitialContext();
////            驱动
//            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
////            插入用户名，密码，联系方式
//            String AddUser="inset into valuse(?,?,?)";
////            PreparedStatement p=
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}