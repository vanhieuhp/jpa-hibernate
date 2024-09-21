create table jpa.vehicles
(
    id           varchar(255) not null
        primary key,
    manufacturer varchar(255) null,
    seats        int          null,
    has_sidecar  tinyint(1)   null,
    vehicle_type varchar(31)  not null
);

