/*1*/
CREATE DATABASE Homework_18_SQL;

CREATE TABLE Homework
(
    id          INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(256) NOT NULL,
    description VARCHAR(512)
);

/*2*/
CREATE TABLE Lesson
(
    id          INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(256) NOT NULL,
    updatedAt   DATE,
    homework_id INT
);

ALTER TABLE Lesson
    ADD FOREIGN KEY (homework_id) REFERENCES Homework (id);

/*3*/
CREATE TABLE Schedule
(
    id        INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(256) NOT NULL,
    updatedAt DATE
);

/*create an intermediate table for many-to-many relationship */
CREATE TABLE Lesson_Schedule
(
    lesson_id   INT,
    schedule_id INT,
    PRIMARY KEY (lesson_id, schedule_id), -- each row in this table has a unique combination of the values of these two columns
    FOREIGN KEY (lesson_id) REFERENCES Lesson (id),
    FOREIGN KEY (schedule_id) REFERENCES Schedule (id)
);

/* Filling the tables*/
INSERT INTO Homework(name, description)
VALUES ('Homework 1', 'Complete math task'),
       ('Homework 2', 'Complete Java I/O task');

INSERT INTO Lesson(name, updatedAt, homework_id)
VALUES ('Math', '2023-10-22', 1),
       ('Java', '2023-10-26', 2);

INSERT INTO Schedule(name, updatedAt)
VALUES ('Schedule for Java Pro group', '2023-10-20');

INSERT INTO Lesson_Schedule(lesson_id, schedule_id)
VALUES (1, 1),
       (2, 1);