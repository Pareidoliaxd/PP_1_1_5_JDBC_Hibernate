package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String URL = "jdbc:mysql://localhost:3306/database";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static Connection connection = null;

    public Util() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException var1) {
                var1.printStackTrace();
            }
        }

        return connection;
    }

    public static void setURL(String URL) {
        Util.URL = URL;
    }

    public static void setUSERNAME(String USERNAME) {
        Util.USERNAME = USERNAME;
    }

    public static void setPASSWORD(String PASSWORD) {
        Util.PASSWORD = PASSWORD;
    }
}
