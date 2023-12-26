package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.model.User;
import system.bookcomment.service.PublicService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {

    private PublicService publicService = new PublicService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding( "UTF-8" );
        resp.setContentType("text/html;charset=UTF-8");
        String uname = req.getParameter("uname");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (uname == null || password == null || role == null) {
            resp.sendRedirect("/register.jsp");
            return;
        }
        User user = new User(0, uname, password, User.Role.valueOf(role), null);
        int uid = publicService.register(user);
        if (uid != 0) {
            PrintWriter writer = resp.getWriter();
            System.out.println("<script>alert('注册成功！\n你的UID是" + uid + "');window.location.href='/login.jsp'</script>");
            writer.write("<script>alert('注册成功！你的UID是" + uid + "');window.location.href='/login.jsp'</script>");
//            resp.sendRedirect("/login.jsp");
        } else {
            resp.sendRedirect("/register.jsp");
        }
    }
}
