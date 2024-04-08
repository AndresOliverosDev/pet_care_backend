CREATE DATABASE IF NOT EXISTS guarderia_mascotas;
USE guarderia_mascotas;

CREATE TABLE razas (
    id int(10) NOT NULL AUTO_INCREMENT,
    nombre varchar(60),
    PRIMARY KEY (id)
);

CREATE TABLE dueños (
    cc varchar(15) NOT NULL,
    nombres varchar(40) NOT NULL,
    apellidos varchar(40) NOT NULL,
    direccion varchar(100) NOT NULL,
    telefono varchar(10) NOT NULL,
    PRIMARY KEY (cc)
);
CREATE TABLE mascotas (
    id bigint(19) NOT NULL AUTO_INCREMENT,
    nombre varchar(60) NOT NULL,
    edad tinyint(3) NOT NULL,
    color varchar(30) NOT NULL,
    genero varchar(30) NOT NULL,
    especie varchar(20) NOT NULL,
    dueñoscc varchar(15) NOT NULL,
    razasid int(10) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_mascotas_dueños FOREIGN KEY (dueñoscc) REFERENCES dueños (cc),
    CONSTRAINT FK_mascotas_razas FOREIGN KEY (razasid) REFERENCES razas (id)
);