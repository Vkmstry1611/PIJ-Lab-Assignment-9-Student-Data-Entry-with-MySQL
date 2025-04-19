import java.sql.*;
import java.util.*;

public class StudentDAO {

    // Adds a student to the database
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (prn, name, dob, marks) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, student.getPrn());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getDob());
            pstmt.setDouble(4, student.getMarks());
            pstmt.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }

    // Displays all students
    public void displayStudents() throws SQLException {
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("PRN: %d, Name: %s, DOB: %s, Marks: %.2f%n", rs.getLong("prn"), rs.getString("name"), rs.getString("dob"), rs.getDouble("marks"));
            }
        }
    }

}