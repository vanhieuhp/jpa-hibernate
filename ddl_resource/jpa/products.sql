create table jpa.products
(
    name        varchar(255)   not null,
    price       decimal(10, 2) not null,
    description varchar(255)   null,
    version     int            null,
    primary key (name, price)
);

