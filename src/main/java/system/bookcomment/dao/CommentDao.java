package system.bookcomment.dao;

import system.bookcomment.model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public void addComment(Comment comment) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "insert into comment (bid, uid, content, parentid, date) values(?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, comment.getBid());
                preparedStatement.setInt(2, comment.getUid());
                preparedStatement.setString(3, comment.getContent());
                preparedStatement.setInt(4, comment.getParentid());
                preparedStatement.setTimestamp(5, comment.getDate());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public void deleteComment(int commentId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "delete from comment where cid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, commentId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public void updateComment(Comment comment) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "update comment set bid=?, uid=?, content=?, parentid=?, date=? where cid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, comment.getBid());
                preparedStatement.setInt(2, comment.getUid());
                preparedStatement.setString(3, comment.getContent());
                preparedStatement.setInt(4, comment.getParentid());
                preparedStatement.setTimestamp(5, comment.getDate());
                preparedStatement.setInt(6, comment.getCid());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public List<Comment> getAllComment() throws SQLException {
        Connection connection = DBUtil.getConnection();
        List<Comment> comments = new ArrayList<>();
        try {
            String sql = "select * from comment";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Comment comment = new Comment();
                    comment.setCid(resultSet.getInt("cid"));
                    comment.setBid(resultSet.getInt("bid"));
                    comment.setUid(resultSet.getInt("uid"));
                    comment.setContent(resultSet.getString("content"));
                    comment.setParentid(resultSet.getInt("parentid"));
                    comment.setDate(resultSet.getTimestamp("date"));
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return comments;
    }

    public Comment getCommentById(int commentId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        Comment comment = null;
        try {
            String sql = "select * from comment where cid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, commentId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Comment tmpcomment = new Comment();
                    tmpcomment.setCid(resultSet.getInt("cid"));
                    tmpcomment.setBid(resultSet.getInt("bid"));
                    tmpcomment.setUid(resultSet.getInt("uid"));
                    tmpcomment.setContent(resultSet.getString("content"));
                    tmpcomment.setParentid(resultSet.getInt("parentid"));
                    tmpcomment.setDate(resultSet.getTimestamp("date"));
                    comment = tmpcomment;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return comment;
    }

    public List<Comment> getBookComments(int bid) throws SQLException {
        Connection connection = DBUtil.getConnection();
        List<Comment> comments = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call getBookComments(?)}");
            callableStatement.setInt(1, bid);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCid(resultSet.getInt("cid"));
                comment.setBid(resultSet.getInt("bid"));
                comment.setUid(resultSet.getInt("uid"));
                comment.setContent(resultSet.getString("content"));
                comment.setParentid(resultSet.getInt("parentid"));
                comment.setDate(resultSet.getTimestamp("date"));
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        DBUtil.closeConnection(connection);
        return comments;
    }

}
