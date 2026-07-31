START TRANSACTION;

UPDATE books
SET stock = stock - 1
WHERE book_id = 1;

COMMIT;