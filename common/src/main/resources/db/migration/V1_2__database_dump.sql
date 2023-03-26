INSERT INTO users (surname, user_name, patronymic, email)
VALUES ('rusak', 'kate', 'konstantinovna', 'melitrica_red@mail.ru'),
       ('ivanov', 'ivan', 'ivanovich', 'ivanov@mail.ru'),
       ('petrov', 'petr', 'petrovich', 'petrov@mail.ru'),
       ('dzick', 'olgya', 'antonovna', 'dzick@mail.ru'),
       ('kolyada', 'fiona', 'antonovna', 'kolyada@mail.ru');

INSERT INTO roles (role_name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_SALEUSER'),
       ('ROLE_CUSTOMERUSER'),
       ('ROLE_SECUREAPIUSER');

INSERT INTO user_role (id_user, id_role)
VALUES ('1', '1'),
       ('2', '2'),
       ('3', '2'),
       ('4', '3'),
       ('5', '4');