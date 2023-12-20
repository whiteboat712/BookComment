package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import system.bookcomment.model.Book;
import system.bookcomment.service.BackendService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

@WebServlet(name = "UpdateBookServlet", value = "/update-book-servlet")
@MultipartConfig
public class UpdateBookServlet extends HttpServlet {
    private BackendService backendService = new BackendService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        String bname = req.getParameter("bname");
        String bauthor = req.getParameter("bauthor");
        String binfo = req.getParameter("binfo");
        Date publishDate = Date.valueOf(req.getParameter("publishDate"));
        String publisher = req.getParameter("publisher");
        Part part = req.getPart("cover");
        String cover = null;
        if (part != null && part.getSize() > 0) {
            String orderDir = getServletContext().getRealPath("/cover");
            File dir = new File(orderDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String orderPath = getServletContext().getRealPath("/cover/" + bid + ".png");
            File file = new File(orderPath);
            try (InputStream fileContent = part.getInputStream()) {
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            cover = orderPath;
        }
        Book book = new Book(Integer.parseInt(bid), bname, bauthor, binfo, cover, publishDate, publisher);
        backendService.updateBook(book);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/bookDetail.jsp").forward(req, resp);

    }
}
