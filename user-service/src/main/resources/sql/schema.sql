CREATE TABLE IF NOT EXISTS USUARIO(
    id serial primary key,
    email varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL
);