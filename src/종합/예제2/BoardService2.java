package 종합.예제2;

import java.util.Scanner;

public class BoardService2 { // class s
    public static void main(String[] args) { // main e

        // 메인 화면 출력 , 입력
        // 입력 선택에 따른 화면 출력
        // 메모리 설계
        // 기능 별 세부 코드 구현

        String[] contents = new String[100];                                   // 총 문자열(String) 100개를 저장할 수 있는 배열 선언
        String[] writers = new String[100];                                     // 총 문자열(String) 100개를 저장할 수 있는 배열 선언

        for( ; ; ) {                                                            // 메인 화면 무한루프
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.println("선택 > ");
            Scanner scan = new Scanner(System.in);                              // 입력받기
            int choose = scan.nextInt();

            boolean check = false;                                               // false : 저장실패 , true : 저장성공

            if( choose == 1 ){                                                   // 1 입력시 아래 출력
                System.out.println("내용 : ");    String content = scan.next();
                System.out.println("작성자 : ");   String writer = scan.next();
                for( int index = 0 ; index <= contents.length -1 ; index++){
                    String cont = contents[index];
                    if( cont == null ){
                        contents[index] = content;
                        writers[index] = writer;
                        check = true; break;
                    }
                }
                if(check) {
                    System.out.println("[안내] 글쓰기 성공!");
                }else{
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }
            } else if (choose == 2 ) {                                          // 2 입력시 아래 출력
                System.out.println("============= 게시물 목록 =============");
                for( int index = 0 ; index <= contents.length -1 ; index++){
                    String cont = contents[index];
                    if( cont != null ){
                        System.out.println("작성자 : " + writers[index]);
                        System.out.println("내용 : " + contents[index]);
                        System.out.println("------------------------------------");
                    }
                }
            }
        } // for e


    } // main e
} // class e
