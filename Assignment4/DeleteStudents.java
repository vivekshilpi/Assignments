package com.assignments4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteStudents {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/student_db";
		String user = "root";
		String password = "savi2026";

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String deleteQuery = "DELETE FROM TITStudents WHERE year_of_passing = 2024 AND branch = 'Civil'";
			int rowsDeleted = stmt.executeUpdate(deleteQuery);

			System.out.println("Rows deleted: " + rowsDeleted);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}