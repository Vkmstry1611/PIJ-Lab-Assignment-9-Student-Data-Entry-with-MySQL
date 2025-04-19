// Name: Vidish Ketankumar Mistry
// PRN: 23070126146
// Batch: B-3

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentOperations studoperations = new StudentOperations();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter PRN: ");
                        long prn = sc.nextLong(); sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter DOB (YYYY-MM-DD): ");
                        String dob = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        studoperations.addStudent(new Student(prn, name, dob, marks));
                        break;

                    case 2:
                        studoperations.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter PRN: ");
                        studoperations.searchByPrn(sc.nextLong());
                        break;

                    case 4:
                        System.out.print("Enter PRN to update: ");
                        long updPrn = sc.nextLong(); sc.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new DOB: ");
                        String newDob = sc.nextLine();
                        System.out.print("Enter new Marks: ");
                        double newMarks = sc.nextDouble();
                        studoperations.updateStudent(new Student(updPrn, newName, newDob, newMarks));
                        break;

                    case 5:
                        System.out.print("Enter PRN to delete: ");
                        studoperations.deleteStudent(sc.nextLong());
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}
