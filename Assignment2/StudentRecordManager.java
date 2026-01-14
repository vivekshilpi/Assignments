package Assignment2;

import java.util.*;
import java.util.regex.Pattern;

// Interface
interface StudentOperations {
    void addStudent(Student s);
    void displayStudents();
    void removeStudent(int rollNo);
    void searchStudent(int rollNo);
}

// Student class
class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}

// Main class
public class StudentRecordManager implements StudentOperations {

    // Using different collections
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();

    // REGEX validation for name
    private boolean isValidName(String name) {
        return Pattern.matches("^[A-Za-z ]+$", name);
    }

    @Override
    public void addStudent(Student s) {
        studentList.add(s);
        studentVector.add(s);
        System.out.println("Student added successfully");
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (Student s : studentList) {
            System.out.println("Roll No: " + s.rollNo + ", Name: " + s.name);
        }
    }

    @Override
    public void removeStudent(int rollNo) {
        boolean removed = studentList.removeIf(s -> s.rollNo == rollNo);
        studentVector.removeIf(s -> s.rollNo == rollNo);

        if (removed)
            System.out.println("Student removed successfully");
        else
            System.out.println("Student not found");
    }

    @Override
    public void searchStudent(int rollNo) {
        for (Student s : studentList) {
            if (s.rollNo == rollNo) {
                System.out.println("Student Found → Roll No: " + s.rollNo + ", Name: " + s.name);
                return;
            }
        }
        System.out.println("Student not found");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentRecordManager manager = new StudentRecordManager();
        int choice;

        try {
            do {
                System.out.println("\n--- STUDENT RECORD MENU ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Remove Student by Roll No");
                System.out.println("4. Search Student by Roll No");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {

                    case 1:
                        System.out.print("Enter Roll Number: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        if (!manager.isValidName(name)) {
                            System.out.println("Invalid name (only letters allowed)");
                            break;
                        }

                        manager.addStudent(new Student(roll, name));
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter Roll Number to remove: ");
                        manager.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to search: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        } finally {
            sc.close();
        }
    }
}

