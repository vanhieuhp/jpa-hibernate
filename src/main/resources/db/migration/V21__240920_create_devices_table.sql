CREATE TABLE if not exists devices
(
    id      VARCHAR(255) PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);