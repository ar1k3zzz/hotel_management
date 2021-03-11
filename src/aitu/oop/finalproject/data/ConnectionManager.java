package aitu.oop.finalproject.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection con;

    public static Connection getConnection() {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            try {
                String connectionUrl = "jdbc:mysql://localhost:3306/hotel_management";
                String username = "root";
                String password = "root";
                con = DriverManager.getConnection(connectionUrl, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }

}
