create table jpa.cars
(
    id    varchar(255) not null
        primary key,
    seats int          null,
    constraint cars_ibfk_1
        foreign key (id) references jpa.transports (id)
);

