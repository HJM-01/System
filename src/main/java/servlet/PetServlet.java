package servlet;

import DAO.PetDAO;
import entity.Admins;
import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
//这个还有用没有啊T.T——林
@WebServlet("/jsp/admin/PetServlet")
public class PetServlet extends HttpServlet {
    private PetDAO petDAO = new PetDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        processRequest(req, resp);
        listPets(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        processRequest(req, resp);
        listPets(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listPets(req, resp);
                break;
            case "search":
                searchPets(req, resp);
                break;
            default:
                listPets(req, resp);
        }
    }
//查询全部
    private void listPets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pet> pets = petDAO.getAllPets();
        if(pets.isEmpty()) {
//            pets.add(new Pet(1,petName));
        }
        req.setAttribute("pets", pets);
        req.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(req, resp);
    }
//部分查询
    private void searchPets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Pet> pets = petDAO.searchPets(keyword);
        req.setAttribute("pets", pets);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("/jsp/admin/admin-3.jsp").forward(req, resp);
    }
}
