package 종합.예제9.view;

import 종합.예제9.controller.BoardController;
import 종합.예제9.model.dao.BoardDao;
import 종합.예제9.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {

    // 싱글톤 생성
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    // 싱글톤 가져오기 : controller 의 메소드/기능 사용하기 위해서
    public BoardController controller = BoardController.getInstance();

    // 입력객체 : 밖에서 선언하는 이유 : 여러개 메소드에서 사용하기 위해서
    private Scanner scan = new Scanner(System.in);

    // 메인 뷰
    public void index(){
        for( ; ; ){
            System.out.println("================");
            System.out.println(" 1.등록 2.전체조회 ");
            System.out.println("================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if(choose == 1 ){ boardWrite(); }
            else if (choose == 2) { boardPrint(); }
        } // for e
    } // func e

    // 등록 뷰
    public void boardWrite(){
        System.out.println("내용 : ");    String content = scan.next();
        System.out.println("작성자 : ");   String writer = scan.next();
        boolean result = controller.boardWrite(content , writer);
        if(result){System.out.println("[안내] 글 등록 성공");}
        else{ System.out.println("[안내] 글 등록 실패");}
    } // func e

    // 전체 조회 뷰
    public void boardPrint(){
        ArrayList<BoardDto> result = controller.boardPrint();
        for( BoardDto dto : result ){
            System.out.println("작성자 : " + dto.getWriter());
            System.out.println("내용 : " + dto.getContent());
            System.out.println("--------------------------");
        }
    }

}























