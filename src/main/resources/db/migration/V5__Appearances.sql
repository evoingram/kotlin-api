CREATE TABLE IF NOT EXISTS appearances
(
    appearances_id VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    customers_id   VARCHAR(60),
    FOREIGN KEY (customers_id) REFERENCES Customers (customers_id),
    orders_id      VARCHAR(60),
    FOREIGN KEY (orders_id) REFERENCES Orders (orders_id)
);



INSERT INTO appearances (customers_id, orders_id)
VALUES ((SELECT customers_id from customers WHERE first_name = 'Erica' LIMIT 1),
        (SELECT orders_id from orders WHERE order_date = CURRENT_DATE LIMIT 1),);
