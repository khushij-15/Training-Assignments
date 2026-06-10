/**
 * Concepts covered:
 * 1. Sorting Primitive Data
 * 2. Comparable Interface
 * 3. Comparator Interface
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id); // Sort by ID
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
}

// Comparator to sort by name
class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

public class CollectionSortingDemo {
    public static void main(String[] args) {
        // Sorting primitive values
        List<Integer> marks = new ArrayList<>();

        marks.add(85);
        marks.add(70);
        marks.add(95);
        marks.add(60);

        Collections.sort(marks);

        System.out.println("Sorted Marks:");
        System.out.println(marks);

        // Sorting custom objects
        List<Student> students = new ArrayList<>();

        students.add(new Student(103, "Khushi"));
        students.add(new Student(101, "Aryan"));
        students.add(new Student(102, "Anisha"));

        // Comparable - Sort by ID
        Collections.sort(students);

        System.out.println("\nStudents Sorted By ID:");

        for (Student student : students) {
            System.out.println(student);
        }

        // Comparator - Sort by Name
        Collections.sort(students,new StudentNameComparator());

        System.out.println("\nStudents Sorted By Name:");

        for (Student student : students) {
            System.out.println(student);
        }

    }
}

/**
 * Output:
 * Sorted Marks:
 * [60, 70, 85, 95]

 * Students Sorted By ID:
 * Student [id=101, name=Aryan]
 * Student [id=102, name=Anisha]
 * Student [id=103, name=Khushi]

 * Students Sorted By Name:
 * Student [id=102, name=Anisha]
 * Student [id=101, name=Aryan]
 * Student [id=103, name=Khushi]
 */
