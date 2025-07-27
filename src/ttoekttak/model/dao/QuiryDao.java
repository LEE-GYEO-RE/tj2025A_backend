package ttoekttak.model.dao;

import ttoekttak.model.dto.QuiryDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class QuiryDao {

    // 싱글톤 생성
    private QuiryDao(){
        openDB();   // dao 생성 시 바로 DB 연동
    }
    private static final QuiryDao instance = new QuiryDao();
    public static QuiryDao getInstance(){return instance;}

    // DB 연동에 필요한 정보
    private String db_url = "jdbc:mysql://localhost:3306/ttoekttak";
    private String db_user = "root";
    private String db_pw = "1234";
    private Connection conn;    // DB 연동 결과를 저장하기 위한 인터페이스

    // DB 연동 함수
    public void openDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url , db_user ,db_pw );
        }catch (ClassNotFoundException e ){
            System.out.println("MYSQL 드라이버 로드 실패");
        }catch (Exception e ){
            System.out.println("DB 연동 실패");
        } // catch e
    } // func e

    // 물품 문의 메소드
    public boolean productsQuiry(QuiryDto quiryDto) {
        // controller 에서 요청하는 문의글 정보와 같이 매개변수 설정
        try {
            String sql = "INSERT INTO p_quiry(pno, qtext, qid, qpwd, q_date) VALUES (?, ?, ?, ?, NOW())";
            // DB에서 p_quiry 테이블에 추가할 값들 설정
            PreparedStatement ps = conn.prepareStatement(sql);
            // 기재할 sql문 선언
            ps.setInt(1, quiryDto.getPno());        // 첫번째 물음표에 문의글 정보dto의 물품번호 저장
            ps.setString(2, quiryDto.getQtext());   // 두번째 물음표에 문의글 정보dto의 문의글내용 저장
            ps.setString(3, quiryDto.getQid());     // 세번째 물음표에 문의글 정보dto의 문의자아이디 저장
            ps.setString(4, quiryDto.getQpwd());    // 네번째 물음표에 문의글 정보dto의 문의자비번 저장

            int row = ps.executeUpdate();                       // sql문 int 타입으로 저장
            return row == 1;                                    // 문의 등록할 레코드 1개면 true 반환
        } catch (Exception e) {
            System.out.println("[DB 문의 등록 오류] " + e.getMessage());
            // 오류 시 오류 메시지 출력
            return false;                                       // 문의 등록할 레코드 1개 아니면 false.
        }
    } // func e

} // class e
