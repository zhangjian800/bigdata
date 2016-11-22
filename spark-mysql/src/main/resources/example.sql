drop database example;
create database example;

create table people(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(40) NOT NULL,
   email VARCHAR(40) NOT NULL,
   PRIMARY KEY ( id )
);


insert into people values (null, 'Alice', 'alice@google.com');
insert into people values (null, 'Brian', 'Brian@google.com');
insert into people values (null, 'Charlie', 'Charlie@cisco.com');
insert into people values (null, 'Doris', 'Doris@google.com');
insert into people values (null, 'Ellen', 'Ellen@google.com');
insert into people values (null, 'Frank', 'Frank@google.com');
insert into people values (null, 'Gerard', 'Gerard@google.com');
insert into people values (null, 'Harold', 'Harold@google.com');


select a.id, name, email, bookname from people a , people_books b where a.id = b.peopleId

create table people_books(
   id INT NOT NULL AUTO_INCREMENT,
   peopleId VARCHAR(40) NOT NULL,
   bookname VARCHAR(40) NOT NULL,
   PRIMARY KEY ( id )
);


insert into people_books values (null, 1, 'Java');
insert into people_books values (null, 1, 'Python');
insert into people_books values (null, 2, 'Andriod');
insert into people_books values (null, 2, 'Ios');
insert into people_books values (null, 2, 'Widows');
insert into people_books values (null, 3, 'math');
insert into people_books values (null, 3, 'History');
insert into people_books values (null, 3, 'English');


create table book(
   bookname VARCHAR(40) NOT NULL,
   bookprice INT NOT NULL,
   PRIMARY KEY ( bookname )
);


insert into book values ('Java', 20);
insert into book values ('Python', 50);
insert into book values ('Andriod', 45);
insert into book values ('Ios', 60);
insert into book values ('Widows', 10);
insert into book values ('math',35);
insert into book values ('English',25);
