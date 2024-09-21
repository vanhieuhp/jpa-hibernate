create table jpa.supermarket_addresses
(
    supermarket_id varchar(255) not null,
    street         varchar(255) null,
    city           varchar(255) null,
    constraint supermarket_addresses_ibfk_1
        foreign key (supermarket_id) references jpa.supermarkets (id)
);

create index supermarket_id
    on jpa.supermarket_addresses (supermarket_id);

