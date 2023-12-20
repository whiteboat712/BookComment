package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.service.BackendService;

import java.io.IOException;

@WebServlet(name = "ViewUserServlet", value = "/view-user-servlet")
public class ViewUserServlet extends HttpServlet {
    BackendService backendService = new BackendService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        req.setAttribute("orderUser", backendService.getUserById(Integer.parseInt(uid)));
        req.getRequestDispatcher("userDetail.jsp").forward(req, resp);
    }
}
