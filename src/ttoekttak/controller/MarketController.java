package ttoekttak.controller;

import ttoekttak.model.dao.MarketDao;
import ttoekttak.model.dto.MarketDto;
import ttoekttak.model.dto.ProductDetailDto;
import ttoekttak.model.dto.QuiryDto;

import java.util.ArrayList;

public class MarketController {

    // 싱글톤 생성
    private MarketController(){}
    private static final MarketController instance = new MarketController();
    public static MarketController getInstance(){return instance;}

    // 싱글톤 가져오기
    public MarketDao marketDao = MarketDao.getInstance();

    // 물품 등록
    public boolean addProduct(String pname, String ptext, int pprice, String sellId, String sellpwd) {  // view에서 입력받은 값을 매개변수로 설정
        String pstate = "판매중";                                   // 초기 판매 상태(판매중) 설정
        String add_date = java.time.LocalDate.now().toString();    // 등록일자는 오늘 날짜로 설정
        MarketDto dto = new MarketDto(  // view에서 받은 값으로 새로운 dto 객체 생성
                0,          // DB의 pno에서 자동 번호 증가라 , 0값으로 기본 설정
                pname,      // 물품명
                ptext,      // 물품설명
                pprice,     // 물품가격
                sellId,     // 판매자아이디
                sellpwd,    // 판매자 비번
                pstate,     // 판매여부 : "판매중"
                add_date);  // 등록일자
        return marketDao.addProduct(dto);
        // dao에게 등록요청 -> 성공 여부 결과 반환 (다시 view로 갈 실제 값)
    } // func e

    // 물품 조회
    public ArrayList<MarketDto> productsPrint() {
        return marketDao.productsPrint();
        // dao에게 조회요청 -> 성공여부 list 값으로 결과 반환 (다시 view로 갈 실제 값)
    }

    // 물품 수정
    public boolean productsUpdate(int pno, String sellpwd, String pname, String ptext, int pprice, String pstate) {
        // view에서 입력받은 값들 매개변수로 설정
        return marketDao.productsUpdate(pno, sellpwd, pname, ptext, pprice, pstate);
        // dao에게 수정메소드 요청 -> 성공여부 결과 반환 (다시 view로 갈 실제 값)
    }

    // 물품 삭제
    public boolean productsDelete(int pno, String sellpwd) {
        // view에서 입력받은 값들 매개변수로 설정
        return marketDao.productsDelete(pno, sellpwd);
        // dao에게 삭제 메소드 요청 -> 성공여부 결과 반환 (다시 view로 갈 실제 값)
    }

    // 상세 조회
    public ProductDetailDto detailPrint(int pno) {
        // view 에서 조회할 물품번호 입력받은 값 매개변수로 설정
        return marketDao.detailPrint(pno);
        // dao에게 상세조회 메소드 요청 -> 받은 값 반환(다시 view로 갈 실제 값)
    }

    // 랭킹 조회
    public ArrayList<MarketDto> rankPrint() {
        // view에서 조회할 상위 10개 물품정보 조회 값 메소드 타입으로 설정
        return marketDao.rankPrint();
        // dao 에게 랭킹 조회 메소드 요청 -> 받은 값 반환(다시 view로 갈 실제 값)
    }

    // 검색 조회
    public ArrayList<ProductDetailDto> searchPrint(String search) {
        // view 에서 입력받은 search 값 매개변수로 설정
        return marketDao.searchPrint(search);
        // doa에게 메소드 요청 -> 받은 값 반환(다시 view로 갈 실제 값)
    }


} // class e
