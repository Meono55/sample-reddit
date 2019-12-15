DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS subreddit;

CREATE TABLE users (
    id INT IDENTITY PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,

);

INSERT INTO users (username, password) VALUES ('test', 'pass');

CREATE TABLE subreddit(
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(250)
);

INSERT INTO subreddit (name) VALUES ('PHASEONE');