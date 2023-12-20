package system.bookcomment.service;

import system.bookcomment.dao.BookDao;
import system.bookcomment.dao.CommentDao;
import system.bookcomment.dao.UserDao;
import system.bookcomment.model.Book;
import system.bookcomment.model.Comment;
import system.bookcomment.model.User;

public class BackendService {
    private BookDao bookDao = new BookDao();
    private CommentDao commentDao = new CommentDao();
    private UserDao userDao = new UserDao();

    public int addBook(Book book) {
        try {
            return bookDao.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addComment(Comment comment) {
        try {
            commentDao.addComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addUser(User user) {
        try {
            return userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteBook(int bid) {
        try {
            bookDao.deleteBook(bid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(int cid) {
        try {
            commentDao.deleteComment(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int uid) {
        try {
            userDao.deleteUser(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getBookById(int bid) {
        try {
            return bookDao.getBookById(bid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Comment getCommentById(int cid) {
        try {
            return commentDao.getCommentById(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int uid) {
        try {
            return userDao.getUserById(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBook(Book book) {
        try {
            bookDao.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateComment(Comment comment) {
        try {
            commentDao.updateComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            userDao.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
