create table jpa.squares
(
    id              varchar(255) not null
        primary key,
    square_color_id varchar(255) null,
    side_length     double       not null,
    constraint squares_ibfk_1
        foreign key (square_color_id) references jpa.colors (id)
);

create index square_color_id
    on jpa.squares (square_color_id);

