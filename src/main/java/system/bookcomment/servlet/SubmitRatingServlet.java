package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.service.PublicService;

import java.io.IOException;

@WebServlet(name = "SubmitRatingServlet", value = "/submit-rating-servlet")
public class SubmitRatingServlet extends HttpServlet {
    private PublicService publicService = new PublicService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("bid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        int rating = Integer.parseInt(req.getParameter("rating"));
        publicService.submitRating(bid, uid, rating);
        String preUrl = req.getHeader("Referer");
        resp.sendRedirect(preUrl);
    }
}
