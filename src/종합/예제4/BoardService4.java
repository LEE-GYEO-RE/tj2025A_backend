package 종합.예제4;

import java.util.Scanner;

// BoardService4 : 입출력 담당
public class BoardService4 { // class start
    public static void main(String[] args) { // main start
        // (5) .
        // 1. content 와 writer 멤버변수를 갖는 객체 필요하므로 Board클래스 선언
        // 2. board클래스 객체를 100개 저장하는 배열을 controller 선언 * 추후 : 데이터베이스(외부저장소) 활용
        // 3. doPost() 와 doGet() 메소드를 호출하기 위한 객체 생성
        BoardController bs = new BoardController();

        for( ; ; ) {// (1) 무한루프 : 프로그램 계속적으로 실행하기 위해서
            System.out.println("============= My Community =============");// (2) 출력
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            Scanner scan = new Scanner( System.in ); // (3) 입력
            int choose = scan.nextInt();
            if( choose == 1 ) { // (4) 입력 에 따른 화면 출력
                System.out.print("내용 : ");
                String content = scan.next();
                System.out.print("작성자 : ");
                String writer = scan.next();
                // (6) * doPost 메소드를 호출해서 등록 처리후 결과를 받는다.
                boolean result = // doPost메소드가 실행후 결과를 result 에 저장.
                        bs.doPost( content , writer ); // 입력받은 두 값을 인수로 전달
                if( result == true ){ // doPost에서 true 반환이면
                    System.out.println("[안내] 글쓰기 성공");
                }else{ // doPost에서 false 반환이면
                    System.out.println("[경고] 글쓰기 실패");
                }

            }else if( choose == 2 ) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = bs.doGet();
                // doGet() 반환된 boards배열 자료를 boards에 대입한다.
                for (int index = 0; index <= boards.length-1 ; index++) {
                    Board board = boards[index];
                    // 하나(객체)  = 여러개(객체)배열[번호]
                    if( board != null ) {
                        System.out.println("작성자 : " + board.writer);
                        System.out.println("내용 : " + board.content);
                        System.out.println("------------------------------------");
                    }
                } // for end
            } // if end
        } // for end
    } // main end
} // class end

// step1: 반복적인 메인(화면) 출력 , 입력
// step2: 입력 선택에 따른 화면 출력
// step3: 기능별 필요한 메모리 설계
// step4: 각 기능별 세부 코드 구현