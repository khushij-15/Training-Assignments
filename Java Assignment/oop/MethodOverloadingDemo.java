/**
 * Concepts covered:
 * 1. Method Overloading
 */

class StudentResults {
    // Calculate total of 2 subjects
    int calculateTotal(int subject1, int subject2) {
        return subject1 + subject2;
    }

    //Calculate total of 3 subjects
    int calculateTotal(int subject1, int subject2, int subject3) {
        return subject1 + subject2 + subject3;
    }

    //Calculate total of 4 subjects
    int calculateTotal(int subject1, int subject2, int subject3, int subject4) {
        return subject1 + subject2 + subject3 + subject4;
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        StudentResults results = new StudentResults();
        int total2Subjects = results.calculateTotal(85, 90);
        int total3Subjects = results.calculateTotal(85, 90, 78);
        int total4Subjects = results.calculateTotal(85, 90, 78, 92);

        System.out.println("Total of 2 subjects: " + total2Subjects);
        System.out.println("Total of 3 subjects: " + total3Subjects);
        System.out.println("Total of 4 subjects: " + total4Subjects);
    }
}
/**
 * Output:
 * Total of 2 subjects: 175
 * Total of 3 subjects: 253
 * Total of 4 subjects: 345
 */