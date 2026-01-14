package com.assignments4;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "savi2026";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Connection Successful");
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Unable to connect");
        }
    }
}