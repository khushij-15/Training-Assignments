/*
 * Concepts Covered:
 * 1. Class and Objects
 * 2. State and Behavior
 * 3. Data Types and Variables
 * 4. Access Modifiers
 * 5. Constructor
 * 6. Final Keyword
 * 7. Methods
 */
class Student {
    // State (variables)
    private String name;
    private String branch;
    private double percentage;
    // Constant for passing percentage
    private static final double PASSING_PERCENTAGE = 40.0;
    // Constructor
    public Student(String name, String branch, double percentage) {
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
    }

    // Behavior (methods)
    void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("Percentage: " + percentage);
    }
    // Getters
    public String getName() {
        return name;
    }
    String getBranch() {
        return branch;
    }
    double getPercentage() {
        return percentage;
    }
    boolean isPassed() {
        return percentage >= PASSING_PERCENTAGE;
    }
    String getResult() {
        return isPassed() ? "Passed" : "Failed";
    }
}

public class StudentDemoV1 {
    public static void main(String[] args) {
        // Create student objects
        Student student1 = new Student("Khushi", "Computer Science", 85.5);
        Student student2 = new Student("Anisha", "Information Technology", 35.0);
        // Display student details and results
        System.out.println("Student 1 Details:");
        student1.displayStudentDetails();
        System.out.println("Result: " + student1.getResult());
        System.out.println("\nStudent 2 Details:");
        student2.displayStudentDetails();
        System.out.println("Result: " + student2.getResult());
    }
}
/**
 * Output:
 * Student 1 Details:
 * Name: Khushi
 * Branch: Computer Science
 * Percentage: 85.5
 * Result: Passed
 *
 * Student 2 Details:
 * Name: Anisha
 * Branch: Information Technology
 * Percentage: 35.0
 * Result: Failed
 * 
 */