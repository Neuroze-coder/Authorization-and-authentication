package com.example.repo;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepository {


    public User checkLogin(String login, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/system_city_transport_database", "postgres", "ZALMANz3plus");
        String sql = "SELECT * from users where login = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
            user.setName(result.getString("name"));
            user.setSurname(result.getString("surname"));
            user.setLogin(login);
        }

        connection.close();

        return user;
    }

    public int registrationUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users (login, name, surname, password) values (?,?,?,?)";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/system_city_transport_database",
                "postgres", "ZALMANz3plus");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getPassword());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
