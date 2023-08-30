import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetricsTableCreator {
    private static final String jdbcUrl = "jdbc:mysql://mysql.lcstuber.net:3306/nome_do_banco";
    private static final String username = "Github";
    private static final String password = "Github12345";

    public static void main(String[] args) {
        createMetricsTable();
        insertSampleData();
    }

    public static void createMetricsTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS metrics (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "inserted_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "lines_of_code INT," +
                "attempt_fails INT," +
                "execution_time INT," +
                "tests_amount INT" +
                ")";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery)) {
            createTableStatement.execute();
            System.out.println("Metrics table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertSampleData() {
        String insertQuery = "INSERT INTO metrics (lines_of_code, attempt_fails, execution_time, tests_amount) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, 500);
            insertStatement.setInt(2, 10);
            insertStatement.setInt(3, 120);
            insertStatement.setInt(4, 25);
            insertStatement.executeUpdate();

            System.out.println("Sample data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

