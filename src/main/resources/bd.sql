#create schema bd;
use bd;
CREATE TABLE IF NOT EXISTS users(
    email    VARCHAR(100)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (email)
    );
CREATE TABLE IF NOT EXISTS authorities(
    email     VARCHAR(30) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    PRIMARY KEY (email, authority),
    FOREIGN KEY (email) REFERENCES users (email)
    );

INSERT IGNORE INTO users (email, password, enabled)
VALUES ('adm@rus.ru', '$2y$10$IJbTXn0i1a50obVmg9Y.0u2a.4L4l4CQkIrWtnUmDsPlDptRcWZbm', 1); #login: adm@rus.ru password: Adm
INSERT IGNORE INTO authorities (email, authority)
VALUES ('adm@rus.ru', 'Administrator');

INSERT IGNORE INTO users (email, password, enabled)
VALUES ('user@rus.ru', '$2y$10$bfIDXw2KD6I0ZPxaBmjqgOM87I5Y03xklYY2LmYXCaXBOJGEBYPya', 1); #login: user@rus.ru password: Usr
INSERT IGNORE INTO authorities (email, authority)
VALUES ('user@rus.ru', 'User');