package miniproject2;

import java.io.*;
import java.util.*;

public class EmployeeMain {

	private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeOperations service = new EmployeeService(); // polymorphism

        /* -------- Login -------- */
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!USERNAME.equals(user) || !PASSWORD.equals(pass)) {
            System.out.println("Invalid login credentials");
            return;
        }

        System.out.println("Login successful");

        int choice;
        do {
            try {
                System.out.println("\n--- EMPLOYEE MANAGEMENT SYSTEM ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Display All Employees");
                System.out.println("3. Search Employee by ID");
                System.out.println("4. Update Employee Salary");
                System.out.println("5. Delete Employee");
                System.out.println("6. Display Sorted Employees");
                System.out.println("7. Display Departments");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();

                        service.addEmployee(id, name, dept, salary);
                        break;

                    case 2:
                        service.displayAll();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        service.searchById(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int uid = sc.nextInt();
                        System.out.print("New Salary: ");
                        service.updateSalary(uid, sc.nextDouble());
                        break;

                    case 5:
                        System.out.print("ID: ");
                        service.deleteEmployee(sc.nextInt());
                        break;

                    case 6:
                        service.displaySorted();
                        break;

                    case 7:
                        service.displayDepartments();
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 8);

        sc.close();
    }
	
}
