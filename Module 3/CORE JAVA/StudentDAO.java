import java.sql.*;

public class StudentDAO {
    private static final String URL = "jdbc:sqlite:students.db";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Insert a new student
    public void insertStudent(int id, String name, int age) {
        String sql = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // Update student details by id
    public void updateStudent(int id, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // Main method to test insert and update
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Insert a student
        dao.insertStudent(1, "Alice", 20);

        // Update the student
        dao.updateStudent(1, "Alice Johnson", 21);
    }
}
