CREATE TABLE if not exists orders
(
    id         VARCHAR(255) PRIMARY KEY,
    price      DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP      NOT NULL
);