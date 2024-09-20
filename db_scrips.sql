CREATE TABLE IF NOT EXISTS articles
(
    id      VARCHAR(255) PRIMARY KEY,
    title   VARCHAR(255) UNIQUE,
    content VARCHAR(255),
    name    VARCHAR(255),
    login   VARCHAR(255)
);
