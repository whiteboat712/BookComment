package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.service.BackendService;

import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", value = "/delete-book-servlet")
public class DeleteBookServlet extends HttpServlet {
    BackendService backendService = new BackendService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        backendService.deleteBook(Integer.parseInt(bid));
        String preUrl = req.getHeader("Referer");
        resp.sendRedirect(preUrl);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
