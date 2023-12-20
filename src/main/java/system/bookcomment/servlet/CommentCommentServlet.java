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
import java.sql.Timestamp;

@WebServlet(name = "CommentCommentServlet", value = "/comment-comment-servlet")
public class CommentCommentServlet extends HttpServlet {
    private PublicService publicService = new PublicService();
    private BackendService backendService = new BackendService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        String uid = req.getParameter("uid");
        String content = req.getParameter("content");
        String parentid = req.getParameter("parentid");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Comment comment = new Comment(0, Integer.parseInt(bid), Integer.parseInt(uid), content, Integer.parseInt(parentid), timestamp);
        backendService.addComment(comment);
        String preUrl = req.getHeader("Referer");
        resp.sendRedirect(preUrl);
    }
}
