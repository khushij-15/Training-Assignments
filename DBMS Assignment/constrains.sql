/*
 * SQL Constraints
 * Constraints are rules applied to columns
 * to maintain data integrity.
 * Concepts Covered:
 * 1. PRIMARY KEY
 * 2. FOREIGN KEY
 * 3. NOT NULL
 * 4. UNIQUE
 * 5. CHECK
 * 6. DEFAULT
 * 7. INDEX
 */

CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

-- Create Category table
CREATE TABLE categories(category_id INT PRIMARY KEY, category_name VARCHAR(50) UNIQUE NOT NULL);

-- Create Books table
CREATE TABLE books(book_id INT PRIMARY KEY,
    book_title VARCHAR(100) NOT NULL,
    author_email VARCHAR(100) UNIQUE,
    price DECIMAL(8,2) CHECK(price > 0), #check that price should be always > 0
    status VARCHAR(20) DEFAULT 'Available', #default value to be available
    category_id INT,
    FOREIGN KEY(category_id)
        REFERENCES categories(category_id)
);

-- Insert categories
INSERT INTO categories VALUES
(1,'Programming'),
(2,'Database'),
(3,'Networking');

-- Insert books
INSERT INTO books
(book_id, book_title, author_email, price, category_id)
VALUES
(101,'Core Java','java@author.com',599.00,1),
(102,'MySQL Guide','mysql@author.com',450.00,2),
(103,'Computer Networks','network@author.com',700.00,3);
#(104, 'CP','cp@author.com',0.00,1); this line gives error of check constrain violated.

-- Display all categories
SELECT * FROM categories;

-- Display all books
SELECT * FROM books;

-- Create Index on book_title column
CREATE INDEX idx_book_title ON books(book_title);

-- Search using indexed column
SELECT * FROM books WHERE book_title = 'Core Java';
