package 종합.예제3;

import java.util.Scanner;

public class BoardService3 { // class s
    public static void main(String[] args) { // main s

        // 메인 화면 구성
        // 입력받은 값에 따른 출력 화면
        // 메모리 설계
        // 각 기능별 코드 구현

        // boardService_변수활용 : 게시물 3개 --> 변수 6개 , 게시물 100개 --> 변수 200개
        // boardService_배열활용 : 게시물100개 --> 변수 2개
        // boardService_객체활용 : 게시물100개 --> 변수 2개 (객체화) -> 변수 1개
            //  두번째 boardService : writer , content 각각 배열 선언
            // --> 단점 : 속성이 다양해지면 배열이 많아짐.
        //  ** 다양한 속성을 하나의 클래스로 설계. content  , writer 를 하나의 객체로 만듬
        //  ** 설계한 클래스/타입으로 배열 선언
        Board[] boards = new Board[100]; // 변수 1개 , 배열 1개 , 객체 100개 저장공간.
            // ----> boards 라는 변수에 Board 객체 100개를 저장 가능한 배열자료 1개 저장
        for( ; ; ) {
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.println("선택 > ");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

                if (choose == 1) {
                    System.out.println("내용 : ");    String content = scan.next();
                    System.out.println("작성자 : ");   String writer = scan.next();              // 입력받은 값 저장
                    Board board = new Board();                                                  // 객체 생성 , 입력받은 값 멤버변수 대입
                    board.content = content;
                    board.writer = writer;
                    boolean check = false;
                    for( int index = 0 ; index <= boards.length -1 ; index++){                // 입력받은 값들을 객체화
                        if( boards[index] == null ){
                            boards[index] = board;
                            check = true;
                            break;
                        } // if2 end
                    } // for2 end
                    if(check) {
                        System.out.println("[안내] 글쓰기 성공!");
                    }else {
                        System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                    }
                }
                else  if (choose == 2) {
                    System.out.println("============= 게시물 목록 =============");
                    for( int index = 0; index <= boards.length -1 ; index++){
                        Board board = boards[index];
                        if( board != null ){
                            System.out.println("작성자 : " + board.writer);
                            System.out.println("내용 : " + board.content);
                            System.out.println("------------------------------------");
                        } // if end
                    } // for end
                } // if end
            } // for end

    } // main e
} // class e
