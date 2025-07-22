package 종합.예제9.view;

import 종합.예제9.controller.BoardController;

public class BoardView {

    // 싱글톤 생성
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    // 싱글톤 가져오기
    public BoardController controller = BoardController.getInstance();


}
