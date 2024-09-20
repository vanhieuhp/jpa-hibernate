create table jpa.accounts
(
    id         varchar(255)   not null
        primary key,
    created_at datetime       null,
    balance    decimal(10, 2) null,
    is_active  bit            null
);

