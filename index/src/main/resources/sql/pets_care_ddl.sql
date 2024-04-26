CREATE DATABASE IF NOT EXISTS pets_care;

USE pets_care;

CREATE TABLE IF NOT EXISTS races (
    id INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(60),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles (
    id TINYINT AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `permissions` (  
    id TINYINT AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
    /* Spring Boot Security Learn */
    id INTEGER AUTO_INCREMENT,
    username VARCHAR(40) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    is_enable BOOLEAN,
    account_no_expired BOOLEAN,
    account_no_locked BOOLEAN,
    credential_no_expired BOOLEAN,

    `names` VARCHAR(40) NOT NULL,
    surnames VARCHAR(40) NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users_roles (
    user_id INTEGER,
    rol_id TINYINT,
    CONSTRAINT FK_users_roles FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT FK_roles_users FOREIGN KEY (rol_id) REFERENCES roles(id),
    PRIMARY KEY (user_id, rol_id) 
);

CREATE TABLE IF NOT EXISTS roles_permissions (
    rol_id TINYINT,
    permission_id TINYINT,
    CONSTRAINT FK_roles_permissions FOREIGN KEY (rol_id) REFERENCES roles(id),
    CONSTRAINT FK_permissions_roles FOREIGN KEY (permission_id) REFERENCES `permissions`(id),
    PRIMARY KEY (rol_id, permission_id) 
);

CREATE TABLE IF NOT EXISTS pets (
    id bigint(19) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL,
    age TINYINT(3) NOT NULL,
    color VARCHAR(30) NOT NULL,
    gender VARCHAR(30) NOT NULL,
    specie VARCHAR(20) NOT NULL,
    owner_id INTEGER NOT NULL,
    race_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_pets_owner FOREIGN KEY (owner_id) REFERENCES users (id),
    CONSTRAINT FK_pets_race FOREIGN KEY (race_id) REFERENCES races (id)
);