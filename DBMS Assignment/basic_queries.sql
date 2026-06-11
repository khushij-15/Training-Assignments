/*
 * Basic SQL Queries
 *
 * SQL (Structured Query Language) is used to create, manage,
 * and manipulate data stored in a relational database.
 *
 * Concepts Covered:
 * 1. CREATE DATABASE
 * 2. CREATE TABLE
 * 3. INSERT
 * 4. SELECT
 * 5. DISTINCT
 * 6. WHERE
 * 7. AND
 * 8. ORDER BY
 * 9. UPDATE
 * 10. DELETE
 * 11. OR
 * 12. LIKE
 * 13. IN
 * 14. BETWEEN
 * 16. ALIAS
 */

CREATE DATABASE college_db;
USE college_db;


-- creating table in sql
CREATE TABLE students( student_id INT PRIMARY KEY, student_name VARCHAR(100), branch VARCHAR(30), percentage DECIMAL(5,2) ) ;
-- Insert records into Student table
INSERT INTO students VALUES(1, 'Khushi', 'Computer Science', 85.50), (2, 'Harshita', 'Information Technology', 78.25), (3, 'Aryan', 'Computer Science', 91.75);
-- Display all student records
SELECT * FROM students;
-- Display unique branches
SELECT DISTINCT branch FROM students;
-- Display students with percentage greater than 80
SELECT * FROM students WHERE percentage > 80;
-- AND
select * FROM students WHERE percentage > 80 AND branch = 'Computer Science';
-- Display students sorted by percentage in descending order
SELECT * FROM students ORDER BY percentage DESC;
-- Update Student percentage
UPDATE students SET percentage = 88.88 WHERE student_id = 2;
-- Delete a student with id 3
DELETE FROM students WHERE student_id=3;
-- OR keyword
SELECT * FROM students where branch = 'Computer Science' OR percentage > 90;
-- LIKE
SELECT * FROM students WHERE student_name LIKE '%a%';
-- IN
SELECT * FROM students WHERE branch IN ('Computer Science', 'Information Technology');
-- BETWEEN
SELECT * FROM students WHERE percentage BETWEEN 80 AND 90;
-- ALIAS
SELECT student_name AS Name, percentage AS Marks FROM students;








