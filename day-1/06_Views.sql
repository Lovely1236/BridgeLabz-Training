CREATE VIEW customer_orders AS
SELECT c.full_name,
       o.order_id
FROM customers c
JOIN orders o
ON c.customer_id = o.customer_id;