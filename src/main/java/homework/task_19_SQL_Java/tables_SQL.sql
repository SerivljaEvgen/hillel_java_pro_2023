CREATE DATABASE Homework_19_SQL;

CREATE TABLE Homework
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    description VARCHAR(512)
);

CREATE TABLE Lesson
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    updatedAt DATE,
    homework_id INT
);

ALTER TABLE lesson
ADD FOREIGN KEY (homework_id) REFERENCES Homework(id);

