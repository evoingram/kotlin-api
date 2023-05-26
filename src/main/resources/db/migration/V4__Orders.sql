CREATE TABLE IF NOT EXISTS orders
(
    orders_id    VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    cases_id     VARCHAR(60),
    FOREIGN KEY (cases_id) REFERENCES Cases (cases_id),
    invoices_id  VARCHAR(60),
    FOREIGN KEY (invoices_id) REFERENCES Invoices (invoices_id),
    customers_id VARCHAR(60),
    FOREIGN KEY (customers_id) REFERENCES Customers (customers_id),
    turnaround   INT     NOT NULL,
    audio_length INT     NOT NULL,
    order_date   DATE    NOT NULL,
    filed        BOOLEAN NOT NULL
);


INSERT INTO orders (cases_id, invoices_id, customers_id, turnaround, audio_length, order_date, filed)
VALUES ((SELECT cases_id from cases WHERE party1 = 'Party 1 Test' LIMIT 1),
        (SELECT invoices_id from invoices WHERE invoice_date = CURRENT_DATE LIMIT 1),
        (SELECT customers_id from customers WHERE first_name = 'Erica' LIMIT 1),
        '45',
        '60',
        CURRENT_DATE,
        false);
