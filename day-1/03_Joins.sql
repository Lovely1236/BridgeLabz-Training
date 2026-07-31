-- INNER JOIN
SELECT c.full_name,
       o.order_id
FROM customers c
JOIN orders o
ON c.customer_id = o.customer_id;

-- LEFT JOIN
SELECT c.full_name,
       o.order_id
FROM customers c
LEFT JOIN orders o
ON c.customer_id = o.customer_id;