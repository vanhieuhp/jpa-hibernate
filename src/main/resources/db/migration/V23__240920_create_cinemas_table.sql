CREATE TABLE if not exists cinemas
(
    id   VARCHAR(255) NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_cinema PRIMARY KEY (id)
);


alter table movies add column cinema_id VARCHAR(255) NULL;
alter table movies add constraint fk_cinema_id foreign key (cinema_id) references cinemas(id);