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
    public boolean addProduct(String pname, String ptext, int pprice, String sellId, String sellpwd) {
        String pstate = "판매중";
        String add_date = java.time.LocalDate.now().toString();
        MarketDto dto = new MarketDto(0, pname, ptext, pprice, sellId, sellpwd, pstate, add_date);
        return marketDao.addProduct(dto);
    } // func e

    // 물품 조회
    public ArrayList<MarketDto> productsPrint() {
        return marketDao.productsPrint();
    }

    // 물품 수정
    public boolean productsUpdate(int pno, String sellpwd, String pname, String ptext, int pprice, String pstate) {
        return marketDao.productsUpdate(pno, sellpwd, pname, ptext, pprice, pstate);
    }

    // 물품 삭제
    public boolean productsDelete(int pno, String sellpwd) {
        return marketDao.productsDelete(pno, sellpwd);
    }

    // 상세 조회
    public ProductDetailDto detailPrint(int pno) {
        return marketDao.detailPrint(pno);
    }

    // 랭킹 조회
    public ArrayList<MarketDto> rankPrint() {
        return marketDao.rankPrint();
    }

    // 검색 조회
    public ArrayList<ProductDetailDto> searchPrint(String search) {
        return marketDao.searchPrint(search);
    }


} // class e
