package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.model.User;
import system.bookcomment.service.PublicService;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {

    private PublicService publicService = new PublicService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (uname == null || password == null || role == null) {
            resp.sendRedirect("/register.jsp");
            return;
        }
        User user = new User(0, uname, password, User.Role.valueOf(role), null);
        if (publicService.register(user)) {
            resp.sendRedirect("/login.jsp");
            return;
        } else {
            resp.sendRedirect("/register.jsp");
            return;
        }
    }
}
