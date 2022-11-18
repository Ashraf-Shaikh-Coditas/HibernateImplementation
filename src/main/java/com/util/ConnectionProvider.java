package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection connect() {

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignmentdb","root","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}

