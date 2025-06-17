package servlet;

import DAO.PetDAO;
import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/pet")
public class PetServlet extends HttpServlet {
    private PetDAO petDAO = new PetDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
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
        List<Pet> products = petDAO.getAllPets();
        req.setAttribute("products", products);
        req.getRequestDispatcher("src/main/webapp/jsp/admin/admin-3.jsp").forward(req, resp);
    }
//部分查询
    private void searchPets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Pet> products = petDAO.searchPets(keyword);
        req.setAttribute("products", products);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("src/main/webapp/jsp/admin/admin-3.jsp").forward(req, resp);
    }
}
