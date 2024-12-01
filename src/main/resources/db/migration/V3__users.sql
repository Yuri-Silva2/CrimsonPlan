CREATE TABLE users(
    id SERIAL UNIQUE PRIMARY KEY UNIQUE NOT NULL,
    username VARCHAR(25) UNIQUE NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    type VARCHAR(5) NOT NULL,
    biography TEXT,
    created TIMESTAMP NOT NULL
);