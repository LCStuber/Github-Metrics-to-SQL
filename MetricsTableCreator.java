import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetricsTableCreator {
    private static final String jdbcUrl = "jdbc:mysql://mysql.lcstuber.net:3306/Github";
    private static final String username = "Github";
    private static final String password = "Github12345";

    public static void insertMetricsData(int linhasCodigo, int attemptFails, long executionTime, int testsAmount) {
        String insertQuery = "INSERT INTO metrics (lines_of_code, attempt_fails, execution_time, tests_amount) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1,linhasCodigo );
            insertStatement.setInt(2, attemptFails);
            insertStatement.setLong(3, executionTime);
            insertStatement.setInt(4, testsAmount);
            insertStatement.executeUpdate();

            System.out.println("Sample data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

