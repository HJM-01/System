package servlet;

import DAO.PetDAO;
import com.google.gson.Gson;
import entity.Pet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/pet")
public class PetApiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        Pet pet = new PetDAO().getPetById(Integer.parseInt(id)).orElse(null);
        resp.getWriter().write(new Gson().toJson(pet));
    }
}