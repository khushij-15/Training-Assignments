/*
 * Database Objects and Functions
 *
 * Concepts Covered:
 * 1. ALTER TABLE
 * 2. DROP TABLE
 * 3. AUTO_INCREMENT
 * 4. VIEW
 * 5. NULL Values
 * 6. Aggregate Functions
 * 7. NULL Functions
 */

CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;

-- Create Books table
CREATE TABLE books( book_id INT AUTO_INCREMENT PRIMARY KEY,
    book_title VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(8,2),
    fine DECIMAL(8,2)
);

-- Insert records
INSERT INTO books (book_title, category, price, fine)
VALUES
('Core Java','Programming',599,NULL),
('Spring Boot','Programming',799,50),
('MySQL Guide','Database',499,NULL),
('Computer Networks','Networking',699,25),
('Operating Systems','System',899,NULL);

-- ALTER TABLE
-- Add a new column
ALTER TABLE books ADD author_name VARCHAR(100);

-- Update author names
UPDATE books SET author_name='Herbert Schildt' WHERE book_id=1;

UPDATE books SET author_name='Craig Walls' WHERE book_id=2;

UPDATE books SET author_name='Paul DuBois' WHERE book_id=3;

-- Create VIEW
CREATE VIEW programming_books AS SELECT book_title, author_name, price
FROM books
WHERE category='Programming';

-- Display View
SELECT * FROM programming_books;

-- NULL Values
SELECT * FROM books WHERE fine IS NULL;

SELECT * FROM books WHERE fine IS NOT NULL;

-- Aggregate Functions
SELECT COUNT(*) AS TotalBooks FROM books;

SELECT SUM(price) AS TotalPrice FROM books;

SELECT AVG(price) AS AveragePrice FROM books;

SELECT MAX(price) AS HighestPrice FROM books;

SELECT MIN(price) AS LowestPrice FROM books;

-- NULL Function
SELECT book_title, IFNULL(fine,0) AS FineAmount FROM books;

-- Drop View
DROP VIEW programming_books;
