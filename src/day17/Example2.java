package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example2 {
    public static void main(String[] args) {

        /*
            [ JDBC ]  : JAVA DATABASE CONNECT 자바 데이터베이스 연동
                1. 준비
                    1) JDBC MYSQL 라이브러리 다운로드 : https://dev.mysql.com/downloads/file/?id=538917
                    2) Select Operating System : [Platform Independent] 선택
                    3) Platform Independent (Architecture Independent), ZIP Archive 9.3.0 5.1M [ Download ]
                    4) 압축 풀기 --> 압축 푼 폴더내 --> 'mysql-connector-j-9.3.0.jar'
                    5) 프로젝트 내 .jar 넣어주고 오른쪽 클릭 --> [라이브러리 추가]

                2. 연동 코드

                3. 핵심 JDBC 인터페이스
                    * 인터페이스를 사용하는 이유 : mysql , oracle 등 : 각기 다른 데이터베이스 회사들의 클래스(구현체)를 조작하기 위해(다형성)
                    1) Connection : 데이터 베이스 연동
                            (1) DB서버와 연동함수
                            DriverManager.getConnection("서버주소 , 계정 , 비민번호);
                            (2) 연동된 DB에 SQL 함수 , 기재된 preparedStatement 타입 반환
                            conn.preparedStatement ps = conn.prepareStatement( SQL 문법)

                    2) PreperedStatement : SQL 실행 조작
                            (1) 기재된 SQL 실행 함수
                            ResultSet rs = RESULTps.executeQuery();      SELECT 문법 , 실행
                            int count = ps.executeUpdate ();    INSERT , UPDATE , DELETE 문법 실행 결과 int 타입 반환
                    3) ResultSet : SQL 실행 결과 조작
                            (1) SQL 결과 조작 함수
                                rs.next();  : 조회된 레코드들 중에 다음 레코드로 이동하는 함수
                                rs.getxxx(속성명) ;                현재 레코드에서 지정한 속성명의 값 반환 함수
                                    xxx : 적절한 자비 , getInt() , getString() , getDouble() 등등
        */

        // [1] 자바와  데이터베이스 연동
            // 1) mysql 회사 지원하는 연동 Driver 클래스 로드/가져오기 *DB회사별로 다르다.

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC MYSQL 드라이버 가져오기 성공");
            // 2) DB 연동후 연동결과를 갖는 인터페이스
                // .prepardeStart ( SQL )

            // 3) DB 연동 클래스(구현체) : DriverManager
            // 4) DB 연동 함수 : .getConnection( 서버 주소 , 계정명 , 비밀번호 ); * 예외처리
            // - 데이터베이스 서버 주소 : jdbc:mysql://ip조소:port번호/데이터베이스명
            String db_url = "jdbc:mysql://localhost:3306/mydb0722"; // 데이터베이스 서버 주소
            String db_user = "root";                                // 데이터베이스 계정명
            String db_password = "1234";                            // 데이터베이스 비밀번호
            Connection conn = DriverManager.getConnection( db_url , db_user , db_password);
            System.out.println("데이터베이스 연동 성공");

            // 자바에서 insert into  문법 사용해보기------------------------------- //
            String sql = "insert into test(content) values('안녕하세요')";         // SQL 작성
            PreparedStatement ps = conn.prepareStatement( sql );// 지정한 SQL을 연동된 인터페이스에 대입

            ps.execute();// 기재된 SQL 실행 PreparedStatetment


        }catch (ClassNotFoundException e){
            System.out.println("JDBC 드라이버가 없습니다.");
        }catch (SQLException e ){
            System.out.println("데이터베이스 연동 실패");
        }
    } // main e
} // class e


