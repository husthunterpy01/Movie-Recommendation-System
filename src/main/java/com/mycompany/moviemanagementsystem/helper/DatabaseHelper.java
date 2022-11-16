
package com.mycompany.moviemanagementsystem.helper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseHelper {
    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/ktpm3";
        String userName = "root";
        String password = "";
        Connection conn =DriverManager.getConnection(url, userName, password);
        return conn;
    }
}
