create table jpa.users
(
    id           varchar(255) not null
        primary key,
    email        varchar(255) null,
    first_name   varchar(255) null,
    last_name    varchar(255) null,
    phone_number varchar(255) null,
    username     varchar(255) null,
    user_type    varchar(255) null,
    short_type   char         null
);

