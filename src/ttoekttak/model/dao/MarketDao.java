package ttoekttak.model.dao;


import ttoekttak.model.dto.MarketDto;
import ttoekttak.model.dto.ProductDetailDto;
import ttoekttak.model.dto.QuiryDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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


    // 물품 등록 메소드
    public boolean addProduct(MarketDto dto) {
        try {
            String sql = "INSERT INTO products (pname, ptext, pprice, sellId, sellpwd, pstate, add_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPname());        // 첫번째 물음포에 물품명 저장
            ps.setString(2, dto.getPtext());        // 두번째 물음표에 물품설명 저장
            ps.setInt(3, dto.getPprice());          // 세번째 물음표에 물품가격 저장
            ps.setString(4, dto.getSellId());       // 네번째 물음표에 판매자아이디 저장
            ps.setString(5, dto.getSellpwd());      // 다섯번째 물음표에 판매자비번 저장
            ps.setString(6, dto.getPstate());       // 여섯번째 물음표에 판매여부 저장
            ps.setString(7, dto.getAdd_date());     // 일곱번째 물음표에 등록일 저장

            int row = ps.executeUpdate();                       // sql 실행문을 변경된 행을 개수(int)로 반환 준비
            return row == 1;                                    // 변경되는 행 개수가 1개면 DB 반영되서 true 반환
        } catch (Exception e) {
            System.out.println("[DB 오류] " + e);
            return false;                                       // DB 연동 오류 시 false 반환
        } // catch e
    } // func e

    // 물품 조회 메소드
    public ArrayList<MarketDto> productsPrint() {
        ArrayList<MarketDto> list = new ArrayList<>();                  // 조회하는 정보들 list에 저장하기 위해 새로운 ArrayLsit 객체 생성
        try {
            String sql = "SELECT * FROM products ORDER BY pno asc";     // 물품번호 오름차순(작은 숫자부터) 순서대로 정렬
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // executeQuery() : select 구문 실행할 때 사용하는 메소드 , 결과로 ResultSet 객체 반환
            // ResultSet : 쿼리 실행 결과 저장되는 객체
            // rs : DB에서 가져온 테이블의 모든 레코드
            // executeUpdate 와의 차이 :
            // 반환 값이 ResultSet(결과 행 "조회" ) vs int("변경"시 영향 받는 레코드 개수)

            while (rs.next()) {
                // .next() : 다음 행이 존재하는 지 확인 , while문으로 여러개 레코드 하나씩 반복처리하면서 이동
                MarketDto dto = new MarketDto(                  // 현재 레코드(행)에서 각각의 컬럼 값 꺼내서 MarketDto에 담기
                        rs.getInt("pno"),           // pno 컬럼 값 int로 꺼냄
                        rs.getString("pname"),      // pname 컬럼 값 String으로 꺼냄
                        rs.getString("ptext"),      // ptext 컬럼 값 String으로 꺼냄
                        rs.getInt("pprice"),        // pprice 컬럼 값 int로 꺼냄
                        rs.getString("sellId"),     // sellId 컬럼 값 String으로 꺼냄
                        rs.getString("sellpwd"),    // sellpwd 컬럼 값 String으로 꺼냄
                        rs.getString("pstate"),     // pstate 컬럼 값 String으로 꺼냄
                        rs.getString("add_date")    // add_date 컬럼 값 String으로 꺼냄
                ); // ----------> 레코드 하나씩 모든 레코드 (행) 조회
                list.add(dto); // DB에서 조회한 모든 레코드 객체들 새로운 list에 추가
            }
        } catch (Exception e) {
            System.out.println("[DB 조회 오류] " + e.getMessage());
            // 오류 발생시 오류 메시지 출력
        } // catch e
        return list;    // 조회된 모든 레코드 객체들 저장된 list 객체 반환
    } // func e

    // 물품 수정 메소드
    public boolean productsUpdate(int pno, String sellpwd, String pname, String ptext, int pprice, String pstate) {
        // controller에서 요청 받은 매개변수들과 일치하게 매개변수 설정
        try {
            String sql = "UPDATE products SET pname = ?, ptext = ?, pprice = ?, pstate = ? WHERE pno = ? AND sellpwd = ?";
            // set = 어떤 값을 수정할지 ? 로 설정
            // where = 어떤 조건에 해당하는 데이터 수정할지 설정
            // sql문으로 DB에서 수행해서 값을 받을 거니깐 , 여기서 pno와 pwd가 같은지 굳이 비교 안해도 되는 것.
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pname);                 // 첫번째 물음표에 물품명 저장
            ps.setString(2, ptext);                 // 두번째 물음표에 물품내용 저장
            ps.setInt(3, pprice);                   // 세번째 물음표에 물품가격 저장
            ps.setString(4, pstate);                // 네번째 물음표에 판매여부 저장
            ps.setInt(5, pno);                      // 다섯번째 물음표에 수정할 물품번호 저장
            ps.setString(6, sellpwd);               // 여섯번째 물음표에 판매자비번 저장

            int row = ps.executeUpdate();                       // 수정 sql 실행 , 수정 레코드 int타입으로 저장
            return row == 1;                                    // 수정 레코드 1개면 true.
        } catch (Exception e) {
            System.out.println("[DB 수정 오류] " + e.getMessage());
            // 오류 발생시 오류 메시지 출력
            return false;                                       // 수정 레코드 1개 아니면 false.
        } // catch e
    } // func e

    // 물품 삭제 메소드
    public boolean productsDelete(int pno, String sellpwd) {
        // controller 에서 요청받는 매개변수와 일치하게 매개변수 설정
        try {
            String sql = "DELETE FROM products WHERE pno = ? AND sellpwd = ?";
            // where pno , sellpwd : pno , sellpwd 에 해당되는 조건 수정하는 것으로 설정
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);                      // 첫번째 물음표에 물품번호 저장
            ps.setString(2, sellpwd);               // 두번째 물음표에 판매자비번 저장

            int row = ps.executeUpdate();                       // sql실행문 int 타입으로 설정
            return row == 1;                                    // 삭제하는 레코드 1개면 true 반환
        } catch (Exception e) {
            System.out.println("[DB 삭제 오류] " + e.getMessage());
            // 오류 발생시 오류 메시지 출력
            return false;                                       // 삭제되는 레코드 1개 아니면 false.
        }
    } // func e

    // 상세 조회 메소드
    public ProductDetailDto detailPrint(int pno) {
        // controller 에서 요청받은 매개변수와 일치하게 매개변수 설정
        // 반환 타입을 하나의 물품에 대한 정보(MarketDto) + 여러개 문의글(QuiryDto) 담은 ProductDetailDto로 설정

        MarketDto product = null;
        // 조회된 물품 정보 저장하기 위한 MarketDto 타입의 product 객체 선언 , 초기값은 null.
        List<QuiryDto> qlist = new ArrayList<>();
        // 해당 물품에 담긴 문의글 저장하기 위한 새로운 qlist 생성

        try {
            // 1. 물품 정보 조회
            String sql1 = "SELECT * FROM products WHERE pno = ?";
            // DB에서 pno 에 해당하는 물품 조회
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, pno);                     // 첫번째 물음표에 물품번호 저장
            ResultSet rs1 = ps1.executeQuery();                 // 해당 물품번호 갖는 레코드 조회
            if (rs1.next()) {                                   // 만약 해당 물품번호 갖는 레코드 있으면
                product = new MarketDto(                        // 물품정보 Dto를 새로운 객체(product)에 저장
                        rs1.getInt("pno"),
                        rs1.getString("pname"),
                        rs1.getString("ptext"),
                        rs1.getInt("pprice"),
                        rs1.getString("sellId"),
                        rs1.getString("sellpwd"),
                        rs1.getString("pstate"),
                        rs1.getString("add_date")
                );
            } // if e

            // 2. 문의글 정보 조회
            String sql2 = "SELECT * FROM p_quiry WHERE pno = ?";
            // p_quiry 테이블에서 pno 해당되는 레코드 조회
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, pno);                         // 첫번째 물음표에 물품번호 저장
            ResultSet rs2 = ps2.executeQuery();                     // 해당 물품번호 갖는 레코드 조회
            while (rs2.next()) {                                    // 문의글 여러개 있을 수 있으니 , while 문으로 해당 물품번호 갖는 레코드 모두 조회
                QuiryDto dto = new QuiryDto(                        // 물품번호 기준으로 조회된 문의글 정보Dto를 새로운 객체(QuiryDto)에 저장
                        rs2.getInt("qno"),
                        rs2.getInt("pno"),
                        rs2.getString("qtext"),
                        rs2.getString("qid"),
                        rs2.getString("qpwd"),
                        rs2.getString("q_date")
                );
                qlist.add(dto);
                // qlist에 하나씩 저장. 조회된 문의글 하나 저장 후 , 다시 while문 위로 가서 또 조회후 있으면 다음 객체로 저장.
            } // while e
        } catch (Exception e) {
            System.out.println("상세조회 실패: " + e);
            // 예외 발생시 실패 출력
        } // catch e

        if (product == null) return null;
        // 만약 조회된 pno에  해당 물품정보가 없으면 null 반환
        return new ProductDetailDto(product, qlist);
        // 존재하면 ProductDetailDto 객체에 첫번째 조회한 product 와 문의글리스트 qlist 두개 묶어서 반환
    } // func e

    // 랭킹 조회 메소드
    public ArrayList<MarketDto> rankPrint() {
        // 랭킹 리스트 출력하기 위한 반환 타입 ArrayList<>
        ArrayList<MarketDto> list = new ArrayList<>();
        // 상위 10개만 저장할 새로운 리스트 객체 생성
        try {
            String sql = "SELECT sellId, COUNT(*) AS count " +
                    "FROM products GROUP BY sellId " +
                    "ORDER BY count DESC LIMIT 10";
            // 판매자 아이디 , 등록수 조회
            // 판매자 아이디를 기준으로 그룹화 해서
            // 상위 10개 내림차순 정렬
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();                       // sql 조회 메소드 실행

            while (rs.next()) {                                     // 레코드 여러개 10개니깐 while문으로 하나씩 조회
                MarketDto dto = new MarketDto();                    // 여러 레코드(실제 10개) 저장할 새로운 객체 생성
                dto.setSellId(rs.getString("sellId"));    // DB에서 가져온 판매자아이디 값 가져와서 dto 컬럼 값으로 저장
                dto.setPcount(rs.getInt("count"));        // DB에서 가져온 등록수 값 가져와서 dto 컬럼 값으로 저장
                list.add(dto);                                      // 저장한 컬럼 값 하나의 컬럼 객체 값으로 리스트에 저장 , 10개까지 저장
            }
        } catch (Exception e) {
            System.out.println("랭킹 조회 실패: " + e);
            // 예외 있으면 조회 실패 출력
        }
        return list;                                                // 10개 저장된 list 반환
    } // fuc e

    // 검색 조회 메소드
    public ArrayList<ProductDetailDto> searchPrint(String search) {
        // controller 에서 요청받은 매개변수 그대로 매개변수로 설정. 반환 타입도 동일시
        ArrayList<ProductDetailDto> resultList = new ArrayList<>();
        // 검색해서 호출 할 정보들 새로 담을 리스트 객체 생성

        try {
            String sql = "SELECT * FROM products WHERE pname LIKE ? OR ptext LIKE ?";
            // 조건에 맞는 products 테이블에서 모든 컬럼 값들 가져올 것
            // 조건은 물품명이나 물품내용이 like ? 에 들어갈 값에 특정 문자열을 포함할 때
            // like ? : 부분 일치 문법
            PreparedStatement ps = conn.prepareStatement(sql);
            String keyword = "%" + search + "%";                    // 입력받은 search 값이 포함된 모든 문장 찾는 변수
            ps.setString(1, keyword);                   // 첫번째 물음표 값에 물품명 검색조건 입히기
            ps.setString(2, keyword);                   // 두번재 물음표 값에 문의내용 검색조건 입히기
            ResultSet rs = ps.executeQuery();                       // 조회 sql 실행 , 검색 결과 받아오기

            while (rs.next()) {                                     // 검색결과 여러개 있을 수 있으니 while로 하나씩(행) 조회
                // 1. MarketDto 객체 생성
                MarketDto marketDto = new MarketDto(                // 새로운 물품정보dto 객체에 생성
                        rs.getInt("pno"),                 // 새 객체 안에 조회한 각 컬럼 값 저장
                        rs.getString("pname"),
                        rs.getString("ptext"),
                        rs.getInt("pprice"),
                        rs.getString("sellId"),
                        rs.getString("sellpwd"),
                        rs.getString("pstate"),
                        rs.getString("add_date")
                );

                // 2. 문의글 리스트 만들기
                ArrayList<QuiryDto> quiryList = new ArrayList<>();          // marketdto 객체 마다 여러개 문의글 저장하기 위한 quiryList 객체 생성
                String quirySql = "SELECT * FROM p_quiry WHERE pno = ?";    // 물품번호 조건에 맞는 p_quiry 테이블 전체 조회
                PreparedStatement qps = conn.prepareStatement(quirySql);
                qps.setInt(1, marketDto.getPno());              // 첫번째 물음표에 조회해서 저장한 물품정보의 물품번호 가져와서 저장
                ResultSet qrs = qps.executeQuery();                         // 물품번호 갖는 문의글 조회

                while (qrs.next()) {                                        // 문의글도 여러개 일 수 있으니 while 문으로 하나씩(행) 조회
                    QuiryDto quiryDto = new QuiryDto(                       // 새로운 문의글dto 생성
                            qrs.getInt("qno"),                    // 새 객체 안에 조회한 각 컬럼 값 저장
                            qrs.getInt("pno"),
                            qrs.getString("qtext"),
                            qrs.getString("qid"),
                            qrs.getString("qpwd"),
                            qrs.getString("q_date")
                    );
                    quiryList.add(quiryDto);                                // 물품번호 참조한 문의글 여러개 저장하는 리스트 객체에 추가
                } // while2 e

                // 3. ProductDetailDto로 묶기
                ProductDetailDto detailDto = new ProductDetailDto(marketDto, quiryList);
                // 검색한 키워드의 물품정보와 그 물품정보의 번호를 참조한 문의글들을 묶어서 하나의 객체로 저장
                resultList.add(detailDto);
                // 객체화 된 물품정보,문의글들을 리스트 객체에 추가
            } // while1 e

        } catch (Exception e) {
            System.out.println("검색 중 오류 발생: " + e);
            // 예외 발생 시 출력
        } // catch e
        return resultList;
        // 물품정보랑 문의글들 저장된 리스트 객체 반환
    } // func e

} // class e
