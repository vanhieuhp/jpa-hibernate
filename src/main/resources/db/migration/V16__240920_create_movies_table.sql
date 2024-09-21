create table movies
(
    id           varchar(255) not null
        primary key,
    created_date datetime(6)  null,
    genre        varchar(255) null,
    title        varchar(255) null,
    year         varchar(255) null
);

