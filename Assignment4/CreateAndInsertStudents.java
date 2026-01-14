package com.assignments4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateAndInsertStudents {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "savi2026";

       
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String createTable = "CREATE TABLE TITStudents (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "branch VARCHAR(10), " +
                    "percentage DOUBLE, " +
                    "year_of_passing INT, " +
                    "semester INT)";
            
            stmt.executeUpdate(createTable);
            
            System.out.println("Table Created");

            String insertData = "INSERT INTO TITStudents VALUES " +
                    "(1, 'Vikash', 'CSE', 75.0, 2024, 7), " +
                    "(2, 'Vishal', 'Civil', 80.0, 2024, 5), " +
                    "(3, 'Virendra', 'EC', 70.0, 2025, 7)";
            stmt.executeUpdate(insertData);
            System.out.println("Records Inserted");

            con.close();
       
    }
}
