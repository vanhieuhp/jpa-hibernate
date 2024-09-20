create table jpa.users_groups
(
    user_id  varchar(255) null,
    group_id varchar(255) null,
    constraint ui_user_group
        unique (user_id, group_id),
    constraint users_groups_ibfk_1
        foreign key (user_id) references jpa.users (id),
    constraint users_groups_ibfk_2
        foreign key (group_id) references jpa.h_groups (id)
);

create index group_id
    on jpa.users_groups (group_id);

