package servlet;

import DAO.UserDao;
import com.google.gson.Gson;
import entity.user;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/user")
public class UserApiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        user user = new UserDao().getUserById(Integer.parseInt(id)).orElse(null);
        resp.getWriter().write(new Gson().toJson(user));
    }
}