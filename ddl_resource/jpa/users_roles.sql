create table jpa.users_roles
(
    user_id varchar(255) not null,
    role_id varchar(255) not null,
    constraint ui_user_role
        unique (user_id, role_id),
    constraint users_roles_ibfk_1
        foreign key (user_id) references jpa.users (id),
    constraint users_roles_ibfk_2
        foreign key (role_id) references jpa.roles (id)
);

create index role_id
    on jpa.users_roles (role_id);

