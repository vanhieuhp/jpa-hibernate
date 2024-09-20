CREATE TABLE transports
(
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    manufacturer VARCHAR(255)
);

CREATE TABLE cars
(
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    seats INT,
    FOREIGN KEY (id) REFERENCES transports(id)
);

CREATE TABLE bikes
(
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    has_sidecar BOOLEAN,
    FOREIGN KEY (id) REFERENCES transports(id)
);