create table jpa.circles
(
    id              varchar(255) not null
        primary key,
    circle_color_id varchar(255) null,
    radius          double       not null,
    constraint circles_ibfk_1
        foreign key (circle_color_id) references jpa.colors (id)
);

create index circle_color_id
    on jpa.circles (circle_color_id);

