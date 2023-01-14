DROP TABLE users;

CREATE TABLE users(
id int AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
email VARCHAR(100));

INSERT INTO users VALUES
(1,"田中","tanakatanaka@tanaka.com"),
(2,"山田","yamadayamada@yamada.com");