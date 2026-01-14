package com.assignments4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdatePercentage {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "savi2026";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String updateQuery = "UPDATE TITStudents SET percentage = percentage * 1.05 WHERE branch = 'CSE'";
            int rowsAffected = stmt.executeUpdate(updateQuery);

            System.out.println("Rows updated: " + rowsAffected);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}