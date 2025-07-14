package 종합.예제8.view;

import 종합.예제8.controller.BoardController;
import 종합.예제8.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {

    // 싱글톤 생성
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    // controller 싱글톤 가져오기
    private BoardController controller = BoardController.getInstance();

    // 모든 메소드에서 사용가능한  Scanner 생성
    private Scanner scan = new Scanner(System.in);


    // * 프로그램 최초 화면 (화면 연동)
    public void index( ){
        for( ; ;){
            System.out.println("============= My Community =============");
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){ addBoard(); }
            else if( choose == 2 ){ getBoardList(); }
        } // for e
    } // func e


    // 등록 입출력 구현
    public void addBoard(){
        System.out.print("내용 : ");  String content = scan.next();
        System.out.print("작성자 : ");String writer = scan.next();
        // 입력받기

        boolean result = controller.addBoard( content , writer );
        // controller 에게 입력받은 값 인수로 전달후 결과받기

        if( result == true ){  System.out.println("[안내] 글쓰기 성공 ");  }
        else{  System.out.println("[경고] 글쓰기 실패");  }
        // 결과에 따른 출력문
    } // func e

    // 전체조회 입출력 구현
    public void getBoardList( ){
        System.out.println("============= 게시물 목록 =============");

        ArrayList<BoardDto> result = controller.getBoardList();
        // controller 의 전체조회메소드인 결과를 받아오는 것
        // 배열이 아닌 ArrayList 타입의 result 변수로 저장

        // 2. 받은 결과물들을 반복문 출력.
        for( int i = 0 ; i < result.size() ; i++ ){
            // ArrayList<> 썼으니깐 .length 아니고 , size() 씀
            // 배열이었으면 , null , 비어있지 않으면으로 if문 써야되지만
            // ArrayList<>는 가변길이라 객체 저장 안되어있으면 자동으로 빈칸이 없는 것으로 만들어줌.

            BoardDto board = result.get(i);
            // 여기도 [i] 아니고 .get(i) 씀
            // BoardDto 클래스타입의 board 변수에 i번째 객체 저장

            System.out.println( "작성자 : " + board.getWriter() );
            // board 변수의 getWriter 메소드 가져와서 출력
            System.out.println( "내용 : " + board.getContent() );
            System.out.println("------------------------------------");
        } // for e
    } // func e

} // class e
