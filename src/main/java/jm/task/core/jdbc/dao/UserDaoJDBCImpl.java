package jm.task.core.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE `users` " +
                        "(`id` int NOT NULL AUTO_INCREMENT," +
                        "`name` varchar(45) NOT NULL," +
                        "`lastName` varchar(45) NOT NULL," +
                        "`age` int NOT NULL, PRIMARY KEY (`id`), UNIQUE KEY `id_UNIQUE` (`id`))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            String VALUES = "VALUES('" + name + "', '" + lastName + "', '" + age + "');";
            statement.execute("INSERT INTO users (name, lastName, age) " + VALUES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
                statement.execute("DELETE FROM users WHERE id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultset = statement.executeQuery("SELECT * FROM users;");
            List<User> userList = new ArrayList();

            while(resultset.next()) {
                    User user = new User(resultset.getString(2),
                                        resultset.getString(3),
                                        resultset.getByte(4));
                    user.setId(resultset.getLong(1));
                    userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("TRUNCATE users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
