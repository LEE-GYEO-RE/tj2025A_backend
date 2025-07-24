drop database if exists ttoekttak;
create database ttoekttak;
use ttoekttak;

create table products(
	pno int auto_increment ,
    pname varchar(20) not null,
    ptext longtext not null,
    pprice int not null,
    sellId varchar(20) not null,
    sellpwd varchar(20) not null,
    pstate enum('판매중', '판매완료') default '판매중' ,
    add_date datetime not null default now(),
    constraint primary key( pno )
);
select * from products;

create table p_quiry(
	qno int auto_increment,
    pno int ,
    qtext longtext not null,
    qid varchar(20) not null,
    qpwd varchar(20) not null,
    q_date datetime not null default now(),
	constraint primary key ( qno ),
	constraint foreign key ( pno ) references products(pno)
);
select * from p_quiry;

insert into products (pname , ptext , pprice , sellId , sellpwd , pstate , add_date ) values
('콜라', '맛있어요', 2000, 'user1', '1234', '판매중', '2025-07-01'),
('사이다', '시원하고 상쾌해요', 1800, 'user2', 'abcd', '판매중', '2025-07-02'),
('노트북', '게이밍 노트북 팝니다', 1200000, 'user3', 'qwer', '판매중', '2025-07-03'),
('의자', '편안한 사무용 의자입니다', 45000, 'user4', 'asdf', '판매완료', '2025-07-04'),
('책상', '넓은 책상 팝니다', 70000, 'user1', '1234', '판매중', '2025-07-05'),
('키보드', '기계식 키보드', 30000, 'user2', 'abcd', '판매완료', '2025-07-06'),
('마우스', '무선 마우스 새제품', 15000, 'user3', 'qwer', '판매중', '2025-07-07'),
('헤드폰', '소음 차단 좋아요', 60000, 'user4', 'asdf', '판매중', '2025-07-08'),
('모니터', '27인치 모니터입니다', 130000, 'user1', '1234', '판매중', '2025-07-09'),
('USB', '32GB USB 메모리 팝니다', 8000, 'user2', 'abcd', '판매완료', '2025-07-10');

insert into p_quiry (pno , qid , qtext , qpwd , q_date) values
(1, 'q_user1', '머리카락이 나왔어요', '123123', '2025-06-01'),
(2, 'q_user2', '유통기한이 어떻게 되나요?', 'abc123', '2025-06-02'),
(3, 'q_user3', '배터리는 포함되나요?', 'pw9876', '2025-06-03'),
(4, 'q_user4', '의자 색상은 무슨 색인가요?', 'pass11', '2025-06-04'),
(5, 'q_user1', '책상 배송비 포함인가요?', '321321', '2025-06-05'),
(6, 'q_user5', '방수 되나요?', 'pwd001', '2025-06-06'),
(7, 'q_user6', 'AS 가능할까요?', 'pw2222', '2025-06-07'),
(8, 'q_user2', '헤드폰에 노이즈 캔슬링 있나요?', 'pw3333', '2025-06-08'),
(9, 'q_user3', '모니터에 HDMI 케이블 포함인가요?', 'pw4444', '2025-06-09'),
(10, 'q_user4', 'USB 속도는 얼마나 되나요?', 'pw5555', '2025-06-10');

select * from products;
select * from p_quiry;