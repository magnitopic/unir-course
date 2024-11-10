CREATE DATABASE IF NOT EXISTS cardb;

CREATE TABLE brand
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(255) NOT NULL,
    warranty INTEGER,
    country  VARCHAR(255)
);

CREATE TABLE car
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    brand_id    INTEGER      NOT NULL,
    model       VARCHAR(255) NOT NULL,
    milleage    INTEGER,
    price       DOUBLE,
    year        INTEGER,
    description TEXT,
    colour      VARCHAR(50),
    fuel_type   VARCHAR(50),
    num_doors   INTEGER,
    FOREIGN KEY (brand_id) REFERENCES brand (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(50)  NOT NULL
);
