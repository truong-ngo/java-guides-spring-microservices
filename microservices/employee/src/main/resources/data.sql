create table employee
(
    id              bigint auto_increment,
    first_name      varchar(255) null,
    last_name      varchar(255) null,
    email           varchar(255) not null,
    department_code varchar(255) null,
    constraint employee_pk
        primary key (id),
    constraint employee_pk
        unique (email)
);