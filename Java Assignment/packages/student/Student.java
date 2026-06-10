package student;

public class Student {
    private String name;
    private String branch;

    public Student(String name, String branch) {
        this.name = name;
        this.branch = branch;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
    }
}

