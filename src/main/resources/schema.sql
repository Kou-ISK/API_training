DROP TABLE IF EXISTS user;

CREATE TABLE user(
id int NOT NULL AUTO_INCREMENT,
name varchar(255) NOT NULL,
email varchar(255) NOT NULL,
PRIMARY KEY(id));

INSERT INTO user(name, email)
values(
('TANAKA', 'tanaka_TNK@tanaka.jp'),
('YAMADA', 'yamada_YMD@yamada.jp'));