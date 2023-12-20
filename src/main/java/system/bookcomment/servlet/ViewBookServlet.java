package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.model.Comment;
import system.bookcomment.service.BackendService;
import system.bookcomment.service.PublicService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewBookServlet", value = "/view-book-servlet")
public class ViewBookServlet extends HttpServlet {
    BackendService backendService = new BackendService();
    PublicService publicService = new PublicService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        req.setAttribute("book", backendService.getBookById(Integer.parseInt(bid)));
        List<Comment> comments = publicService.getBookComments(Integer.parseInt(bid));
        req.setAttribute("comments", comments);
        req.getRequestDispatcher("/bookDetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
