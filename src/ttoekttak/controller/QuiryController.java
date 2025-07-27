package ttoekttak.controller;

import ttoekttak.model.dao.QuiryDao;
import ttoekttak.model.dto.QuiryDto;

public class QuiryController {

    // 싱글톤 생성
    private QuiryController(){}
    private static final QuiryController instance = new QuiryController();
    public static QuiryController getInstance(){return instance;}

    // 싱글톤 가져오기
    public QuiryDao quiryDao = QuiryDao.getInstance();

    // 물품 문의
    public boolean productsQuiry(QuiryDto quiryDto) {
        return quiryDao.productsQuiry(quiryDto);
    }
} // class e
