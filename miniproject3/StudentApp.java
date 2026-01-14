package com.miniproject3;

import java.sql.*;
import java.util.Scanner;

public class StudentApp {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASS = "savi2026";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        if (login()) {
            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student\n2. Display All\n3. Search by ID\n4. Update Branch\n5. Delete Student\n6. Display Sorted (Name)\n7. Exit");
                System.out.print("Select Option: ");
                int choice = sc.nextInt();
                try {
                    switch (choice) {
                        case 1 -> addStudent();
                        case 2 -> displayAll();
                        case 3 -> searchById();
                        case 4 -> updateBranch();
                        case 5 -> deleteById();
                        case 6 -> displaySorted();
                        case 7 -> {
                            System.out.println("Exiting...");
                            System.exit(0);
                        }
                        default -> System.out.println("Invalid Choice!");
                    }
                } catch (Exception e) {
                    System.out.println("ALERT: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Login Failed! Access Denied.");
        }
    }

    private static boolean login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        return u.equals("Vikash") && p.equals("Savi2026@");
    }

    private static void addStudent() throws Exception {
        System.out.print("Enter ID (Eno): ");
        int id = sc.nextInt();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Branch: ");
        String branch = sc.next();
        System.out.print("Percentage: ");
        double perc = sc.nextDouble();
        System.out.print("Year of Passing: ");
        int yop = sc.nextInt();
        System.out.print("Semester: ");
        int sem = sc.nextInt();

        // Validation Rules
        if (perc <= 0) throw new StudentValidationException("Percentage must be positive!");
        if (branch.trim().isEmpty()) throw new StudentValidationException("Branch cannot be empty!");
        if (sem <= 0) throw new StudentValidationException("Semester cannot be empty or zero!");

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO TITStudents (id, name, branch, percentage, year_of_passing, semester) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, branch);
            ps.setDouble(4, perc);
            ps.setInt(5, yop);
            ps.setInt(6, sem);
            ps.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new StudentValidationException("Error: ID (Eno) " + id + " already exists!");
        }
    }

    private static void displayAll() throws Exception {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM TITStudents");
            System.out.println("\n--- All Student Records ---");
            while (rs.next()) {
                System.out.println(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), 
                                   rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
            }
        }
    }

    private static void searchById() throws Exception {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM TITStudents WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), 
                                   rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
            } else {
                System.out.println("Record not found.");
            }
        }
    }

    private static void updateBranch() throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter New Branch: ");
        String branch = sc.next();
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement ps = con.prepareStatement("UPDATE TITStudents SET branch = ? WHERE id = ?");
            ps.setString(1, branch);
            ps.setInt(2, id);
            int count = ps.executeUpdate();
            System.out.println(count > 0 ? "Branch updated." : "ID not found.");
        }
    }

    private static void deleteById() throws Exception {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM TITStudents WHERE id = ?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            System.out.println(count > 0 ? "Record deleted." : "ID not found.");
        }
    }

    private static void displaySorted() throws Exception {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM TITStudents ORDER BY name Ascending");
            System.out.println("\n--- Students Sorted by Name ---");
            while (rs.next()) {
                System.out.println(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), 
                                   rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
            }
        }
    }
}