package ttoekttak.controller;

public class QuiryController {

    // 싱글톤 생성
    private QuiryController(){}
    private static final QuiryController instance = new QuiryController();
    public static QuiryController getInstance(){return instance;}


} // class e
