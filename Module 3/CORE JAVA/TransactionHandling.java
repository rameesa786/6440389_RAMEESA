import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandlingJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false);
            try {
                String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
                try (PreparedStatement debitStatement = connection.prepareStatement(debitSQL)) {
                    debitStatement.setDouble(1, 100);
                    debitStatement.setInt(2, 1);
                    debitStatement.executeUpdate();
                }

                String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
                try (PreparedStatement creditStatement = connection.prepareStatement(creditSQL)) {
                    creditStatement.setDouble(1, 100);
                    creditStatement.setInt(2, 2);
                    creditStatement.executeUpdate();
                }
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
