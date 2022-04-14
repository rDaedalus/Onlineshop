package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductManager {
    public void connectDB() {
        String jdbcURL = "jdbc:mysql://localhost:3306/onlineshop";
        String username = "Daedalus";
        String password = "1Casiowatch";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {
                System.out.println("Connected to the database");
                connection.close();
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
