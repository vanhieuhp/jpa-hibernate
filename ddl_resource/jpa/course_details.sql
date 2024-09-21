create table jpa.course_details
(
    id          varchar(255) not null
        primary key,
    description text         null,
    constraint fk_course
        foreign key (id) references jpa.courses (id)
);

