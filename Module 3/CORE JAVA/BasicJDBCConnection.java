import java.sql.*;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        // JDBC URL for SQLite (you can use MySQL or others by changing URL and driver)
        String url = "jdbc:sqlite:students.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the database.");

                String query = "SELECT * FROM students";

                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int age = rs.getInt("age");
                        System.out.println(id + "\t" + name + "\t" + age);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
