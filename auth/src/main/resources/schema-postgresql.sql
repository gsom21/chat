drop table if exists authorities;
drop table if exists users;

create table if not exists users
(
    id       serial primary key,
    username varchar(250) not null unique,
    password varchar(250) not null,
    enabled  boolean      not null
);


create table if not exists authorities
(
    username  varchar(250) not null,
    authority varchar(250) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index if not exists ix_auth_username on authorities (username, authority);