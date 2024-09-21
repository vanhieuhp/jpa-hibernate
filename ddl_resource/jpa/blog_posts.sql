create table jpa.blog_posts
(
    id             bigint auto_increment
        primary key,
    title          varchar(255) null,
    date           date         null,
    timestamp_date datetime     null,
    time           time         null
);

