# Student Management System 

## Overview

This Java + JDBC-based application allows you to manage student records in a MySQL database. Each function is modular, reusable, and well-documented. Below is a detailed explanation of each class, function, and method used in the project.

---

## Class: `Student`

**Description:**  
Model class representing a student.

**Fields:**
- `long prn` – Unique student identifier.
- `String name` – Student's name.
- `String dob` – Date of birth (format: YYYY-MM-DD).
- `double marks` – Student's marks.

**Methods:**
- `Student(long prn, String name, String dob, double marks)` – Constructor to initialize a student object.
- `getPrn()` – Returns the PRN.
- `getName()` – Returns the student's name.
- `getDob()` – Returns the date of birth.
- `getMarks()` – Returns the marks.
- `setName(String name)` – Sets the name.
- `setDob(String dob)` – Sets the date of birth.
- `setMarks(double marks)` – Sets the marks.

---

## Class: `DBConnection`

**Description:**  
Handles database connectivity using JDBC.

**Methods:**
- `static Connection getConnection()` – Returns a JDBC connection to the MySQL database using the configured URL, username, and password.

---

## Class: `StudentOperations`

**Description:**  
Performs all CRUD operations on the database.

**Methods:**

### `void addStudent(Student student)`
- Inserts a new student record into the database.
- Uses a `PreparedStatement` to prevent SQL injection.

### `void displayStudents()`
- Fetches and prints all student records from the database.
- Uses a `Statement` and `ResultSet`.

### `void searchByPrn(long prn)`
- Searches for a student using PRN.
- If found, prints the student’s data; otherwise displays “Student not found.”

### `void updateStudent(Student student)`
- Updates student data based on PRN.
- Only name, DOB, and marks are updated.

### `void deleteStudent(long prn)`
- Deletes the student record for the given PRN.

---

## Class: `Main`

**Description:**  
Provides a menu-based interface to access all functionality.

**Logic Flow:**
- Uses `Scanner` for input.
- Presents a loop with the following options:
  1. Add Student – Takes input and adds to DB using `addStudent`.
  2. Display All Students – Lists all students via `displayStudents`.
  3. Search by PRN – Prompts PRN and fetches student using `searchByPrn`.
  4. Update Student – Accepts PRN and new details, updates using `updateStudent`.
  5. Delete Student – Deletes student by PRN using `deleteStudent`.
  0. Exit – Terminates the loop and ends the program.

- Wraps all operations inside a `try-catch` block to handle `SQLException`.

---

## Error Handling

- Each method in `StudentDAO` throws `SQLException` which is caught in the `Main` class and handled gracefully.
- Uses JDBC's `PreparedStatement` to avoid SQL injection and ensure performance.

---
