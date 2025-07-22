package 종합.예제9;

import 종합.예제9.controller.BoardController;
import 종합.예제9.model.dto.BoardDto;
import 종합.예제9.view.BoardView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {
        // 1. 프로젝트와 패키지 세팅 <라이브러리 세팅>
        // 2. 우선 작업에 필요한 MVC 패턴 클래스 선언
        // 3. dto를 제외한 싱글톤 선언
        // 4. dto는 저장할 속성 (DB일치)과 dto 패턴 , dao(db제외)
        // 5. dto 생성자 , getter setter 생성
        // 6. dao , controller 기능 구현 메소드 생성
        // 7. 기능 테스트

        // view 작업 전에 Controller/DAO test

        // 테스트할 controller 싱글톤 가져오기
        // BoardController bc = BoardController.getInstance();
        // 주석 처리 하면서 단위 기능 테스트
            // 등록 테스트
        // boolean result1 = bc.boardWrite("안녕하세요" , "유재석");
        // System.out.println(result1);
            // 전체 조회 테스트
        // ArrayList<BoardDto> result2 = bc.boardPrint();
        // System.out.println(result2);

        BoardView.getInstance().index();
    } // main e
} // class e
