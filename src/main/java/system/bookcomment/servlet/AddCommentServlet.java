package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.model.Comment;
import system.bookcomment.service.BackendService;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

@WebServlet(name = "AddCommentServlet", value = "/add-comment-servlet")
public class AddCommentServlet extends HttpServlet {
    BackendService backendService = new BackendService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        String uid = req.getParameter("uid");
        String content = req.getParameter("content");
        String parentid = req.getParameter("parentid");
        Timestamp date = Timestamp.valueOf(req.getParameter("date"));
        Comment comment = new Comment(0, Integer.parseInt(bid), Integer.parseInt(uid), content, Integer.parseInt(parentid), date);
        backendService.addComment(comment);
        String preUrl = req.getHeader("Referer");
        resp.sendRedirect(preUrl);
    }
}
