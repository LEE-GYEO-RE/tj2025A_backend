package 종합.예제10.view;


import 종합.예제10.controller.BoardController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {

    // 싱글톤
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    // 싱글톤 가져오기
    private BoardController boardController = BoardController.getInstance();

    // Scanner 객체 생성
    private Scanner scan = new Scanner(System.in);

    // 메인 화면
    public void index(){
        for ( ; ; ) {
            try {
                System.out.println("========== 비회원 게시판 ==========");
                System.out.println("1.등록  2. 전체조회 3.삭제 4.수정 선택 > ");
                int choose = scan.nextInt();
                if (choose == 1) { boardWrite();}
                else if (choose == 2) { }
                else if (choose == 3) { }
                else if (choose == 4) { }
                else {System.out.println("[경고] 존재하지 않는 번호 입니다.");}
            }catch (InputMismatchException e ){
                // InputMismatchException : 프로그램 꺼짐 방지?
                System.out.println("[경고] 입력 타입이 일치하지 않습니다. <다시입력>");
                scan = new Scanner(System.in); // * 입력에 따른 입력객체 초기화 : 잘못된 데이터 지우기
            }catch (Exception e ){
                System.out.println("[오류] 관리자에게 문의 <010-3333-3333>");
            } // catch e
        } // for e
    } // func e

    // (1) 등록 화면 구현
    public void boardWrite(){
        // 1. 입력받기
        scan.nextLine();    // 뒤에서 .nextLine() 쓰려면 , 앞에 의미없는 .nextLine() 필요함
        System.out.println("내용 : ");    String bcontent = scan.nextLine();  // nextLine() : 띄어쓰기 가능
        System.out.println("작성자 : ");   String bwriter = scan.next();      // next() : 띄어쓰기 불가능
        // 2. controller 전달하기 -> 3. 전달 후 (결과)리턴 값 저장하기
        boolean result = boardController.boardWrite(bcontent , bwriter);
        // 4. 리턴된 값에 따른 출력하기
        if(result) System.out.println("[안내] 게시물 작성 성공");
        else System.out.println("[안내] 게시물 작성 실패");
    } // func e

}// class e
