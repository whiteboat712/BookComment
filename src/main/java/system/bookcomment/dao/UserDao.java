package system.bookcomment.dao;

import system.bookcomment.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public int addUser(User user) throws SQLException {
        Connection connection = DBUtil.getConnection();
        int generatedKey = 0;
        try {
            String sql = "insert into user (uname, password, role, avatar) values(?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, user.getUname());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole().toString());
                preparedStatement.setString(4, user.getAvatar());
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

    public void deleteUser(int userId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "delete from user where uid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public void updateUser(User user) throws SQLException {
        Connection connection = DBUtil.getConnection();
        try {
            String sql = "update user set uname=?, password=?, avatar=? where uid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUname());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getAvatar());
                preparedStatement.setInt(4, user.getUid());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = DBUtil.getConnection();
        List<User> users = new ArrayList<>();
        try {
            String sql = "select * from user";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    User user = new User();
                    user.setUid(resultSet.getInt("uid"));
                    user.setUname(resultSet.getString("uname"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(User.Role.valueOf(resultSet.getString("role")));
                    user.setAvatar(resultSet.getString("avatar"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return users;
    }

    public User getUserById(int userId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        User user = null;
        try {
            String sql = "select * from user where uid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    User tmpuser = new User();
                    tmpuser.setUid(resultSet.getInt("uid"));
                    tmpuser.setUname(resultSet.getString("uname"));
                    tmpuser.setPassword(resultSet.getString("password"));
                    tmpuser.setRole(User.Role.valueOf(resultSet.getString("role")));
                    tmpuser.setAvatar(resultSet.getString("avatar"));
                    user = tmpuser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return user;
    }

    public List<User> getUserByName(String userName) throws SQLException {
        Connection connection = DBUtil.getConnection();
        List<User> users = new ArrayList<>();
        try {
            String sql = "select * from user where uname like '%?%'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userName);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    User user = new User();
                    user.setUid(resultSet.getInt("uid"));
                    user.setUname(resultSet.getString("uname"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(User.Role.valueOf(resultSet.getString("role")));
                    user.setAvatar(resultSet.getString("avatar"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return users;
    }
}
