package com.assignments4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "savi2026";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String selectQuery = "SELECT * FROM TITStudents WHERE semester = 7 AND branch = 'EC'";
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   ", Name: " + rs.getString("name") + 
                                   ", Branch: " + rs.getString("branch") + 
                                   ", Percentage: " + rs.getDouble("percentage"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}