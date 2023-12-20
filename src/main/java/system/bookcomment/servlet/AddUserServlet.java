package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import system.bookcomment.model.User;
import system.bookcomment.service.BackendService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "AddUserServlet", value = "/add-user-servlet")
@MultipartConfig
public class AddUserServlet extends HttpServlet {
    BackendService backendService = new BackendService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String password = req.getParameter("password");
        User.Role role = User.Role.valueOf(req.getParameter("role"));
        Part part = req.getPart("avatar");
        String avatar = null;
        User user = new User(0, uname, password, role, avatar);
        user.setUid(backendService.addUser(user));

        if (part != null && part.getSize() > 0) {
            String orderDir = getServletContext().getRealPath("/avatar");
            File dir = new File(orderDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String orderPath = getServletContext().getRealPath("/avatar/" + user.getUid() + ".png");
            File file = new File(orderPath);
            try (InputStream fileContent = part.getInputStream()) {
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            avatar = orderPath;
        }
        user.setAvatar(avatar);
        backendService.updateUser(user);
        String preUrl = req.getHeader("Referer");
        resp.sendRedirect(preUrl);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
