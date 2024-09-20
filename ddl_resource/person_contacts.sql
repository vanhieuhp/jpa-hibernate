create table jpa.person_contacts
(
    person_id    varchar(255) not null
        primary key,
    email        varchar(255) null,
    phone_number varchar(20)  null,
    constraint person_contacts_ibfk_1
        foreign key (person_id) references jpa.persons (id)
);

