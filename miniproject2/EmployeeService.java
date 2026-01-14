package miniproject2;

import java.io.*;
import java.util.*;

/* ===================== SERVICE CLASS ===================== */
class EmployeeService implements EmployeeOperations {

    private List<Employee> employees = new ArrayList<>();
    private final String FILE = "employees.txt";

    public EmployeeService() {
        loadFromFile();
    }

    /* -------- File Handling -------- */
    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null)
                employees.add(Employee.fromFile(line));
        } catch (IOException ignored) {}
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Employee e : employees) {
                bw.write(e.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("File update failed");
        }
    }

    private boolean isDuplicateId(int id) {
        return employees.stream().anyMatch(e -> e.getId() == id);
    }

    /* -------- CRUD Operations -------- */
    @Override
    public void addEmployee(int id, String name, String dept, double salary) {
        if (isDuplicateId(id))
            throw new RuntimeException("Employee ID must be unique");
        if (salary <= 0)
            throw new RuntimeException("Salary must be positive");
        if (dept == null || dept.trim().isEmpty())
            throw new RuntimeException("Department cannot be empty");

        employees.add(new Employee(id, name, dept, salary));
        saveToFile();
        System.out.println("Employee added successfully");
    }

    @Override
    public void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        employees.forEach(e ->
                System.out.println("ID: " + e.getId() +
                        " | Name: " + e.getName() +
                        " | Dept: " + e.getDepartment() +
                        " | Salary: " + e.getSalary()));
    }

    @Override
    public void searchById(int id) {
        Employee e = employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);

        System.out.println(e != null ? e : "Employee not found");
    }

    @Override
    public void updateSalary(int id, double salary) {
        if (salary <= 0)
            throw new RuntimeException("Salary must be positive");

        Employee e = employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);

        if (e == null)
            throw new RuntimeException("Employee not found");

        e.setSalary(salary);
        saveToFile();
        System.out.println("Salary updated successfully");
    }

    @Override
    public void deleteEmployee(int id) {
        Employee e = employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);

        if (e == null)
            throw new RuntimeException("Employee not found");

        employees.remove(e);
        saveToFile();
        System.out.println("Employee deleted successfully");
    }

    @Override
    public void displaySorted() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(e -> System.out.println(e.getId() + " | " + e.getName()));
    }

    @Override
    public void displayDepartments() {
        Set<String> depts = new HashSet<>();
        for (Employee e : employees)
            depts.add(e.getDepartment());

        System.out.println("Departments:");
        depts.forEach(System.out::println);
    }
}
