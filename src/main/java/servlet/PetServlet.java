//package servlet;
//
//import DAO.PetDAO;
////import Impl.PetDaoImpI;
//import elemental2.dom.Request;
//import entity.Pet;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//public class AddPetServlet extends HttpServlet {
//    public void doPost(HttpServletRequest request,
//                       HttpServletResponse response)
//            throws ServletException, IOException {
////        PetDAO dao=new PetDaoImpI();
//        Pet pet=null;
//        String message=null;
//        try{
//            pet=new Pet();
//                pet.setPetName(request.getParameter("petName")),
//                   pet.setPetType( request.getParameter("petType")),
//                    pet.setSex(request.getParameter("sex")),
//                    pet.setBirthday(request.getParameter("birthday")),
//                    pet.setState(Integer.valueOf(request.getParameter("state"))),
//                    pet.setRemark(request.getParameter("remark"));
////            int result=dao.addPet(pet);
//            if(result==1){
//                message="<li>成功插入一条记录</li>";
//            }else{
//                message="<li>插入记录出错</li>";
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            message="<li>插入记录出错</li>";
//        }
//        request.setAttribute("result", message);
//        RequestDispatcher rd=
//                getServletContext().getRequestDispatcher("admin-3add.jsp");
//        rd.forward(request, response);
//    }
//}
