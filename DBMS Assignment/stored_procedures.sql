/*
 * Stored Procedures
 *
 * A Stored Procedure is a precompiled collection
 * of SQL statements stored in the database.
 *
 * Concepts Covered:
 * 1. Stored Procedure
 * 2. Procedure without Parameters
 * 3. Procedure with Parameters
 * 4. Prepared Statement (Theory)
 * 5. Callable Statement (Theory)
 */

CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;

-- Create Books table
CREATE TABLE books( book_id INT AUTO_INCREMENT PRIMARY KEY,
    book_title VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(8,2)
);

-- Insert sample records
INSERT INTO books(book_title, category, price)
VALUES
('Core Java','Programming',599.00),
('Spring Boot','Programming',799.00),
('MySQL Guide','Database',499.00),
('Computer Networks','Networking',699.00),
('Operating Systems','System',899.00);

-- Change delimiter
DELIMITER //

-- Procedure 1: Display all books
CREATE PROCEDURE DisplayAllBooks()
BEGIN
    SELECT *
    FROM books;
END //

-- Procedure 2: Display books by category
CREATE PROCEDURE DisplayBooksByCategory(
    IN p_category VARCHAR(50)
)
BEGIN
    SELECT *
    FROM books
    WHERE category = p_category;
END //

-- Procedure 3: Display books above a given price
CREATE PROCEDURE DisplayBooksAbovePrice(
    IN p_price DECIMAL(8,2)
)
BEGIN
    SELECT *
    FROM books
    WHERE price > p_price;
END //

CREATE PROCEDURE GetBookCount(OUT p_count INT)
BEGIN
    SELECT COUNT(*) INTO p_count FROM books;
END //

-- Restore delimiter
DELIMITER ;

-- Execute Procedures
CALL DisplayAllBooks();

CALL DisplayBooksByCategory('Programming');

CALL DisplayBooksAbovePrice(600);

CALL GetBookCount(@total);
SELECT @total;
/*
 * Prepared Statement:
 * Used in JDBC to execute parameterized SQL queries.
 *
 * Example:
 * SELECT * FROM books WHERE category = ?;
 *
 * Callable Statement:
 * Used in JDBC to call Stored Procedures.
 *
 * Example:
 * CALL DisplayAllBooks();
 */
