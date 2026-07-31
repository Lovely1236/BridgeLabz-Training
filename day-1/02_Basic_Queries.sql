INSERT INTO books(title, author, price)
VALUES ('Atomic Habits','James Clear',499.00);

SELECT * FROM books;

UPDATE books
SET price = 599
WHERE book_id = 1;

DELETE FROM books
WHERE book_id = 2;