create table organization
(
    id              bigint auto_increment,
    name            varchar(255) null,
    description     varchar(255) null,
    code            varchar(255) not null,
    created_date    varchar(255) null,
    constraint organization_pk
        primary key (id),
    constraint organization_pk
        unique (code)
);