
-- Create the customers table
CREATE TABLE if not exists  customers
(
    id         VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    age        INTEGER      NULL
);





