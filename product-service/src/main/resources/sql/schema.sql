CREATE TABLE IF NOT EXISTS PRODUCT(
    id serial primary key,
    name varchar(255) NOT NULL,
    image varchar(255) NOT NULL,
    price NUMERIC NOT NULL
);