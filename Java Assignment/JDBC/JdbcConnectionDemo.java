/*
 * Concepts Covered:
 * 1. JDBC Connection
 * 2. Create Table
 * 3. Insert Record
 * 4. Display Records
 * 5. Update Record
 * 6. Delete Record
 * 7. Menu Driven Program
 */

import java.sql.*;
import java.util.Scanner;

public class JdbcConnectionDemo {

    private static final String DATABASE_URL = "jdbc:sqlite:testdb.db";

    private static final String TABLE_NAME = "students";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

       try (Connection connection = DriverManager.getConnection(DATABASE_URL);
     Statement statement = connection.createStatement()) {
            createTable(statement);
            int choice;
            do {
                System.out.println("\n===== STUDENT MENU =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");

                choice = SCANNER.nextInt();
                SCANNER.nextLine();

                switch (choice) {

                    case 1:
                        insertStudent(statement);
                        break;

                    case 2:
                        displayStudents(statement);
                        break;

                    case 3:
                        updateStudent(statement);
                        break;

                    case 4:
                        deleteStudent(statement);
                        break;

                    case 5:
                        System.out.println("Exiting Program...");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }

            } while (choice != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Statement statement) throws SQLException {

        String sql =
                "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT," +
                "phone TEXT" +
                ")";

        statement.execute(sql);
        System.out.println("Table Ready");
    }

    public static void insertStudent(Statement statement) throws SQLException {

        System.out.print("Enter Name: ");
        String name = SCANNER.nextLine();

        System.out.print("Enter Email: ");
        String email = SCANNER.nextLine();

        System.out.print("Enter Phone: ");
        String phone = SCANNER.nextLine();

        String sql =
                "INSERT INTO " +
                TABLE_NAME +
                "(name,email,phone) VALUES" +
                "('" + name + "','" +
                email + "','" +
                phone + "')";

        statement.execute(sql);

        System.out.println("Student Added Successfully");
    }

    public static void displayStudents(Statement statement)
            throws SQLException {

        String sql = "SELECT * FROM " + TABLE_NAME;

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("\n*** STUDENT RECORDS ****");

        while (resultSet.next()) {

            System.out.println( resultSet.getInt("id") + " | " + resultSet.getString("name") + " | " + resultSet.getString("email") + " | " + resultSet.getString("phone"));
        }
    }

    public static void updateStudent(Statement statement) throws SQLException {

        System.out.print("Enter Student ID: ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.print("Enter New Name: ");
        String name = SCANNER.nextLine();

        String sql = "UPDATE " + TABLE_NAME + " SET name='" +name + "' WHERE id=" +id;

        statement.execute(sql);

        System.out.println("Student Updated Successfully");
    }

    public static void deleteStudent(Statement statement) throws SQLException {

        System.out.print("Enter Student ID: ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        String sql ="DELETE FROM " + TABLE_NAME + " WHERE id=" + id;

        statement.execute(sql);

        System.out.println("Student Deleted Successfully");
    }
}