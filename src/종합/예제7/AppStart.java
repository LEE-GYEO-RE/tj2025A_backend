package 종합.예제7;

import 종합.예제7.view.BoardView;

// (역할) 프로그램 시작 클래스
public class AppStart {
    public static void main(String[] args) {

        // [ BoardView index() 호출하는 방법 ]

        // 1. 메소드가 static 이면  -> 클래스명.static메소드명();

        // 2. 메소드가 static 아니면
        // ->
        // BoardView view = new BoardView();
        // view.index();

        // 3. 해당 클래스가 싱글톤 이면
        BoardView.getInstance().index();
            // 유재석.밥먹기().공부하기();
            // 유재석은 밥먹고 밥먹은 유재석이 공부하기.
        // vs BoardView 싱글톤 = BoardView.getInstance(); 싱글톤.index(); // 이거랑 같긴함
    } // main e
} // class e
