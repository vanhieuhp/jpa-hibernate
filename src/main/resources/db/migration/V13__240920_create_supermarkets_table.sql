CREATE TABLE if not exists supermarkets
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists supermarket_addresses
(
    supermarket_id VARCHAR(255) NOT NULL,
    street         VARCHAR(255),
    city           VARCHAR(255),
    FOREIGN KEY (supermarket_id) REFERENCES supermarkets (id)
);