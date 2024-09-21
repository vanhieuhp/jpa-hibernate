# CREATE TABLE if not exists books
# (
#     id      VARCHAR(255) NOT NULL,
#     title   VARCHAR(255) NULL,
#     content LONGTEXT     NULL,
#     CONSTRAINT pk_books PRIMARY KEY (id)
# );

CREATE TABLE if not exists books
(
    id    BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255)
);

CREATE TABLE if not exists book_contents
(
    id      BIGINT PRIMARY KEY,
    content LONGTEXT      NULL, -- Large text content NULL
    book_id BIGINT UNIQUE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE TABLE if not exists id_generator_table
(
    gen_name  VARCHAR(255) NOT NULL,
    gen_value BIGINT       NOT NULL,
    PRIMARY KEY (gen_name)
);