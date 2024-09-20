create table if not exists users
(
    id           varchar(255) primary key not null,
    email        varchar(255)             null,
    first_name   varchar(255)             null,
    last_name    varchar(255)             null,
    phone_number varchar(255)             null,
    username     varchar(255)             null
);

create table if not exists roles
(
    id          varchar(255) primary key not null,
    title       varchar(255) unique      not null,
    system_name varchar(255) unique      not null
);

create table if not exists users_roles
(
    user_id varchar(255) NOT NULL REFERENCES users (id),
    role_id varchar(255) NOT NULL REFERENCES roles (id)
);

# CREATE UNIQUE INDEX ui_user_role ON users_roles (user_id, role_id);

create table if not exists h_groups
(
    id         VARCHAR(255) PRIMARY KEY,
    title      VARCHAR(255) UNIQUE NOT NULL,
    created_at datetime(6)           NOT NULL
);

CREATE TABLE IF NOT EXISTS users_groups
(
    user_id  VARCHAR(255) REFERENCES users (id),
    group_id VARCHAR(255) REFERENCES h_groups (id)
);
# CREATE UNIQUE INDEX ui_user_group ON users_groups (user_id, group_id);
