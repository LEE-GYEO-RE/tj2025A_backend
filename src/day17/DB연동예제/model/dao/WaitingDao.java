package day17.DB연동예제.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class WaitingDao {

    // 싱글톤 생성
    private WaitingDao(){
        openDB();
        // dao 객체가 생성될 때 db연동
    }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }

    // DB 연동 필요한 정보
    private String db_url = "jdbc:mysql://localhost:3306/WaitingList";
    // 데이터베이스 서버 주소
    private String db_user = "root";
    // 데이터베이스 계정명
    private String db_password = "1234";
    // 데이터베이스 비밀번호
    private Connection conn;    // DB연동 결과를 갖는 인터페이스

    // -----------> 이걸 어디 써야함 , dao? view? dao에는 메소드에 클래스에?
    //            String sql = "insert into test(phone) values(010-1231-1231)";
    //            // sql 작성
    //            PreparedStatement ps = conn.prepareStatement(sql);
    //            // 지정한 sql을 연동된 인터페이스에 대입
    //            ps.executeUpdate();
    //            // 기재된 sql 실행 PreparedStatement

    // DB연동 함수
    public void openDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // mysql 드라이버/클래스 로드 함수
            // 연동하는 Driver 클래스 로드/가져오기
            conn = DriverManager.getConnection( db_url, db_user, db_password );
            // DriverManager : DB 연동 클래스(구현체)
            // .getConnection() : DB연동 함수
            System.out.println("데이터베이스 연동 성공");

        }catch (ClassNotFoundException e ){
            System.out.println("드라이버 로드 실패");
        }catch (Exception e ){
            System.out.println("데이터베이스 연동 실패");
        }
    } // func e

    // 등록 함수


    // 전체 조회 함수

} // class e
