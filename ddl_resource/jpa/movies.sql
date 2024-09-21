create table jpa.movies
(
    id           varchar(255) not null
        primary key,
    created_date datetime(6)  null,
    genre        varchar(255) null,
    title        varchar(255) null,
    year         varchar(255) null,
    cinema_id    varchar(255) null,
    constraint fk_cinema_id
        foreign key (cinema_id) references jpa.cinemas (id)
);

