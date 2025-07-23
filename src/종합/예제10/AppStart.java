package 종합.예제10;

import 종합.예제10.controller.BoardController;
import 종합.예제10.view.BoardView;

public class AppStart {
    public static void main(String[] args) {

        // view 없을 때 dao , controller 기능 확인 테스트
        boolean result = BoardController.getInstance().boardWrite("테스트내용" , "ㅎㅇㅎㅇ");
        System.out.println(result);

        // 메인 화면 호출
        BoardView.getInstance().index();

    } // main e
} // class e
