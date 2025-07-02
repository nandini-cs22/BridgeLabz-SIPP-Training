abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
    }
}

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double fixedBonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedBonus) {
        super(employeeId, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    public double calculateSalary() {
        return getBaseSalary() + fixedBonus;
    }

    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }

    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];

        FullTimeEmployee fte = new FullTimeEmployee(101, "Alice", 50000, 10000);
        fte.assignDepartment("HR");

        PartTimeEmployee pte = new PartTimeEmployee(102, "Bob", 20000, 40, 200);
        pte.assignDepartment("Tech");

        employees[0] = fte;
        employees[1] = pte;

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: " + emp.calculateSalary());
            if (emp instanceof Department) {
                System.out.println("Department: " + ((Department) emp).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}
