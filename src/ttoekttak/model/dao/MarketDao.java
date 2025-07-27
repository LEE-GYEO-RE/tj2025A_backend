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
            ps.setString(1, dto.getPname());
            ps.setString(2, dto.getPtext());
            ps.setInt(3, dto.getPprice());
            ps.setString(4, dto.getSellId());
            ps.setString(5, dto.getSellpwd());
            ps.setString(6, dto.getPstate());
            ps.setString(7, dto.getAdd_date());

            int row = ps.executeUpdate();
            return row == 1;
        } catch (Exception e) {
            System.out.println("[DB 오류] " + e);
            return false;
        }
    } // func e

    // 물품 조회 메소드
    public ArrayList<MarketDto> productsPrint() {
        ArrayList<MarketDto> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM products ORDER BY pno asc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MarketDto dto = new MarketDto(
                        rs.getInt("pno"),
                        rs.getString("pname"),
                        rs.getString("ptext"),
                        rs.getInt("pprice"),
                        rs.getString("sellId"),
                        rs.getString("sellpwd"),
                        rs.getString("pstate"),
                        rs.getString("add_date")
                );
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("[DB 조회 오류] " + e.getMessage());
        }
        return list;
    } // func e

    // 물품 수정 메소드
    public boolean productsUpdate(int pno, String sellpwd, String pname, String ptext, int pprice, String pstate) {
        try {
            String sql = "UPDATE products SET pname = ?, ptext = ?, pprice = ?, pstate = ? WHERE pno = ? AND sellpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pname);
            ps.setString(2, ptext);
            ps.setInt(3, pprice);
            ps.setString(4, pstate);
            ps.setInt(5, pno);
            ps.setString(6, sellpwd);

            int row = ps.executeUpdate();
            return row == 1;
        } catch (Exception e) {
            System.out.println("[DB 수정 오류] " + e.getMessage());
            return false;
        }
    } // func e

    // 물품 삭제 메소드
    public boolean productsDelete(int pno, String sellpwd) {
        try {
            String sql = "DELETE FROM products WHERE pno = ? AND sellpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            ps.setString(2, sellpwd);

            int row = ps.executeUpdate();
            return row == 1;
        } catch (Exception e) {
            System.out.println("[DB 삭제 오류] " + e.getMessage());
            return false;
        }
    } // func e

    // 상세 조회 메소드
    public ProductDetailDto detailPrint(int pno) {
        MarketDto product = null;
        List<QuiryDto> qlist = new ArrayList<>();

        try {
            // 1. 물품 정보 조회
            String sql1 = "SELECT * FROM products WHERE pno = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, pno);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                product = new MarketDto(
                        rs1.getInt("pno"),
                        rs1.getString("pname"),
                        rs1.getString("ptext"),
                        rs1.getInt("pprice"),
                        rs1.getString("sellId"),
                        rs1.getString("sellpwd"),
                        rs1.getString("pstate"),
                        rs1.getString("add_date")
                );
            }

            // 2. 문의글 정보 조회
            String sql2 = "SELECT * FROM p_quiry WHERE pno = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, pno);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                QuiryDto dto = new QuiryDto(
                        rs2.getInt("qno"),
                        rs2.getInt("pno"),
                        rs2.getString("qtext"),
                        rs2.getString("qid"),
                        rs2.getString("qpwd"),
                        rs2.getString("q_date")
                );
                qlist.add(dto);
            }

        } catch (Exception e) {
            System.out.println("상세조회 실패: " + e);
        }

        if (product == null) return null;
        return new ProductDetailDto(product, qlist);
    } // func e

    // 랭킹 조회 메소드
    public ArrayList<MarketDto> rankPrint() {
        ArrayList<MarketDto> list = new ArrayList<>();
        try {
            String sql = "SELECT sellId, COUNT(*) AS count " +
                    "FROM products GROUP BY sellId " +
                    "ORDER BY count DESC LIMIT 10";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MarketDto dto = new MarketDto();
                dto.setSellId(rs.getString("sellId"));
                dto.setPcount(rs.getInt("count"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("랭킹 조회 실패: " + e);
        }
        return list;
    } // fuc e

    // 검색 조회 메소드
    public ArrayList<ProductDetailDto> searchPrint(String search) {
        ArrayList<ProductDetailDto> resultList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM products WHERE pname LIKE ? OR ptext LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            String keyword = "%" + search + "%";
            ps.setString(1, keyword);
            ps.setString(2, keyword);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // 1. MarketDto 만들기
                MarketDto marketDto = new MarketDto(
                        rs.getInt("pno"),
                        rs.getString("pname"),
                        rs.getString("ptext"),
                        rs.getInt("pprice"),
                        rs.getString("sellId"),
                        rs.getString("sellpwd"),
                        rs.getString("pstate"),
                        rs.getString("add_date")
                );

                // 2. 문의글 리스트 만들기
                ArrayList<QuiryDto> quiryList = new ArrayList<>();
                String quirySql = "SELECT * FROM p_quiry WHERE pno = ?";
                PreparedStatement qps = conn.prepareStatement(quirySql);
                qps.setInt(1, marketDto.getPno());
                ResultSet qrs = qps.executeQuery();

                while (qrs.next()) {
                    QuiryDto quiryDto = new QuiryDto(
                            qrs.getInt("qno"),
                            qrs.getInt("pno"),
                            qrs.getString("qtext"),
                            qrs.getString("qid"),
                            qrs.getString("qpwd"),
                            qrs.getString("q_date")
                    );
                    quiryList.add(quiryDto);
                }

                // 3. ProductDetailDto로 묶기
                ProductDetailDto detailDto = new ProductDetailDto(marketDto, quiryList);
                resultList.add(detailDto);
            }

        } catch (Exception e) {
            System.out.println("검색 중 오류 발생: " + e);
        }

        return resultList;
    } // func e

} // class e
