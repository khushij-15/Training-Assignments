/**
 * Concepts covered:
 * 1. List
 * 2. Set
 * 3. Map
 * 4. Collection operations (add, remove, contains, size)
 */

import java.util.*;

class Student {
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
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Student)) return false;

        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

public class CollectionDemo {
    public static void main(String[] args) {
        Student student1 = new Student(101, "Khushi");
        Student student2 = new Student(102, "Rahul");
        Student student3 = new Student(103, "Anjali");
        Student student4 = new Student(101, "Khushi");

        // List example
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        System.out.println("Student List:");
        for (Student student : studentList) {
            System.out.println(student);
        }

        // Set example
        Set<Student> studentSet = new HashSet<>();

        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student4); // This will not be added as it's a duplicate

        System.out.println("\nStudent Set: ");
        for (Student student : studentSet) {
            System.out.println(student);
        }

        // Map example
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(student1.getId(), student1);
        studentMap.put(student2.getId(), student2);
        studentMap.put(student3.getId(), student3);

        System.out.println("\nMap: ");
        for (Student student : studentMap.values()) {
            System.out.println(student);
        }

        // Collection Operations
        System.out.println("\nList Size: "
                + studentList.size());

        studentList.remove(student2);

        System.out.println(
                "List Size After Removal: "
                        + studentList.size()
        );

        System.out.println(
                "Contains Student1: "
                        + studentList.contains(student1)
        );
    }
}

/**
 * Output:
 * Student List:
 * Student [id=101, name=Khushi]
 * Student [id=102, name=Rahul]
 * Student [id=103, name=Anjali]
 *
 * Student Set: 
 * Student [id=101, name=Khushi]
 * Student [id=102, name=Rahul]
 * Student [id=103, name=Anjali]
 *
 * Map: 
 * Student [id=101, name=Khushi]
 * Student [id=102, name=Rahul]
 * Student [id=103, name=Anjali]
 *
 * List Size: 3
 * List Size After Removal: 2
 * Contains Student1: true
 */