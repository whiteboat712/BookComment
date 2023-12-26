package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.service.BackendService;
import system.bookcomment.service.PublicService;

import java.io.IOException;

@WebServlet(name = "UnameServlet", value = "/uname-servlet")
public class UnameServlet extends HttpServlet {
    private BackendService backendService = new BackendService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        String uname = backendService.getUserById(uid).getUname();
        resp.getWriter().write(uname);
    }
}
