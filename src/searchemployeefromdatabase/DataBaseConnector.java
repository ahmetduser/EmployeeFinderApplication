package searchemployeefromdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    public static Connection getDBConnection() {
        Connection con = null;
        String dbUrl = "jdbc:mysql://localhost:3306/Employee";
        String userName = "root";
        String password = "Ahmet@1996"; // fill the password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        return con;
    }
}
