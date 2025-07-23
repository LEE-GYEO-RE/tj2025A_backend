package 종합.예제10;

import 종합.예제10.controller.BoardController;
import 종합.예제10.model.dto.BoardDto;
import 종합.예제10.view.BoardView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // view 없을 때 dao , controller 기능 확인 테스트
        boolean result = BoardController.getInstance().boardWrite("테스트내용" , "ㅎㅇㅎㅇ");
        System.out.println(result);

        // 전체 조회 기능 테스트
        ArrayList<BoardDto> result1 = BoardController.getInstance().boardPrint();
        System.out.println(result1);

        // 삭제 기능 테스트 , 삭제 성공하면 true 실패 or 존재하지 않으면 false
        boolean result2 = BoardController.getInstance().boardDelete(2);
        System.out.println(result2);

        // 수정 기능 테스트
        boolean result3 = BoardController.getInstance().boardUpdate(3 , "ㅇㅇㅇㅇ");
        System.out.println(result3);
        // 메인 화면 호출
        BoardView.getInstance().index();


    } // main e
} // class e
