package lk.foodcity.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hp
 */
public class DBConnection {
  
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/foodcitydb";
        String user = "root";
        String password = "root";
        
        return DriverManager.getConnection(url, user, password);
    }
}
