/**
 * Concepts covered:
 * 1. Inheritance
 * 2. Method Overriding
 * 3. Runtime Polymorphism
 * 4. Super Keyword
 */

class Student {
    private String name;
    private String branch;

    public Student(String name, String branch) {
        this.name = name;
        this.branch = branch;
    }

    // Method of parent class
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
    }
}

// child class that inherits student class
class EngineeringStudent extends Student {
    private String specialization;

    public EngineeringStudent(String name, String branch, String specialization) {
        super(name, branch); // Call the constructor of the parent class
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the method of the parent class
        System.out.println("Specialization: " + specialization);
    } 
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Student student = new EngineeringStudent("Khushi", "Computer Science", "Artificial Intelligence");
        student.displayDetails(); // Runtime polymorphism - calls the overridden method in EngineeringStudent
    }
}

/**
 * Output:
 * Name: Khushi
 * Branch: Computer Science
 * Specialization: Artificial Intelligence
 */