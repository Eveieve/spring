create database blog;
CREATE TABLE article (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255),
                         content TEXT
);

INSERT INTO article (title, content) values ('title 1', 'content 1')
INSERT INTO article (title, content) VALUES ('title2', 'content2')
INSERT INTO article (title, content) VALUES ('title3', 'content3')

