USE work_assistant;

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id          bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name        varchar(20) NOT NULL COMMENT '名称',
    password    varchar(32) NOT NULL COMMENT '密码',
    create_time datetime DEFAULT CURRENT_TIMESTAMP,
    update_time datetime DEFAULT CURRENT_TIMESTAMP,
    UNIQUE uk_name (name)
) COMMENT '账户';

INSERT INTO sys_user (name, password)
VALUES ('foo', 'foo'),
       ('bar', 'bar');

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id          bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name        varchar(20) NOT NULL COMMENT '名称',
    create_time datetime DEFAULT CURRENT_TIMESTAMP,
    update_time datetime DEFAULT CURRENT_TIMESTAMP,
    UNIQUE uk_name (name)
) COMMENT '角色';

INSERT INTO sys_role (name)
VALUES ('boy'),
       ('girl');

DROP TABLE IF EXISTS sys_privilege;
CREATE TABLE sys_privilege
(
    id          bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name        varchar(20) NOT NULL COMMENT '名称',
    create_time datetime DEFAULT CURRENT_TIMESTAMP,
    update_time datetime DEFAULT CURRENT_TIMESTAMP,
    UNIQUE uk_name (name)
) COMMENT '权限';

INSERT INTO sys_privilege (name)
VALUES ('earning'),
       ('costing');

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    id          bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id     bigint UNSIGNED NOT NULL,
    role_id     bigint UNSIGNED NOT NULL,
    create_time datetime DEFAULT CURRENT_TIMESTAMP,
    update_time datetime DEFAULT CURRENT_TIMESTAMP
) COMMENT '关联 sys_user 与 sys_role';

INSERT INTO sys_user_role (user_id, role_id)
VALUES (1, 1),
       (2, 2);

DROP TABLE IF EXISTS sys_role_privilege;
CREATE TABLE sys_role_privilege
(
    id           bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    role_id      bigint UNSIGNED NOT NULL,
    privilege_id bigint UNSIGNED NOT NULL,
    create_time  datetime DEFAULT CURRENT_TIMESTAMP,
    update_time  datetime DEFAULT CURRENT_TIMESTAMP
) COMMENT '关联 sys_role 与 sys_privilege';

INSERT INTO sys_role_privilege (role_id, privilege_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);