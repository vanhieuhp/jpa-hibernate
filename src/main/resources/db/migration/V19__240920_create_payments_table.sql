CREATE TABLE if not exists payments
(
    id      VARCHAR(255) PRIMARY KEY,
    amount  DECIMAL(10, 2) NOT NULL,
    version VARCHAR(255)   NULL
);