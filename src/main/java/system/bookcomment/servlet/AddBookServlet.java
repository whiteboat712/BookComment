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

@WebServlet(name = "AddBookServlet", value = "/add-book-servlet")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
    BackendService backendService = new BackendService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bname = req.getParameter("bname");
        String bauthor = req.getParameter("bauthor");
        String publisher = req.getParameter("publisher");
        Date publishDate = Date.valueOf(req.getParameter("publishDate")) ;
        String binfo = req.getParameter("binfo");
        Part part = req.getPart("cover");
        String cover = null;
        Book book = new Book(0, bname, bauthor, binfo, cover, publishDate, publisher);
        book.setBid(backendService.addBook(book));
        if (part != null && part.getSize() > 0) {
            String orderDir = getServletContext().getRealPath("/cover");
            File dir = new File(orderDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String orderPath = getServletContext().getRealPath("/cover/" + book.getBid() + ".png");
            File file = new File(orderPath);
            try (InputStream fileContent = part.getInputStream()) {
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            cover = orderPath;
        }
        book.setCover(cover);
        backendService.updateBook(book);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/bookDetail.jsp").forward(req, resp);
    }
}
