/*
 * SQL Joins
 *
 * Joins are used to combine data from multiple tables
 * based on a common column.
 *
 * Concepts Covered:
 * 1. INNER JOIN
 * 2. LEFT JOIN
 * 3. RIGHT JOIN
 * 4. FULL JOIN (using UNION)
 */

CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

-- Create Faculty table
CREATE TABLE faculty(faculty_id INT PRIMARY KEY, faculty_name VARCHAR(100), specialization VARCHAR(50) );

-- Create Course table
CREATE TABLE courses( course_id INT PRIMARY KEY, course_name VARCHAR(100), faculty_id INT);

-- Insert Faculty records
INSERT INTO faculty VALUES
(1, 'Swapnil Sir', 'Java'),
(2, 'Om Sir', 'Database'),
(3, 'Soham Sir', 'Backend'),
(4, 'Riya Maam', 'Python');

-- Insert Course records
INSERT INTO courses VALUES
(101, 'Core Java', 1),
(102, 'DBMS', 2),
(103, 'Spring Boot', 3),
(104, 'Machine Learning', NULL);

-- INNER JOIN
-- Display courses along with assigned faculty
SELECT c.course_name, f.faculty_name
FROM courses c
INNER JOIN faculty f
ON c.faculty_id = f.faculty_id;

-- LEFT JOIN
-- Display all courses even if no faculty is assigned
SELECT c.course_name, f.faculty_name
FROM courses c
LEFT JOIN faculty f
ON c.faculty_id = f.faculty_id;

-- RIGHT JOIN
-- Display all faculty even if they are not teaching a course
SELECT c.course_name, f.faculty_name
FROM courses c
RIGHT JOIN faculty f
ON c.faculty_id = f.faculty_id;

-- FULL JOIN (MySQL workaround using UNION)
SELECT c.course_name, f.faculty_name
FROM courses c
LEFT JOIN faculty f
ON c.faculty_id = f.faculty_id
UNION
SELECT c.course_name, f.faculty_name
FROM courses c
RIGHT JOIN faculty f
ON c.faculty_id = f.faculty_id;
