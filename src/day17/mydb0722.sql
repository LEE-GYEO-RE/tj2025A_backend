drop database if exists mydb0722;
create database mydb0722;
use mydb0722;

create table waiting(
	wno int auto_increment not null ,
    phone varchar(30) not null ,
    count int not null,
    constraint primary key ( wno )
);

select * from waiting;
insert into waiting ( phone , count ) values ('123' , 4 );