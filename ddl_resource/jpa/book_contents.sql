create table jpa.book_contents
(
    id      bigint   not null
        primary key,
    content longtext null,
    book_id bigint   not null,
    constraint book_id
        unique (book_id),
    constraint book_contents_ibfk_1
        foreign key (book_id) references jpa.books (id)
);

