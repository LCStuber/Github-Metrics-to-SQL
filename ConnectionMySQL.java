import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String jdbcUrl = "jdbc:mysql://mysql.lcstuber.net:3306/Github";
    private static final String username = "Github";
    private static final String password = "Github12345";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
