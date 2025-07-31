drop database if exists bank;
create database bank;
use bank;

create table customer(
	uno int auto_increment ,				-- 회원 번호 
    u_id varchar(20) not null unique,		-- 회원 아이디
    u_pwd varchar(100) not null ,			-- 회원 비밀번호
    u_name varchar(20) not null ,			-- 회원 이름
    u_phone varchar(20) not null ,			-- 회원 전화번호
    u_email varchar(100) not null ,			-- 회원 이메일
    u_date date not null,					-- 회원 생년월일
    constraint primary key (uno)			-- 회원 번호 pk로 설정
);

select * from customer;

create table account(
	acno int auto_increment ,				-- 계좌 로그 번호 
    uno int not null ,						-- 회원 번호
    account_no varchar(30) not null unique, -- 계좌 번호
    account_pwd varchar(20) not null,		-- 계좌 비밀번호
    constraint primary key (acno),			-- 계좌 로그 번호 (pk)
    constraint foreign key (uno) references customer(uno) on update cascade on delete cascade
);

select * from account;

create table transaction_log(
	tno int auto_increment ,								-- 입/출금 로그 번호
    acno int not null ,										-- 계좌 로그 번호
    amount int not null default 0 ,							-- 입/출금 금액(초기값 0)
	t_state int default 0,									-- 입/출금 유형( 1 : 출금 , 2 : 입금 , 3 : 이체 )
	t_text varchar(100) not null,							-- 입/출금 사유
    t_date datetime not null default CURRENT_TIMESTAMP, 	-- 입/출금 날짜
    constraint primary key (tno),							-- 입/출금 로그 번호 (pk)
    constraint foreign key (acno) references account(acno) on update cascade on delete cascade
);

select * from transaction_log;

insert into customer ( u_id , u_pwd , u_name , u_phone , u_email , u_date ) values
( 'user001' , 'dlrufp132' , '유재석' , '010-1234-1234' , 'wotjr@test.com' , '1982-08-01' ),
( 'user002', 'qwer1234', '이효리', '010-2345-2345', 'hyori@test.com', '1980-05-10'),
( 'user003', 'zxcv5678', '강호동', '010-3456-3456', 'kanghd@test.com', '1978-03-15'),
('user004', 'pass4321', '김종국', '010-4567-4567', 'kimjk@test.com', '1976-09-08'),
('user005', 'mnbv0987', '박명수', '010-5678-5678', 'parkms@test.com', '1970-04-01'),
( 'user006', 'asdf1111', '정준하', '010-6789-6789', 'jungjh@test.com', '1975-12-22'),
( 'user007', 'uiop2222', '하하', '010-7890-7890', 'haha@test.com', '1979-11-30'),
( 'user008', 'ghjk3333', '송은이', '010-1111-2222', 'songue@test.com', '1983-06-05'),
( 'user009', 'tyui4444', '김숙', '010-2222-3333', 'kimsook@test.com', '1980-02-28'),
( 'user010', 'bnmq5555', '장도연', '010-3333-4444', 'jangdy@test.com', '1985-08-17'),
( 'user011', 'plok6666', '양세형', '010-4444-5555', 'yangsh@test.com', '1989-04-21'),
( 'user012', 'wert7777', '양세찬', '010-5555-6666', 'yangsc@test.com', '1986-10-12'),
( 'user013', 'cvbn8888', '전현무', '010-6666-7777', 'junhm@test.com', '1977-07-29'),
( 'user014', 'rewq9999', '노홍철', '010-7777-8888', 'nohch@test.com', '1979-10-20'),
( 'user015', 'lkjh0000', '조세호', '010-8888-9999', 'joseho@test.com', '1982-01-19'),
( 'user016', 'qazx1478', '김대희', '010-9999-0000', 'kimdh@test.com', '1974-03-05'),
( 'user017', 'wsxc2587', '신봉선', '010-1212-3434', 'shinbs@test.com', '1981-11-03'),
( 'user018', 'edcv3698', '김신영', '010-3434-5656', 'kimsy@test.com', '1983-05-22'),
( 'user019', 'rfvt7531', '이국주', '010-5656-7878', 'leegj@test.com', '1986-08-08'),
( 'user020', 'tgbn8520', '김영철', '010-7878-9090', 'kimyc@test.com', '1974-06-15');

insert into account ( uno , account_no , account_pwd ) values
(1 , '111111-00-111111' , '111' ) ,
(2, '222222-11-222222', '2222'),
(3, '333333-22-333333', '3333'),
(4, '444444-33-444444', '4444'),
(5, '555555-44-555555', '5555'),
(6, '666666-55-666666', '6666'),
(7, '777777-66-777777', '7777'),
(8, '888888-77-888888', '8888'),
(9, '999999-88-999999', '9999'),
(10, '101010-99-101010', '1010'),
(11, '111222-00-111222', '1212'),
(12, '121212-11-121212', '1313'),
(13, '131313-22-131313', '1414'),
(14, '141414-33-141414', '1515'),
(15, '151515-44-151515', '1616'),
(16, '161616-55-161616', '1717'),
(17, '171717-66-171717', '1818'),
(18, '181818-77-181818', '1919'),
(19, '191919-88-191919', '2020'),
(20, '202020-99-202020', '2121');

insert into transaction_log (acno , amount , t_state , t_text , t_date )values
(1 , 20000 , 1 , '용돈으로 써' , '1982-08-01' ) ,
(2, 150000, 1, '월급 입금', '2023-07-02'),
(3, 50000, 2, '마트 결제', '2023-07-03'),
(4, 70000, 1, '용돈', '2023-07-04'),
(5, 30000, 2, '커피값', '2023-07-05'),
(6, 100000, 1, '보너스', '2023-07-06'),
(7, 40000, 2, '식비', '2023-07-07'),
(8, 25000, 1, '친구에게 송금', '2023-07-08'),
(9, 80000, 2, '병원비', '2023-07-09'),
(10, 120000, 1, '월급 입금', '2023-07-10'),
(11, 60000, 2, '주유비', '2023-07-11'),
(12, 45000, 1, '용돈', '2023-07-12'),
(13, 35000, 2, '외식비', '2023-07-13'),
(14, 90000, 1, '보너스', '2023-07-14'),
(15, 20000, 2, '택시비', '2023-07-15'),
(16, 110000, 1, '월급 입금', '2023-07-16'),
(17, 70000, 2, '영화관', '2023-07-17'),
(18, 30000, 1, '용돈', '2023-07-18'),
(19, 50000, 2, '책 구매', '2023-07-19'),
(20, 100000, 1, '보너스', '2023-07-20');

select * from customer;
select * from account;
select * from transaction_log;