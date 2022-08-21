package jdbcExample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

    private static DBConnectionProvider instance = new DBConnectionProvider();

    private Connection connection;

    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final String DB_URl = "jdbc:mysql://localhost:3306/user";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private DBConnectionProvider() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DBConnectionProvider getInstance() {
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URl, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
