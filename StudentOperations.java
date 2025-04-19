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

    // Searches student by PRN
    public void searchByPrn(long prn) throws SQLException {
        String sql = "SELECT * FROM students WHERE prn = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, prn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.printf("Found: PRN: %d, Name: %s, DOB: %s, Marks: %.2f%n", rs.getLong("prn"), rs.getString("name"), rs.getString("dob"), rs.getDouble("marks"));
            } else {
                System.out.println("Student not found.");
            }
        }
    }


        // Updates student
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, dob = ?, marks = ? WHERE prn = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getDob());
            pstmt.setDouble(3, student.getMarks());
            pstmt.setLong(4, student.getPrn());
            int updated = pstmt.executeUpdate();
            if (updated > 0) System.out.println("Student updated.");
            else System.out.println("Student not found.");
        }
    }

    
    // Deletes student
    public void deleteStudent(long prn) throws SQLException {
        String sql = "DELETE FROM students WHERE prn = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, prn);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) System.out.println("Student deleted.");
            else System.out.println("Student not found.");
        }
    }
}