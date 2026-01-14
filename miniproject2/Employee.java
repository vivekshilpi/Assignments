package miniproject2;

/* ===================== MODEL CLASS ===================== */
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }

    public static Employee fromFile(String line) {
        String[] d = line.split(",");
        return new Employee(
                Integer.parseInt(d[0]),
                d[1],
                d[2],
                Double.parseDouble(d[3])
        );
    }
}
