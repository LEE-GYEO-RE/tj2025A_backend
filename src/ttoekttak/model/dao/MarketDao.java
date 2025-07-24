package ttoekttak.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class MarketDao {

    // 싱글톤 생성
    private MarketDao(){
        openDB(); // dao 생성시 바로 DB 연동
    }
    private static final MarketDao instance = new MarketDao();
    public static MarketDao getInstance(){return instance;}

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

} // class e
