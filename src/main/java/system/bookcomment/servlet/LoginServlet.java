package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import system.bookcomment.model.User;
import system.bookcomment.service.PublicService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private PublicService publicService = new PublicService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String password = req.getParameter("password");
        if (uid == null || password == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        User user = publicService.login(Integer.parseInt(uid), password);
        if (user == null) {
            resp.sendRedirect("/user/login.jsp");
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("/index.jsp");
    }
}
