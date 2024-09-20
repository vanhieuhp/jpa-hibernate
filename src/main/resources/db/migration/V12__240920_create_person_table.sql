CREATE TABLE persons
(
    id       VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE person_contacts
(
    person_id    VARCHAR(255) PRIMARY KEY REFERENCES persons (id),
    email        VARCHAR(255),
    phone_number VARCHAR(20)
);