create table jpa.patients
(
    id               varchar(255) not null
        primary key,
    name             varchar(255) null,
    permanent_street varchar(255) null,
    permanent_city   varchar(255) null,
    temporary_street varchar(255) null,
    temporary_city   varchar(255) null
);

