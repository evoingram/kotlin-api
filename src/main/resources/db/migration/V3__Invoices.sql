CREATE TABLE IF NOT EXISTS invoices
(
    invoices_id  BIGINT PRIMARY KEY,
    invoice_date DATE    NOT NULL,
    customers_id VARCHAR(60),
    FOREIGN KEY (customers_id) REFERENCES Customers (customers_id),
    cases_id     VARCHAR(255),
    FOREIGN KEY (cases_id) REFERENCES Cases (cases_id),
    paid         BOOLEAN NOT NULL,
    factored     BOOLEAN NOT NULL
);


INSERT INTO invoices (invoice_date, customers_id, cases_id, paid, factored)
VALUES (CURRENT_DATE,
        (SELECT customers_id from customers WHERE first_name = 'Erica' LIMIT 1),
        (SELECT cases_id from cases WHERE party1 = 'Party 1 Test' LIMIT 1),
        false,
        true);
