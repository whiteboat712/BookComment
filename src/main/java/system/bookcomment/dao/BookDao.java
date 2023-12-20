package system.bookcomment.dao;

import system.bookcomment.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public int addBook(Book book) throws SQLException {
        Connection connection = DBUtil.getConnection();
        int generatedKey = 0;
        try {
            String sql = "insert into book (bname, bauthor, binfo, cover, publish_date, publisher) values(?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, book.getBname());
                preparedStatement.setString(2, book.getBauthor());
                preparedStatement.setString(3, book.getBinfo());
                preparedStatement.setString(4, book.getCover());
                preparedStatement.setDate(5, book.getPublishDate());
                preparedStatement.setString(6, book.getPublisher());
                preparedStatement.executeUpdate();

                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    generatedKey = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return generatedKey;
    }

    public void deleteBook(int bookId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "delete from book where bid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, bookId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public void updateBook(Book book) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "update book set bname=?, bauthor=?, binfo=?, cover=?, publish_date=?, publisher=? where bid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, book.getBname());
                preparedStatement.setString(2, book.getBauthor());
                preparedStatement.setString(3, book.getBinfo());
                preparedStatement.setString(4, book.getCover());
                preparedStatement.setDate(5, book.getPublishDate());
                preparedStatement.setString(6, book.getPublisher());
                preparedStatement.setInt(7, book.getBid());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public List<Book> getAllBooks() throws SQLException {
        Connection connection = DBUtil.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            String sql = "select * from book";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setBid(resultSet.getInt("bid"));
                    book.setBname(resultSet.getString("bname"));
                    book.setBauthor(resultSet.getString("bauthor"));
                    book.setBinfo(resultSet.getString("binfo"));
                    book.setCover(resultSet.getString("cover"));
                    book.setPublishDate(resultSet.getDate("publish_date"));
                    book.setPublisher(resultSet.getString("publisher"));
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return books;
    }

    public Book getBookById(int bookId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        Book book = null;
        try {
            String sql = "select * from book where bid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, bookId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Book tmpbook = new Book();
                    tmpbook.setBid(resultSet.getInt("bid"));
                    tmpbook.setBname(resultSet.getString("bname"));
                    tmpbook.setBauthor(resultSet.getString("bauthor"));
                    tmpbook.setBinfo(resultSet.getString("binfo"));
                    tmpbook.setCover(resultSet.getString("cover"));
                    tmpbook.setPublishDate(resultSet.getDate("publish_date"));
                    tmpbook.setPublisher(resultSet.getString("publisher"));
                    book = tmpbook;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return book;
    }

    public List<Book> getBookByName(String bookName) throws SQLException {
        Connection connection = DBUtil.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            String sql = "select * from book where bname like '%' ? '%'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, bookName);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setBid(resultSet.getInt("bid"));
                    book.setBname(resultSet.getString("bname"));
                    book.setBauthor(resultSet.getString("bauthor"));
                    book.setBinfo(resultSet.getString("binfo"));
                    book.setCover(resultSet.getString("cover"));
                    book.setPublishDate(resultSet.getDate("publish_date"));
                    book.setPublisher(resultSet.getString("publisher"));
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return books;
    }
}
