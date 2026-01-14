package Assignment2;

import java.util.*;
import java.util.regex.Pattern;

// Interface (RENAMED)
interface UniversityOperations {
    void addStudent(int id, String name, String course, int marks);
    void displayStudents();
    void removeStudent(int id);
    void searchStudent(int id);
    void sortByMarks();
    void convertToTreeMap();
    void countCourseWise();
    void displayCourses();
}

// Student model (RENAMED)
class UniStudent {
    int id;
    String name;
    String course;
    int marks;

    UniStudent(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + course + " | " + marks;
    }
}

// Main class
public class UniversityManager implements UniversityOperations {

    // Collections
    List<UniStudent> arrayList = new ArrayList<>();
    Vector<UniStudent> vector = new Vector<>();
    Stack<UniStudent> stack = new Stack<>();

    Map<Integer, UniStudent> hashMap = new HashMap<>();
    Hashtable<Integer, UniStudent> hashtable = new Hashtable<>();
    TreeMap<Integer, UniStudent> treeMap = new TreeMap<>();

    Set<String> courseSet = new HashSet<>();

    // REGEX validation
    private boolean validName(String name) {
        return Pattern.matches("^[A-Za-z ]+$", name);
    }

    private boolean validCourse(String course) {
        return Pattern.matches("^[A-Za-z ]+$", course);
    }

    private boolean isDuplicate(int id) {
        return hashMap.containsKey(id);
    }

    @Override
    public void addStudent(int id, String name, String course, int marks) {

        if (isDuplicate(id)) {
            System.out.println("Duplicate student ID not allowed");
            return;
        }

        UniStudent s = new UniStudent(id, name, course, marks);

        arrayList.add(s);
        vector.add(s);
        stack.push(s);
        hashMap.put(id, s);
        hashtable.put(id, s);

        courseSet.add(course);

        System.out.println("Student added successfully");
    }

    @Override
    public void displayStudents() {
        if (arrayList.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        System.out.println("\nID | Name | Course | Marks");
        for (UniStudent s : arrayList)
            System.out.println(s);
    }

    @Override
    public void removeStudent(int id) {
        if (!hashMap.containsKey(id)) {
            System.out.println("Student not found");
            return;
        }

        hashMap.remove(id);
        hashtable.remove(id);
        arrayList.removeIf(st -> st.id == id);
        vector.removeIf(st -> st.id == id);

        System.out.println("Student removed successfully");
    }

    @Override
    public void searchStudent(int id) {
        UniStudent s = hashMap.get(id);
        if (s != null)
            System.out.println("Found: " + s);
        else
            System.out.println("Student not found");
    }

    @Override
    public void sortByMarks() {
        arrayList.sort((a, b) -> b.marks - a.marks);
        System.out.println("Students sorted by marks (descending)");
        displayStudents();
    }

    @Override
    public void convertToTreeMap() {
        treeMap = new TreeMap<>(hashMap);
        System.out.println("HashMap converted to TreeMap (sorted by ID)");
        treeMap.forEach((k, v) -> System.out.println(v));
    }

    @Override
    public void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (UniStudent s : arrayList) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("\nCourse-wise Student Count:");
        countMap.forEach((k, v) -> System.out.println(k + " → " + v));
    }

    @Override
    public void displayCourses() {
        System.out.println("\nUnique Courses:");
        for (String c : courseSet)
            System.out.println(c);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniversityManager um = new UniversityManager();
        int choice;

        try {
            do {
                System.out.println("\n--- UNIVERSITY STUDENT MANAGEMENT ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Remove Student by ID");
                System.out.println("4. Search Student by ID");
                System.out.println("5. Sort Students by Marks");
                System.out.println("6. Convert HashMap to TreeMap");
                System.out.println("7. Count Students Course-wise");
                System.out.println("8. Display All Courses");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Course: ");
                        String course = sc.nextLine();

                        System.out.print("Marks: ");
                        int marks = sc.nextInt();

                        if (!um.validName(name) || !um.validCourse(course)) {
                            System.out.println("Invalid name or course");
                            break;
                        }

                        um.addStudent(id, name, course, marks);
                        break;

                    case 2:
                        um.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        um.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        um.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        um.sortByMarks();
                        break;

                    case 6:
                        um.convertToTreeMap();
                        break;

                    case 7:
                        um.countCourseWise();
                        break;

                    case 8:
                        um.displayCourses();
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 9);

        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        } finally {
            sc.close();
        }
    }
}

