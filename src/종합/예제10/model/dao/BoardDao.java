package 종합.예제10.model.dao;

import 종합.예제10.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardDao {

    // 싱글톤
    private BoardDao(){ connect(); }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }

    // DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/exam10";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    // DB 연동 함수
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url , db_user , db_password );
        }catch (Exception e){System.out.println(e);}
    }

    // (1) 등록 기능 구현
    public boolean boardWrite(BoardDto boardDto){
        // boolean           : 해당 메소드 실행 결과를 true(저장성공) , false(저장실패) 반환 하기 위한 타입
        // BoardDto boardDto : controller 로부터 저장할 값들을 dto로 구성해서 받는 매개변수
        try {
            // 1. SQL 작성
            String sql = "insert into board( bcontent , bwriter ) values( ? , ? )";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , 현재 ? 2개
            ps.setString( 1 , boardDto.getBcontent());      // SQl내 1번 ? 에 매개변수로 받은 boardDto의 bcontent 값 대입
            ps.setString( 2 , boardDto.getBwriter());       // SQl내 2번 ? 에 매개변수로 받은 boardDto의 bwriter 값 대입
            // 4. SQL 실행    , insert/update/delete  는 .executeUpdate();
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count >= 1) return true;    // 1개 이상 insert 했으면 저장성공
            return false;   // 1개 이상 insert 못했으면 저장실패
        }catch (Exception e ){ System.out.println(e); } // catch e
        return false;   // 예외 처리 되면 실패
    } // func e

} // class e
