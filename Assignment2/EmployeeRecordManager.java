package Assignment2;

import java.util.*;
import java.util.regex.Pattern;

// Interface
interface EmployeeOperations {
    void addEmployee(int id, String name);
    void displayEmployees();
    void searchEmployee(int id);
    void removeEmployee(int id);
}

// Employee class
class Employee {
    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId + ", Name: " + name;
    }
}

// Main class
public class EmployeeRecordManager implements EmployeeOperations {

    // Using different Maps
    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashtable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    // REGEX for name validation
    private boolean isValidName(String name) {
        return Pattern.matches("^[A-Za-z ]+$", name);
    }

    @Override
    public void addEmployee(int id, String name) {
        Employee emp = new Employee(id, name);

        hashMap.put(id, emp);
        hashtable.put(id, emp);
        treeMap.put(id, emp);

        System.out.println("Employee added successfully");
    }

    @Override
    public void displayEmployees() {
        if (hashMap.isEmpty()) {
            System.out.println("No employee records found");
            return;
        }

        System.out.println("\n--- Employees (HashMap) ---");
        hashMap.forEach((k, v) -> System.out.println(k + " → " + v));

        System.out.println("\n--- Employees (Hashtable) ---");
        hashtable.forEach((k, v) -> System.out.println(k + " → " + v));

        System.out.println("\n--- Employees (TreeMap - Sorted) ---");
        treeMap.forEach((k, v) -> System.out.println(k + " → " + v));
    }

    @Override
    public void searchEmployee(int id) {
        Employee emp = hashMap.get(id);
        if (emp != null)
            System.out.println("Employee Found: " + emp);
        else
            System.out.println("Employee not found");
    }

    @Override
    public void removeEmployee(int id) {
        if (hashMap.remove(id) != null) {
            hashtable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee removed successfully");
        } else {
            System.out.println("Employee not found");
        }
    }

    // Demonstrating null key & value support
    private void demonstrateNullSupport() {

        System.out.println("\n--- Null Support Demonstration ---");

        // HashMap allows null
        hashMap.put(null, new Employee(0, "NullKey"));
        hashMap.put(999, null);
        System.out.println("HashMap supports null key & null value");

        // Hashtable does NOT allow null
        try {
            hashtable.put(null, new Employee(0, "Test"));
        } catch (Exception e) {
            System.out.println("Hashtable does NOT support null key/value");
        }

        // TreeMap does NOT allow null key
        try {
            treeMap.put(null, new Employee(0, "Test"));
        } catch (Exception e) {
            System.out.println("TreeMap does NOT support null key");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeRecordManager manager = new EmployeeRecordManager();
        int choice;

        try {
            do {
                System.out.println("\n--- EMPLOYEE RECORD MENU ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Search Employee by ID");
                System.out.println("4. Remove Employee by ID");
                System.out.println("5. Demonstrate Null Support");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        if (!manager.isValidName(name)) {
                            System.out.println("Invalid name (letters only)");
                            break;
                        }

                        manager.addEmployee(id, name);
                        break;

                    case 2:
                        manager.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to search: ");
                        manager.searchEmployee(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to remove: ");
                        manager.removeEmployee(sc.nextInt());
                        break;

                    case 5:
                        manager.demonstrateNullSupport();
                        break;

                    case 6:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 6);

        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        } finally {
            sc.close();
        }
    }
}

