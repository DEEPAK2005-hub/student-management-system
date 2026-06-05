package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3306/student_management";
    private static String username = "root";
    private static String password = "deep123";

    private static Connection connection = null;

    public static Connection getConnection() {

        try {

            if (connection == null) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url, username, password);

                System.out.println("Database Connected Successfully");

            }

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL Driver not found");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return connection;
    }
}