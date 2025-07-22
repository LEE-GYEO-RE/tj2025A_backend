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
                    1) JDBC MYSQL 라이브러리 다운로드 : https://dev.mysql.com/downloads/connector/j/
                    2) Select Operating System: : [Platform Independent] 선택
                    3) Platform Independent (Architecture Independent), ZIP Archive	9.3.0	5.1M	[ Download ] 클릭
                    4) 압축풀기 --> 압축 푼 폴더내 --> 'mysql-connector-j-9.3.0.jar'
                    5) 프로젝트내 .jar 넣어주고 오른쪽클릭 --> 가장 하단 [라이브러리 추가]

                2. 연동코드

                3. 핵심 JDBC 인터페이스
                    * 인터페이스를 사용하는이유 : 각기 다른 데이터베이스 회사들의 클래스(구현체)를 조작하기 위해 (다형성)
                    1) Connection : 데이터베이스 연동
                            (1) DB서버와 연동 함수
                                Connection conn = DriverManager.getConnection("서버주소","계정","비밀번호");
                            (2) 연동된 DB에 SQL 기재 함수 , 기재된 PreparedStatement 타입 반환
                                PreparedStatement ps = conn.prepareStatement( SQL문법 );

                    2) PreparedStatement : SQL 실행 조작
                            (1) 기재된 SQL 실행 함수
                                ResultSet rs = ps.executeQuery();   SELECT 문법 실행 결과를 ResultSet 타입 반환
                                int count = ps.executeUpdate();     INSERT , UPDATE , DELETE 문법 실행 결과 int 타입 반환

                    3) ResultSet : SQL 실행 결과 조작
                            (1) SQL 결과 조작 함수
                                rs.next();                          조회된 레코드들 중에서 다음 레코드 이동 함수
                                rs.getXXX( 속성명 );                 현재 레코드에서 지정한 속성명의 값 반환 함수
                                    XXX : 적절한 자바 타입 , getInt( ) , getString( ) , getDouble( ) 등등
        */
        // [1] 자바 와 데이터베이스 연동
        // 1) mysql 회사 지원하는 연동 Driver 클래스 로드/가져오기 *DB회사별로 다르다. * 예외처리
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[JDBC MYSQL 드라이버 가져오기 성공]");
            // 2) DB 연동후 연동결과를 갖는 인터페이스 , Connection , import java.sql
            // .prepareStatement( SQL ) : 연동된 DB에 SQL 기재준비 , PreparedStatement 타입 반환
            // 3) DB 연동 클래스(구현체) : DriverManager
            // 4) DB 연동 함수 : .getConnection( 서버주소 , 계정명 , 비밀번호 ); * 예외처리
            // - 데이터베이스 서버 주소 : jdbc:mysql://ip주소:port번호/데이터베이스명
            String db_url = "jdbc:mysql://localhost:3306/mydb0722"; // 데이터베이스 서버 주소
            String db_user = "root";                                // 데이터베이스 계정명
            String db_password = "1234";                            // 데이터베이스 비밀번호
            Connection conn = DriverManager.getConnection( db_url , db_user , db_password );
            System.out.println("[데이터베이스 연동 성공]");
            // 자바에서 DML 문법 사용해보기 ------------------------------- //
            String sql = "insert into test(content) values('안녕하세요')"; // 5) SQL 작성
            PreparedStatement ps = conn.prepareStatement( sql ); // 6) 지정한 SQL를 연동된 인터페이스에 대입, .prepareStatement( sql )
            ps.executeUpdate(); // 7) 기재된 SQL 실행 , PreparedStatement

        }catch ( ClassNotFoundException e ){
            System.out.println("[JDBC MYSQL 드라이버 가져오기 실패]");
        }catch ( SQLException e ){
            System.out.println("[데이터베이스 연동 실패]");
        }

    } // main end
} // class end

