create table if not exists authors
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age  INTEGER
);

create table if not exists articles
(
    id        VARCHAR(255) PRIMARY KEY,
    title     VARCHAR(255) NOT NULL,
    content   VARCHAR(255) NOT NULL,
    review    LONGTEXT     NULL,
    rate      int          NULL,
    author_id VARCHAR(255) REFERENCES authors (id)
);