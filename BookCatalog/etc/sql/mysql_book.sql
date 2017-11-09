use rueggerllc;
drop table book;
create table book
(
	id			bigint not null primary key auto_increment
	isbn		varchar(40) not null,
	title		varchar(40) not null,
	author		varchar(40) not null
);

insert into book(id, isbn, title, author) values (0, '123443532253', 'Spring In Action', 'Craig Walls');
insert into book(id, isbn, title, author) values (1, '383727992292', 'How to Win Friends', 'Dale Carnegie');
insert into book(id, isbn, title, author) values (2, '929928283221', 'I Will Find You', 'Joe Kenda');
insert into book(id, isbn, title, author) values (3, '662777228833', 'Trains a Coming', 'Johnny Cash');
