DROP TABLE IF EXISTS student;

CREATE TABLE student(
student_id int not null AUTO_INCREMENT,
name varchar(50) NOT NULL,
surname varchar(50) NOT NULL,
PRIMARY KEY(student_id)
);

INSERT INTO student(name, surname) values('John', 'Smith');
INSERT INTO student(name, surname) values('Artur', 'Carter');
INSERT INTO student(name, surname) values('Patrick', 'Simon');

SELECT * from student;