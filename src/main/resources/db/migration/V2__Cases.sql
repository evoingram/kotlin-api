CREATE TABLE IF NOT EXISTS cases
(
    cases_id      VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    party1        VARCHAR(255),
    party1_type   VARCHAR(255),
    party2        VARCHAR(255),
    party2_type   VARCHAR(255),
    case_number_1 VARCHAR(255),
    case_number_2 VARCHAR(255),
    jurisdiction  VARCHAR(255),
    notes         VARCHAR(255),
);



INSERT INTO cases (party1, party1_type, party2, party2_type, case_number_1, case_number_2, jurisdiction, notes)
VALUES ('Party 1 Test', 'PLAINTIFF', 'Party 2 Test', 'DEFENDANT', 'ca0123456', 'CA022222', 'King County Superior Court',
        'Notes Testing');
