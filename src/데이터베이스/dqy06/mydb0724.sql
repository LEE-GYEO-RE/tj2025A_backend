# 1. 데이터베이스 생성 
drop database if exists mydb0724;   -- 만약에 'mydb0724' 데이터베이스 존재하면 삭제
create database mydb0724;         -- 'mydb0724' 데이터베이스 생성 
use mydb0724;                  -- 'mydb0724' 데이터베이스 사용 , 워크벤치 재실행후에도
# 2. 테이블 생성 
create table table1(               -- 'table1' 테이블 생성 
   num_pk int ,                  -- 'num_pk' 속성/컬럼/필드 을 int 타입 선언 
    constraint primary key( num_pk )   -- 선언된 'num_pk' 속성을 pk(식별키) 설정 
); # PRIMARY KEY : 식별키 , 중복 불가능 , NULL 불가능 , 고유한 값 , 게시물번호/회원번호/학번/제품번호 등등

# 2. 테이블 생성 
create table table2(
   no_pk int , 
    constraint primary key( no_pk ) ,
    num_fk int ,                      -- 'num_fk' 속성 을 int 타입 선언 
    -- 선언된 'num_fk'' 속성을 fk(참조키) 설정 'table1' 테이블의 'num_pk' 를 참조 
    constraint foreign key( num_fk ) references table1( num_pk ) 
    on update cascade    -- 만약에 table1 의 'num_pk' 값이 수정되면 'num_fk' 값도 같이 수정 
    on delete cascade   -- 만약에 table1 의 'num_pk' 값이 삭제되면 'num_fk' 값도 같이 삭제 
      /* 참조 옵션 : constraint foreign key( fk필드 ) references 테이블명 ( pk필드 ) 옵션 
         on [update / delete] [cascade / set null / restrict ]
         1. on delete cascade : 참조중인 pk 레코드가 삭제되면 같이 fk 레코드 도 같이 삭제한다. 
            2. on update cascade : 참조중인 pk 레코드의 pk값이 변경되면 fk 값도 같이 변경된다.
            3. on delete set null : 참조중인 pk 레코드가 삭제되면 fk 값은 null로 변경한다.
            4. on update set null : 참조중인 pk 레코드의 pk값이 변경되면 fk 값은 null로 변경한다.
            5. on delete restrict : (기본값/생략) pk가 참조중인 pk레코드는 삭제 불가능 설정 한다.
            6. on update restrict : (기본값/생략) pk가 참조중인 pk레코드는 수정 불가능 설정 한다.
            * 단 restrict 에서 pk값를 참조하는 fk값이 존재하지 않으면 삭제/수정 가능 
        */
); # FOREIGN KEY : 참조키 , 중복 가능 , NULL 가능 , 참조값 , 댓글이위치한게시물번호/게시물작성자번호/수강신청학생번호/주문한제품번호
# 실생활 : 우리집의 집주소 pk , 쿠팡/G마켓/카카오쇼핑 에서 우리집주소 FK 등록
# 집주소는 *하나*만 존재하고 각 쇼핑몰은 집주소를 참조한다. 

# 왜 ? PK 와 FK 참조(관계)형 테이블 = 관계형 데이터베이스 
# 3. 서로 다른 테이블 합치기 = JOIN , # PK레코드와 FK레코드를 하나의 테이블로 조회  
# 샘플 데이터 
insert into table1 values( 1 ) , (2) , (3) , (4) , (5);
insert into table2 values( 1 , 1 ) , ( 2 , 2 ) , ( 3 , 1 ) , (4 , 1 ) , (5, 2);
# 레코드 조회 
select * from table1;
select * from table2;
# (1) 두개 이상의 테이블 조회하기 : select * from 테이블명A, 테이블명B;
# 주의할점 : 두 테이블간의 데카르트 곱 으로 표현 된다. 테이블명A(5개) 테이블B(5개) , 5*5->25 
select * from table1 , table2;
# (2) 교집합 : 두 테이블간의 공통된 값(PK-FK) 기준으로 레코드 조회 
# 2-1) where 절 , 일반적으로 join과 조건절 구분이 어렵기 때문에 실무 사용불가능.
select * from table1 , table2 where table1.num_pk = table2.num_fk;
# 2-2) inner join on 절 , 테이블A inner join 테이블B on 테이블A.PK속성명 = 테이블B.FK속성명 
select * from table1 inner join table2 on table1.num_pk = table2.num_fk;


