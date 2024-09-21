CREATE TABLE if not exists colors
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists circles
(
    id              VARCHAR(255) PRIMARY KEY,
    circle_color_id VARCHAR(255),
    radius          DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (circle_color_id) REFERENCES colors (id)
);

CREATE TABLE if not exists squares
(
    id              VARCHAR(255) PRIMARY KEY,
    square_color_id VARCHAR(255),
    side_length     DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (square_color_id) REFERENCES colors (id)
);