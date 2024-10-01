CREATE TABLE if not exists smartphones
(
    id    VARCHAR(255) NOT NULL,
    name  VARCHAR(255) NOT NULL,
    price DECIMAL      NOT NULL,
    CONSTRAINT pk_smartphones PRIMARY KEY (id)
);

CREATE TABLE if not exists iphone
(
    id    VARCHAR(255) NOT NULL,
    model VARCHAR(255) NULL,
    CONSTRAINT pk_iphone PRIMARY KEY (id)
);

ALTER TABLE iphone ADD CONSTRAINT FK_IPHONE_ON_ID FOREIGN KEY (id) REFERENCES smartphones (id);

CREATE TABLE if not exists samsung
(
    id   VARCHAR(255) NOT NULL,
    size VARCHAR(255) NULL,
    CONSTRAINT pk_samsung PRIMARY KEY (id)
);

ALTER TABLE samsung ADD CONSTRAINT FK_SAMSUNG_ON_ID FOREIGN KEY (id) REFERENCES smartphones (id);