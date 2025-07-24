package ttoekttak.controller;

public class MarketController {

    // 싱글톤 생성
    private MarketController(){}
    private static final MarketController instance = new MarketController();
    public static MarketController getInstance(){return instance;}


} // class e
