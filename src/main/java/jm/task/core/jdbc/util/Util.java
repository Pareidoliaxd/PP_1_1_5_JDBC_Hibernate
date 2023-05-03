package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static String URL = "jdbc:mysql://localhost:3306/database";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    public Util() {
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

    public static String getURL() {
        return URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }
}
