package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBHandler {
    
    private static final String DB_URL = "jdbc:mysql://root:9fMsw6YjOYr5GcsxxM91@containers-us-west-182.railway.app:7850/railway";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "9fMsw6YjOYr5GcsxxM91";
    
    private Connection connection;

    public MySQLDBHandler() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado.", e);
        }

        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
