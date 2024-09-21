create table jpa.h_groups
(
    id         varchar(255) not null
        primary key,
    title      varchar(255) not null,
    created_at datetime(6)  not null,
    constraint title
        unique (title)
);

