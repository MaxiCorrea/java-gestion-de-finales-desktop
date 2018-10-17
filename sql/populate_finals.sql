use finals;

insert into Subject(idSubject,description,year) values(1,'Taller de Computación I',1);
insert into Subject(idSubject,description,year) values(2,'Algorítmos',1);
insert into Subject(idSubject,description,year) values(3,'Estructura de Datos',1);
insert into Subject(idSubject,description,year) values(4,'Taller de Computación II',2);
insert into Subject(idSubject,description,year) values(5,'Técnicas de Almacenamiento de Datos',2);
insert into Subject(idSubject,description,year) values(6,'Taller de Computación III',2);
insert into Subject(idSubject,description,year) values(7,'Integración y Programación',2);
insert into Subject(idSubject,description,year) values(8,'Taller de Computación IV',3);
insert into Subject(idSubject,description,year) values(9,'Diseño de Sistemas',3);
insert into Subject(idSubject,description,year) values(10,'Taller de Computación V',3);
insert into Subject(idSubject,description,year) values(11,'Calidad de Software',3);
insert into Subject(idSubject,description,year) values(12,'Taller de Computación VI',3);

insert into Student(dniStudent,name,surname,email) values(36160099,'Federio', 'Crivelli', 'fcrivelli@gmail.com' );
insert into Student(dniStudent,name,surname,email) values(34160199, 'Gaston', 'Aguirre', 'did@gmail.com' );
insert into Student(dniStudent,name,surname,email) values(35160299, 'Rodrigo', 'Alonso', 'didadd@hotmail.com');
insert into Student(dniStudent,name,surname,email) values(32160399, 'Juan Ignacio','Dinneno', 'did@hotmail.com');
insert into Student(dniStudent,name,surname,email) values(34160499, 'Bruno', 'Casanova', 'd@hotmail.com');

insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(1,1,36160099,8, '2016-12-14');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(2,2,34160199,7, '2016-12-14');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(3,3,34160199,10,'2016-12-14');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(4,4,32160399,4, '2016-12-14');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(5,5,35160299,2, '2016-12-15');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(6,6,35160299,9, '2016-12-15');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(7,7,32160399,8, '2016-12-15');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(8,8,34160499,5, '2016-12-16');
insert into Final(idFinal, subjectIdSubject, studentDniStudent, qualification, dateFinal) values(9,9,34160199,9, '2016-12-16');


