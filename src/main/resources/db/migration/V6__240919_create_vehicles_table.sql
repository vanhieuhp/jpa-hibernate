CREATE TABLE vehicles
(
    id           VARCHAR(255) NOT NULL PRIMARY KEY,
    manufacturer VARCHAR(255),
    seats        INT,
    has_sidecar  BOOLEAN,
    vehicle_type VARCHAR(31) NOT NULL
);

