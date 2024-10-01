CREATE TABLE IF not exists patients
(
    id               VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(255),
    permanent_street VARCHAR(255),
    permanent_city   VARCHAR(255),
    temporary_street VARCHAR(255),
    temporary_city   VARCHAR(255)
);