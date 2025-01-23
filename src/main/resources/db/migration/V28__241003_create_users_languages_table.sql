-- Create the customers table
CREATE TABLE if not exists users_languages
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) not null ,
    FOREIGN KEY (user_id) REFERENCES users (id)
);





