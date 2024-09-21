CREATE TABLE if not exists employees
(
    id     VARCHAR(255)   PRIMARY KEY,
    name   VARCHAR(255)   NOT NULL,
    salary DOUBLE(10, 2) NOT NULL
);