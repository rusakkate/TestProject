create table if not exists users
(
    id_user               serial
    constraint user_pk
    primary key,
    surname               varchar(40)  default 'surname'::character varying                        not null,
    user_name             varchar(20)  default 'name'::character varying                           not null,
    patronymic            varchar(40)  default 'patronymic'::character varying                     not null,
    email                 varchar(50)                                                              not null
    );

alter table users
    owner to postgres;

create unique index if not exists user_id_user_uindex
    on users (id_user);

create index if not exists users_user_name_surname_index
    on users (user_name, surname);

create table if not exists roles
(
    id_role           serial
    constraint roles_pk
    primary key,
    role_name         varchar(50)                               not null
    );

alter table roles
    owner to postgres;

create unique index if not exists roles_id_role_uindex
    on roles (id_role);

create table if not exists user_role
(
    id_user_role bigserial
    constraint user_role_pk
    primary key,
    id_user      bigint not null
    constraint user_role_users_id_user_fk
    references users
    on update cascade on delete cascade,
    id_role      bigint not null
    constraint user_role_roles_id_role_fk
    references roles
    on update cascade on delete cascade
);

alter table user_role
    owner to postgres;

create unique index if not exists user_role_id_user_role_uindex
    on user_role (id_user_role);

create index if not exists user_role_user_id_role_id_index
    on user_role (id_user, id_role);
