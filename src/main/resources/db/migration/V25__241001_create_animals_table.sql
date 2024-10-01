CREATE TABLE if not exists animals
(
    id   VARCHAR(255) NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_animals PRIMARY KEY (id)
);

CREATE TABLE if not exists cats
(
    id   VARCHAR(255) NOT NULL,
    name VARCHAR(255) NULL,
    legs INT          NULL,
    CONSTRAINT pk_cats PRIMARY KEY (id)
);

CREATE TABLE if not exists dogs
(
    id    VARCHAR(255) NOT NULL,
    name  VARCHAR(255) NULL,
    color VARCHAR(255) NULL,
    CONSTRAINT pk_dogs PRIMARY KEY (id)
);