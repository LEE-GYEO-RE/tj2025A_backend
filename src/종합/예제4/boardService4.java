package 종합.예제4;

import java.util.Scanner;

// boardService4 : 입출력 담당
public class boardService4 { // class s
    public static void main(String[] args) { // main s
        // 메모리 설계 : content 와 writer 멤버변수를 갖는 객체가 필요.
        // -> Board 클래스 선언

        // board 클래스 객체 100개 저장할 수 있는 배열을 Controller 선언
        // 나중에 데이터베이스 활용할 것임(외부 저장소).
        // DB ------- JAVA(Controller) --------HTML

        for( ; ; ){

            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.println("선택 > ");

            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

            if( choose == 1 ){
                System.out.println("내용 :");
                System.out.println("작성자 : ");
                System.out.println("[안내] 글쓰기 성공");
            } else if (choose == 2) {
                System.out.println("============= 게시물 목록 =============");
                System.out.println("작성자 : ");
                System.out.println("내용 : ");
                System.out.println("------------------------------------");
            }

        } // for e

    } // main e
} // class e
