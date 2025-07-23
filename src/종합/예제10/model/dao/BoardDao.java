package 종합.예제10.model.dao;

import 종합.예제10.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

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

    // (2) 전체 조회 기능 구현 : 표(테이블)을 객체로 가져와서 리스트에 넣고 호출 하는 작업
    // public vs private 차이 : 다른 패키지에서 접근 여부
    // ArrayList<BoardDto> : 하나의 레코드(BoardDto) 여러개 있는 배열 ArrayList
    // bcontent/bwriter = BoardDto타입
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> list = new ArrayList<>();
        // DB 연동되는 시점부터는 전체 조회 기능에서만 필요함
        // try문 밖에 쓴 이유는 return 값으로 넘기려고
        try {
            // 1. SQL 작성
            String sql = "select * from board";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행 , select = executeQuery();
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
                // 1) select 조회 결과를 레코드/행/가로단위 하나씩 조회
            while (rs.next() ) {
                // rs.next() : ResultSet 인터페이스가 갖는 (조회)결과테이블에서 다음 레코드 이동 한다는 뜻
                // 2) 조회중인 레코드의 속성값 호출해서 dto 만들기
                int bno = rs.getInt("bno"); // rs.get타입("가져올속성명 or 번호")
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                BoardDto boardDto = new BoardDto( bno , bcontent , bwriter);
                // 3) 생성된 dto를 리스트에 담아주기
                list.add(boardDto);
            } // while e
        }catch (Exception e ){ System.out.println(e); } // catch e
        return list;
    } // func e

    // (3) 삭제 기능 구현
    public boolean boardDelete(int bno){
        // int bno = 매개변수이며 삭제할 게시물의 식별(PK)번호
        // 1. SQL 작성
        // 2. SQL 기재
        // 3. SQL 매개변수 대입
        // 4. SQL 실행
        // 5. SQL 결과에 따른 로직/리턴/확인
        try {
            String sql = "delete from board where bno = ? ";    // SQl 작성
            PreparedStatement ps = conn.prepareStatement(sql);  // SQL 기재
            ps.setInt(1 , bno );                                // SQl내 1번 ? 에 매개변수로 받은 boardDto의 bno 값 대입
            int count = ps.executeUpdate();                     // SQL 실행
            if(count == 1) return true; // sql 결과 1이면 삭제 성공
            // 여기서 왜 1임?
            // insert , update , delete 문법 실행 결과는 처리된 레코드 수 반환
            // 삭제 1개만 할거임
            else {return false;}        // sql 결과 1이 아니면 삭제 실패
        }catch (Exception e){
            System.out.println(e);
        } // catch e
        return false;   // 예외 발생시 삭제 실패
    } // func e

    // (4) 수정 기능 구현
    public boolean boardUpdate( BoardDto boardDto ){
        try {
            String sql = "update board set bcontent = ? where bno = ? ";    // SQl 작성
            PreparedStatement ps = conn.prepareStatement(sql);              // SQL 기재
            ps.setString( 1 , boardDto.getBcontent() );                     // 1 : SQl내 첫번째 자리 물음표 , 매개변수 값 대입
            ps.setInt( 2 , boardDto.getBno() );                             // 2 : SQL내 두번째 자리 물음표 , 매개변수 값 대입
            int count = ps.executeUpdate();                                 // SQL 실행
            if(count == 1) return true;                                     // SQL 결과에 따른 로직/리턴/확인 1개면 수정 성공
            else {return false;}                                            // 아니면 수정 실패
        }catch (Exception e) { System.out.println(e); }
        return false;                                                       // 예외 있으면 수정 실패
    } // func e

} // class e





















