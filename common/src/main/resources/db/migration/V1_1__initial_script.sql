create table if not exists users
(
    id_user    bigint auto_increment
        primary key,
    surname    char(40) default 'surname'    not null,
    user_name  char(20) default 'name'       not null,
    patronymic char(40) default 'patronymic' not null,
    email      char(50)                      not null,
    constraint user_id_user_uindex
        unique (id_user)
)
    collate = utf8mb3_bin;

create index users_user_name_surname_index
    on users (user_name, surname);

create table if not exists roles
(
    id_role   bigint auto_increment
        primary key,
    role_name char(50) not null,
    constraint roles_id_role_uindex
        unique (id_role)
)
    collate = utf8mb3_bin;

create table user_role
(
    id_user_role bigint auto_increment
        primary key,
    id_user      bigint not null,
    id_role      bigint not null,
    foreign key (id_user) references users (id_user),
    foreign key (id_role) references roles (id_role),
    constraint user_role_id_user_role_uindex
        unique (id_user_role)
)
    collate = utf8mb3_bin;

create index user_role_user_id_role_id_index
    on user_role (id_user, id_role);