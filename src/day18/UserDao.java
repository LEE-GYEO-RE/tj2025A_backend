package day18;

import java.sql.*;

public class UserDao {

    // (*) 싱글톤 : 주로 프로그램 내 하나(싱글)의 객체(톤) 표현
        // -> 주로 MVC 패턴에서 싱글톤 사용하는 레이어/계층 : view/controller/dao
        // -> DTO(데이터 이동 객체)에서는 싱글톤 사용하지 않는다.
            // 왜? 데이터(회원정보) 1개만 존재하지 않는다. / '멤버변수 위주'
        // controller랑 다른거는 왜쓰니
            // 기능은 하나만 있어도 재사용 가능 / '메소드 위주'

    private UserDao(){ connect(); }
    private static final UserDao instance = new UserDao();
    public static UserDao getInstance(){ return instance; }

    // 관례적인 MVC 패턴에서의 (협업) 용어
    // D : DATA     데이터 ( 데이터베이스/DB )
    // A : ACCESS   접근
    // O : OBJECT   객체

    // (1) 데이터베이스 연동 코드 (함수/메소드)

    private String db_url = "jdbc:mysql://localhost:3306/mydb0723"; // 연동할 DB서버의 주소 = jdbc:mysql://IP번호:PORT번호/DB명
    private String db_user = "root";                                // DB서버의 계정명    = root
    private String db_password = "1234";                            // DB서버의 비밀번호  = 1234
    private Connection conn;                                        // DB연동 결과를 조작하는 인터페이스 , import 주의 , java.sql
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                           // MYSQL 드라이버/클래스 불러오기
            conn = DriverManager.getConnection(db_url , db_user , db_password ); // .getConnection 함수가 static 이라 new ~ 안써도됨.
            System.out.println("DB 서버 연동 성공");
        }catch (ClassNotFoundException e) {
            System.out.println("MYSQL 라이브러리 로드 실패");
        }catch (SQLException e ){
            System.out.println("DB 서버 연동 실패");
        }
    } // func e

    // (2) 연동 성공 이후에 사용할 DML(테이블 조작)하기
    // 1) USER 테이블에 INSERT 해보기
    public boolean userInsert( ){
        try {
            // 1. SQL 작성 - String sql = "SQL문법";
            String sql = " insert into user( uname , uage ) value ('유재석' , '40' ); ";
            // 2. SQL 기재 - PreparedStatement ps = conn.prepareStatement( sql );
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 실행 - int count = ps.executeUpdate();
            int count = ps.executeUpdate(); // 반환값은 SQL 실행 결과 몇개의 INSERT 레코드를 했는지
            // 4. SQL 결과 확인 / 리턴
            System.out.println(count);
            if(count >= 1 ) return true;    // 성공
            else return false;  // 실패
        }catch (Exception e ){ System.out.println(e);}
        return false;   // 실패
    } // func e

    // 2) USER 테이블에 INSERT 해보기2 : 매개변수 사용
    public boolean userInsert2(String uname , int uage ){
        try {
            // 1. SQL 작성하기 , ?:sql에 들어갈 매개변수
            String sql = "insert into user(uname , uage ) values(? , ?)";

            // 2. SQL 기재하기
            PreparedStatement ps = conn.prepareStatement(sql);

            // 3 SQL ?매개변수 대입하기 set : 저장 , get : 호출
            // ps.setXXX( ?번호 , 값) : XXX 타입으로 ?번째 값 대입
            ps.setString( 1, uname );  // SQL 문법 내 첫번째 ?에 uname 변수값을 String 타입으로 대입
            ps.setInt( 2 , uage );  // SQL 문법내 두번째 ?에 uage 변수값을 int 타입으로 대입.

            // 4. SQL 실행하기
            int count = ps.executeUpdate();

            // 5. SQL 결과에 따른 확인/로직/리턴
            if( count >=1 ) return true;    // 결과가 1 이상이면 실행 성공
            return false;                   // 결과가 1 미만 이면 실패

        }catch (Exception e ){ System.out.println(e); }
        return false;   // 예외 발생하면 실패
    } // func e

    // 3) User 테이블에 select 해보기
    public void userSelect(){
        try {
            // 1. SQL 작성
            String sql = "select * from user;";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            // 3. SQL 매개변수 대입 < ? 없으면 생략>

            // 4. SQL 실행 ,
            // insert/update/delete -> 레코드 처리 개수(int) -> executeUpdate();
            // select -> 레코드 조회 테이블(결과) -> executeQuery();

            ResultSet rs = ps.executeQuery();   // ResultSet 조회결과 조작 인터페이스 , import 주의 , java.sql

            // 5. SQL 결과에 따른 로직/리턴/확인
                // rs.next() : 조회결과에서 레코드/행/가로 하나씩 조회/이동 함수
                // rs.getXXX( 가져올속성명 또는 순서번호 ) : 현재 레코드의 속성/열/column 의 값 반환
                // XXX : 가져올속성명 또는 순서번호의 타입
                // 확인용 int 행번호 = 0;
            while ( rs.next() ){ // -- 다음 레코드가 존재하지 않을때 까지 반복
                // (1) 현재 순회/반복 중인 레코드의 열/속성/컬럼 값 반환
                    // System.out.println(++행번호); 확인용
                    // System.out.println(rs.getInt("uno"));
                    // System.out.println(rs.getString("uname"));
                    // System.out.println(rs.getInt("uage"));
                System.out.printf("번호 : %d , 이름 : %s , 나이 : %s \n" ,
                    rs.getInt(1) , rs.getString(2) , rs.getInt(3)
                );
                // (2) 현재 순회/반복 중인 레코드의 열/속성/컬럼 값을 DTO로 구성
                // CSV/데이터베이스 : 테이블 처럼 행과 열로 구성
                // 자바 : 객체지향 구성 , 행 , 열 같은 거 없음
                // 레코드/행 1개 == 객체 1개 , 여러개 행 == 리스트/배열

                // 반복문 돌리는 이유
                // 자바는 객체 지향 구성이라 행과 열 개념이 없음
                // 데이터베이스나 csv랑 연동할 때 테이블형식으로 된 것을 읽고 쓰고 하려면  한 줄/행 단위로 해야함
                // 그래서 반복문 돌려서 한 행씩 순회
            }

        }catch (Exception e) { System.out.println( e ); }

    } // func e

} // class e






























