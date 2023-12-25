package system.bookcomment.dao;

import system.bookcomment.model.Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDao {

    public void addRating(Rating rating) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "insert into rating (bid, uid, score) values(?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, rating.getBid());
                preparedStatement.setInt(2, rating.getUid());
                preparedStatement.setInt(3, rating.getScore());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public List<Rating> getRatingByBookId(int bookId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        List<Rating> ratings = new ArrayList<>();
        try {
            String sql = "select * from rating where bid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, bookId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Rating rating = new Rating();
                    rating.setRid(resultSet.getInt("rid"));
                    rating.setBid(resultSet.getInt("bid"));
                    rating.setUid(resultSet.getInt("uid"));
                    rating.setScore(resultSet.getInt("score"));
                    ratings.add(rating);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return ratings;
    }

}
