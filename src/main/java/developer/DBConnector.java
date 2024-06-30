package developer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DB_CON_STRING = System.getenv("DB_CONNECTION_STRING");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    private static Connection connection;

    static {
        try {
            if (DB_CON_STRING == null || DB_USER == null || DB_PASSWORD == null) {
                throw new RuntimeException("Database environment variables are not set.");
            }
            connection = DriverManager.getConnection(DB_CON_STRING, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_CON_STRING, DB_USER, DB_PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}