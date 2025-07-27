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
        // view 에서 입력받는 QuiryDto 타입 값들 그대로 매개변수로 설정
        return quiryDao.productsQuiry(quiryDto);
        // dao에게 메소드 요청 -> 반환 값 다시 반환 (실제 view로 갈 실제 값)
    }
} // class e
