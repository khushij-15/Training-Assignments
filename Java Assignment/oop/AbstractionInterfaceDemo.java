/**
 * Concepts covered:
 * 1. Abstraction
 * 2. Abstract Classes
 * 3. Abstract Methods
 * 4. Interfaces
 * 5. Implementation of Interfaces
 */

interface payable {
    void calculateSalary();
}

abstract class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }

    // Abstract method to be implemented by subclasses
    public abstract void performWork();
}

class SoftwareEngineer extends Employee implements payable {
    private double monthlySalary;

    public SoftwareEngineer(String name, String department, double monthlySalary) {
        super(name, department);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public void performWork() {
        System.out.println(name + " is writing code.");
    }

    @Override
    public void calculateSalary() {
        System.out.println("Monthly Salary: " + monthlySalary);
    }
}

public class AbstractionInterfaceDemo {

    public static void main(String[] args) {

        SoftwareEngineer engineer =
                new SoftwareEngineer("Khushi","Engineering", 50000);

        engineer.displayDetails();
        engineer.performWork();
        engineer.calculateSalary();
    }
}

/**
 * Output:
 * Name: Khushi
 * Department: Engineering
 * Khushi is writing code.
 * Monthly Salary: 50000.0
 */