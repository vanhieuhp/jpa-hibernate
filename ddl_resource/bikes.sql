create table jpa.bikes
(
    id          varchar(255) not null
        primary key,
    has_sidecar tinyint(1)   null,
    constraint bikes_ibfk_1
        foreign key (id) references jpa.transports (id)
);

