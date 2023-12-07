package DAO;

import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:derby://localhost:1527/company";
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    PreparedStatement prepareStatement(String insertSQL) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
