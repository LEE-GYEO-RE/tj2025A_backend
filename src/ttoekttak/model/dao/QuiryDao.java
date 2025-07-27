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
        try {
            String sql = "INSERT INTO p_quiry(pno, qtext, qid, qpwd, q_date) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, quiryDto.getPno());
            ps.setString(2, quiryDto.getQtext());
            ps.setString(3, quiryDto.getQid());
            ps.setString(4, quiryDto.getQpwd());

            int row = ps.executeUpdate();
            return row == 1;
        } catch (Exception e) {
            System.out.println("[DB 문의 등록 오류] " + e.getMessage());
            return false;
        }
    } // func e

} // class e
