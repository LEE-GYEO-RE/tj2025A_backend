drop database if exists WaitingList;
create database WaitingList;
use WaitingList;

create table waiting(
waiting_no int not null,
phone varchar(13) not null ,
count int not null
);
select * from waiting;