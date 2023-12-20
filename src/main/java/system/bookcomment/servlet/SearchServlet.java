package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.model.Book;
import system.bookcomment.service.PublicService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    private PublicService publicService = new PublicService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        if (key == null) {
            return;
        } else {
            List<Book> books = publicService.serachBook(key);
            System.out.println(books);
            req.setAttribute("books", books);
            req.getRequestDispatcher("/searchResult.jsp").forward(req, resp);
        }
        resp.sendRedirect("/searchResult.jsp");
    }
}
