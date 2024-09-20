CREATE TABLE if not exists blog_posts
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    title          VARCHAR(255)          NULL,
    date           date                  NULL,
    timestamp_date datetime              NULL,
    time           time                  NULL,
    CONSTRAINT pk_blog_posts PRIMARY KEY (id)
    );