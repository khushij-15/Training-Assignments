package app;

import student.Student;

/**
 * Concepts covered:
 * 1. Packages
 * 2. Importing Classes from Packages
 * 3. Accessing Class Members from Another Package
 */

public class PackageDemo {
    public static void main(String[] args) {
        Student student = new Student("Khushi", "Computer Science");
        student.displayDetails();
    }
}

/**
 * Output:
 * Name: Khushi
 * Branch: Computer Science
 */