package day17.DB연동예제.view;

import day17.DB연동예제.controller.WaitingController;

public class WaitingView {

    // 싱글톤
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){
        return instance;
    }

    // 싱글톤 가져오기
    private WaitingController waitingController = WaitingController.getInstance();

    // 메인 화면


    // 등록 화면

    // 전체 조회 화면


} // class e
