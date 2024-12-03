package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/task_manager"; // Your database URL
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "Arun@1107"; // Your MySQL password

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            // Handle error when JDBC driver is not found
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("JDBC Driver not found.", e);
        } catch (SQLException e) {
            // Handle error when connection fails
            System.err.println("Error connecting to the database: " + e.getMessage());
            throw e;
        }
    }
}
