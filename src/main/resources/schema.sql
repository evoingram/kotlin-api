CREATE TABLE IF NOT EXISTS users
(
    users_id VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    username VARCHAR NOT NULL,
    email    VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS customers
(
    customers_id   VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    users_id       VARCHAR(60),
    FOREIGN KEY (users_id) REFERENCES Users (users_id),
    company        VARCHAR,
    mr_ms          VARCHAR,
    first_name     VARCHAR NOT NULL,
    last_name      VARCHAR NOT NULL,
    city           VARCHAR NOT NULL,
    state          VARCHAR NOT NULL,
    postal_code    VARCHAR NOT NULL,
    job_title      VARCHAR,
    business_phone VARCHAR,
    address1       VARCHAR,
    address2       VARCHAR,
    notes          VARCHAR
);

CREATE TABLE IF NOT EXISTS messages
(
    messages_id VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    text        VARCHAR NOT NULL
);

INSERT INTO users (username, email)
VALUES ('buttercup', 'email');

INSERT INTO customers (users_id, company, mr_ms, first_name, last_name, city, state, postal_code, job_title,
                       business_phone, address1, address2, notes)
VALUES ((SELECT users_id from users WHERE username = 'buttercup' LIMIT 1), 'A Quo Co', 'Ms', 'Erica', 'Ingram',
        'Seattle',
        'WA',
        '98119', 'Owner',
        '1234567890', '123 Anywhere USA', 'Address2', 'Notes Here');