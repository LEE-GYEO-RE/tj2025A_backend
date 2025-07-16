/*
[문제 1] 아래 조건에 맞는 members 테이블을 생성하는 SQL을 작성하세요.
테이블명: members
컬럼 정보:
member_id (회원 아이디): 문자열(20), 기본 키(Primary Key), NULL 허용 안함
member_name (회원 이름): 문자열(50), NULL 허용 안함
email (이메일): 문자열(100), 고유 키(Unique), NULL 허용 안함
join_date (가입일): 날짜/시간, **기본값(Default)**은 현재 날짜/시간
points (포인트): 정수, **기본값(Default)**은 0

[문제 2] members 테이블에 아래 정보를 가진 새로운 회원을 추가하는 SQL을 작성하세요.
member_id: 'user01'
member_name: '김철수'
email: 'chulsoo@example.com'
points: 1000

[문제 3]members 테이블에서 모든 회원의 member_id와 email을 조회하는 SQL을 작성하세요.
[문제 4]members 테이블에서 member_id가 'user01'인 회원의 points를 1500으로 업데이트하는 SQL을 작성하세요.
[문제 5]members 테이블에서 member_id가 'user01'인 회원을 삭제하는 SQL을 작성하세요.

[문제 6] 아래 조건에 맞는 products 테이블을 생성하는 SQL을 작성하세요.
테이블명: products
컬럼 정보:
product_code (상품 코드): 정수, 기본 키(Primary Key), 1씩 자동 증가
product_name (상품명): 문자열(100), NULL 허용 안함
price (가격): 정수, unsigned, NULL 허용 안함
stock_quantity (재고 수량): 정수, NULL 허용 안함, **기본값(Default)**은 0
category (카테고리): 문자열(50)

[문제 7] products 테이블에 아래 정보를 가진 새로운 상품을 추가하는 SQL을 작성하세요.
product_name: '프리미엄 키보드'
price: 120000
stock_quantity: 50
category: '컴퓨터 주변기기'
[문제 8] products 테이블에서 category가 '컴퓨터 주변기기'인 상품의 product_name과 price를 조회하는 SQL을 작성하세요.
[문제 9] products 테이블에서 product_name이 '프리미엄 키보드'인 상품의 stock_quantity를 45로 업데이트하는 SQL을 작성하세요.
[문제 10] products 테이블에서 product_name이 '프리미엄 키보드'인 상품을 삭제하는 SQL을 작성하세요.

*/


drop database if exists 실습2;	# members 이름의 데이터베이스 있으면 삭제
create database 실습2;			# members 이름의 데이터베이스 생성
show databases;						# DB서버 내 모든 데이터베이스 목록 보기
use 실습2;						# members 데이터베이스 활성화

# 문제 1
create table members(
member_id varchar(20) not null ,		# 문자열 20 , 공백 x
member_name varchar(50) not null ,		# 문자열 50 , 공백 x
email varchar(100) not null unique ,	# 문자열 100 , 공백 x 고유키라 중복 x
join_date datetime default now() ,		# 날짜/시간 , 현재 날짜,시간으로 기본값 설정
points int default 0 ,					# 정수 , 기본값 0 설정
constraint primary key(member_id)		# 회원 아이디를 기본 키로 설정
);
select * from members;					# 테이블 명(members) 조회

# 문제 2
insert into members ( member_id , member_name , email , points ) value( "user01" , "김철수" , "culsoo@example.com" , 1000 );
# insert into 테이블명 (속성명) value (속성값) : 레코드에 추가/저장 

# 문제 3 
select member_id , email from members;
# select 속성명 from 테이블명 : 테이블 내 속성명들 조회 

# 문제 4
set SQL_SAFE_UPDATES = 0;	# safe mode 끄기 , 1은 다시켜기 / update 하려면 꺼야됨.
update members set points = 1500 where member_id = "user01";	
# update 테이블명 set 속성명 = 속성값 where 속성명 = 속성값 : where 조건절 / 조건 맞으면 앞의 선언값으로 수정,업데이트
select * from members;

# 문제 5
delete from members where member_id = "user01";
# where 조건절 / 조건 맞는 것 삭제.
select * from members;

# 문제 6
create table products(
product_code int auto_increment , 		# 정수 , 자동번호 부여 
product_name varchar(100) not null ,	# 문자열 100 , 공백 x
price int unsigned not null , 			# 정수 , unsigned(음수 허용 x) , 공백 x
stock_quantity int not null default 0 , # 정수 , 공백 x , 기본값 0
category varchar(50) ,					# 문자열 50
constraint primary key(product_code)	# 상품코드를 기본 키로 설정
);
select * from products;					# products 테이블 조회

# 문제 7
insert into products ( product_name , price , stock_quantity , category ) value( "프리미엄 키보드" , 120000 , 50 , "컴퓨터 주변기기" );
# 속성명에 속성값 추가
select * from products;					# 속성명  , 속성값 추가된 products 테이블 조회

# 문제 8 
select product_name , price from products where category = "컴퓨터 주변기기";
# products 에서 category 가 컴퓨터 주변기기인 제품명 , 가격 조회

# 문제 9 
set SQL_SAFE_UPDATES = 0;	# 수정하기 위해 자체 모드 해제 0 ,다시 쓰려면 1
update products set stock_quantity = 45 where product_name = "프리미엄 키보드"; 	# 조건 수정 / 제품명이 프리미엄 키보드이면 , 수량 45로 수정
select * from products;		# 수정한 값 확인차 조회

# 문제 10 [문제 10] products 테이블에서 product_name이 '프리미엄 키보드'인 상품을 삭제하는 SQL을 작성하세요.
delete from products where product_name = "프리미엄 키보드";		# 조건 삭제 / 제품명이 프리미엄 키보드 인 레코드 삭제
select * from products;		# 확인차 조회


































