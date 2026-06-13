/*
 * Database Normalization
 *
 * Normalization is the process of organizing data
 * in a database to reduce redundancy and improve
 * data integrity.
 *
 * Concepts Covered:
 * 1. First Normal Form (1NF)
 * 2. Second Normal Form (2NF)
 * 3. Third Normal Form (3NF)
 * 4. Boyce-Codd Normal Form (BCNF)
 * 5. Fourth Normal Form (4NF)
 */
-- FIRST NORMAL FORM (1NF)

/*
 * Rules:
 * 1. Each column should contain atomic values.
 * 2. No repeating groups are allowed.
 *
 * Not in 1NF
 *
 * StudentID | StudentName | Courses
 * 101       | Khushi      | Java, DBMS
 */

/*
 * In 1NF
 */

CREATE TABLE student_courses_1nf( student_id INT, student_name VARCHAR(100), course VARCHAR(50) );

-- Example Data
INSERT INTO student_courses_1nf VALUES 
(101,'Khushi','Java'),
(101,'Khushi','DBMS');

-- SECOND NORMAL FORM (2NF)

/*
 * Rules:
 * 1. Table must already be in 1NF.
 * 2. No partial dependency.
 *
 * Not in 2NF
 *
 * StudentID | CourseID | StudentName
 * 101       | C1       | Khushi
 *
 * StudentName depends only on StudentID.
 */

CREATE TABLE students_2nf( student_id INT PRIMARY KEY,student_name VARCHAR(100) );

CREATE TABLE enrollments_2nf( student_id INT, course_id VARCHAR(10));

-- THIRD NORMAL FORM (3NF)

/*
 * Rules:
 * 1. Table must already be in 2NF.
 * 2. No transitive dependency.
 *
 * Not in 3NF
 *
 * StudentID | DepartmentID | DepartmentName
 * 101       | D1           | Computer Science
 *
 * DepartmentName depends on DepartmentID.
 */

CREATE TABLE departments_3nf( department_id VARCHAR(10) PRIMARY KEY, department_name VARCHAR(100) );

CREATE TABLE students_3nf(student_id INT PRIMARY KEY,department_id VARCHAR(10) );

-- BOYCE-CODD NORMAL FORM (BCNF)

/*
 * Rules:
 * 1. Table must already be in 3NF.
 * 2. Every determinant should be a candidate key.
 *
 * BCNF is a stricter version of 3NF.
 */

CREATE TABLE faculty_courses_bcnf(faculty_id INT, course_id INT, PRIMARY KEY(faculty_id, course_id) );

-- FOURTH NORMAL FORM (4NF)

/*
 * Rules:
 * 1. Table must already be in BCNF.
 * 2. No multivalued dependencies.
 *
 * Not in 4NF
 *
 * Student | Course | Hobby
 * Khushi  | Java   | Reading
 * Khushi  | DBMS   | Reading
 * Reason:
 * A student can have multiple courses and multiple hobbies.
 * Course and Hobby are independent multivalued attributes.
 * This creates unnecessary data duplication.
 *
 * "Reading" is repeated for every course taken by Khushi.
 *
 * Therefore, the table contains a multivalued dependency
 * and is not in Fourth Normal Form (4NF).
 */

CREATE TABLE student_courses_4nf( student_name VARCHAR(100), course VARCHAR(50) );

CREATE TABLE student_hobbies_4nf( student_name VARCHAR(100), hobby VARCHAR(50) );
