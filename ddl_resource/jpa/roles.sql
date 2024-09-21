create table jpa.roles
(
    id          varchar(255) not null
        primary key,
    title       varchar(255) not null,
    system_name varchar(255) not null,
    constraint system_name
        unique (system_name),
    constraint title
        unique (title)
);

