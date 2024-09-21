CREATE TABLE if not exists courses
(
    id    VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255)
);

CREATE TABLE if not exists course_details
(
    id          VARCHAR(255) PRIMARY KEY,
    description TEXT,
    CONSTRAINT fk_course FOREIGN KEY (id) REFERENCES courses (id)
);