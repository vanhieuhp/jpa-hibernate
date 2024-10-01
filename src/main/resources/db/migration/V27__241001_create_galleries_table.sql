CREATE TABLE if not exists galleries
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE if not exists paintings
(
    id         VARCHAR(255) PRIMARY KEY,
    title      VARCHAR(255),
    artist     VARCHAR(255),
    style      VARCHAR(255),
    gallery_id VARCHAR(255),
    FOREIGN KEY (gallery_id) REFERENCES galleries (id)
);