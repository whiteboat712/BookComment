package system.bookcomment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import system.bookcomment.model.User;
import system.bookcomment.service.BackendService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ImageServlet", value = "/image-servlet")
public class ImageServlet extends HttpServlet {
    BackendService backendService = new BackendService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取本地图片的绝对路径，这里假设图片存储在 "/path/to/your/image.jpg"
//        String imagePath = req.getParameter("imagePath");
        String imagePath = null;
        String type = req.getParameter("type");
        String id = req.getParameter("id");
        if (type == null || id == null) {
            imagePath = "C:\\Users\\123456\\Pictures\\95913863_p0.jpg";
        } else if (type.equals("user")) {
            User user = backendService.getUserById(Integer.parseInt(id));
            if (user.getAvatar() == null) {
                imagePath = "C:\\Users\\123456\\Pictures\\95913863_p0.jpg";
            } else {
                imagePath = getServletContext().getRealPath("/avatar") + "/" + id + ".png";
            }
        } else if (type.equals("book")) {
            imagePath = getServletContext().getRealPath("/cover") + "/" + id + ".png";
        }
        // 读取图片数据
        byte[] imageData = readImageData(imagePath);

        resp.setContentType("image/jpeg");
        OutputStream out = resp.getOutputStream();
        out.write(imageData);
        out.close();
    }

    private byte[] readImageData(String imagePath) throws IOException {
        // 读取图片数据
        File imageFile = new File(imagePath);
        try (FileInputStream fis = new FileInputStream(imageFile)) {
            byte[] imageData = new byte[(int) imageFile.length()];
            fis.read(imageData);
            return imageData;
        }
    }
}
