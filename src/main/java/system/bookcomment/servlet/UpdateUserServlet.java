package system.bookcomment.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import system.bookcomment.model.User;
import system.bookcomment.service.PublicService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;

@WebServlet(name = "UpdateUserServlet", value = "/update-user-servlet")
@MultipartConfig
public class UpdateUserServlet extends HttpServlet {

    private PublicService publicService = new PublicService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String uname = req.getParameter("uname");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        Part part = req.getPart("avatar");
        String avatar = null;
        if (part != null && part.getSize() > 0) {
            String orderDir = getServletContext().getRealPath("/avatar");
            File dir = new File(orderDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String orderPath = getServletContext().getRealPath("/avatar/" + uid + ".png");
            File file = new File(orderPath);
            try (InputStream fileContent = part.getInputStream()) {
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            avatar = orderPath;
        }

        User user = new User(Integer.parseInt(uid), uname, password, User.Role.valueOf(role), avatar);
        publicService.updateUser(user);
        resp.sendRedirect("/userDetail.jsp");
    }
}
