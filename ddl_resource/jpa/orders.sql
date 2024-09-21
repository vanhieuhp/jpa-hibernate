create table jpa.orders
(
    id         varchar(255)   not null
        primary key,
    price      decimal(10, 2) not null,
    created_at timestamp      not null
);

