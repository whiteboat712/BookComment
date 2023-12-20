package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.service.PublicService;

import java.io.IOException;

@WebServlet(name = "ViewAllBookServlet", value = "/view-all-book-servlet")
public class ViewAllBookServlet extends HttpServlet {

    PublicService publicService = new PublicService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        req.setAttribute("book", publicService.getBookById(Integer.parseInt(bid)));
        req.getRequestDispatcher("/bookDetail.jsp").forward(req, resp);
    }
}
