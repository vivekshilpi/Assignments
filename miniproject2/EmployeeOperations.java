package miniproject2;

public interface EmployeeOperations {
    void addEmployee(int id, String name, String dept, double salary);
    void displayAll();
    void searchById(int id);
    void updateSalary(int id, double salary);
    void deleteEmployee(int id);
    void displaySorted();
    void displayDepartments();
}
