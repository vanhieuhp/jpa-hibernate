create table jpa.articles
(
    id        varchar(255) not null
        primary key,
    title     varchar(255) not null,
    content   varchar(255) not null,
    author_id varchar(255) null,
    constraint articles_ibfk_1
        foreign key (author_id) references jpa.authors (id)
);

create index author_id
    on jpa.articles (author_id);

