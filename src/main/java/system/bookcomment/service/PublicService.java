package system.bookcomment.service;

import system.bookcomment.dao.BookDao;
import system.bookcomment.dao.CommentDao;
import system.bookcomment.dao.RatingDao;
import system.bookcomment.dao.UserDao;
import system.bookcomment.model.Book;
import system.bookcomment.model.Comment;
import system.bookcomment.model.Rating;
import system.bookcomment.model.User;

import java.sql.SQLException;
import java.util.List;

public class PublicService {
    UserDao userDao = new UserDao();
    BookDao bookDao = new BookDao();
    CommentDao commentDao = new CommentDao();
    RatingDao ratingDao = new RatingDao();
    /**
     * 登录
     * @param uid
     * @param password
     * @return 登录成功返回用户对象，否则返回null
     */
    public User login(int uid, String password) {
        User user = null;
        try {
            user = userDao.getUserById(uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    /**
     * 注册
     * @param user
     * @return 注册成功返回true，否则返回false
     */
    public int register(User user) {
        try {
            return userDao.addUser(user);
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return 0;
    }

    public void updateUser(User user) {
        try {
            userDao.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> serachBook(String bookName) {
        try {
            return bookDao.getBookByName(bookName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book getBookById(int i) {
        try{
            return bookDao.getBookById(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Comment> getBookComments(int bid) {
        try {
            return commentDao.getBookComments(bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getBookRating(int bid) {
        try {
            List<Rating> ratingByBookId = ratingDao.getRatingByBookId(bid);
            if (ratingByBookId.isEmpty()) {
                return 0;
            }
            int sum = 0;
            for (Rating rating : ratingByBookId) {
                sum += rating.getScore();
            }
            return sum * 10 / ratingByBookId.size();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void submitRating(int bid, int uid, int rating) {
        try {
            ratingDao.addRating(new Rating(0, bid, uid, rating));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
