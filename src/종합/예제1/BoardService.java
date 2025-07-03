package 종합.예제1;

import java.util.Scanner;

public class BoardService { // class s
    public static void main(String[] args) { // main s

        // 1. 반복적인 메인(화면) 출력 , 입력
        // 2. 입력 선택에 따른 화면 설계
        // 3. 기능별 필요한 메모리 설계
        // 4. 각 기능별 세부 코드 구현

        // 메모리 설계 : 게시물 1개당 변수 2개 , 총게시물 3개 = 변수 6개
        String content1 = null ;  String content2 = null ; String content3 = null ;
        String writer1 = null ; String writer2 = null ; String writer3 = null ;

        for( ; ; ){                                                                 // 무한 루프 시작
            System.out.println("============= My Community =============");         // 메인화면 출력
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");

            Scanner scan = new Scanner( System.in );                                // 입력
            int choose = scan.nextInt();

            if( choose == 1 ){                                                      // 입력에 따른 화면 제어
                System.out.println("내용 : ");    String content = scan.next();       // 입력 받고 저장
                System.out.println("작성자 : ");   String writer = scan.next();        // 입력 받고 저장
                if( content1 == null ){                                             // content1 비어있는지 확인
                    writer1 = writer;   content1 = content;                         // 입력받은 값 대입
                    System.out.println("[글쓰기] 성공 ");                            // 출력
                }else if( content2 == null ){
                    writer2 = writer;   content2 = content;
                    System.out.println("[글쓰기] 성공 ");
                }else if (content3 == null ) {
                    writer3 = writer;   content3 = content;
                    System.out.println("[글쓰기] 성공 ");
                }else {
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }

            } // if e

            else if( choose == 2 ){                                             // 입력에 따른 화면 제어

                System.out.println("============= 게시물 목록 =============");
                if (content1 != null) {                                         // content1이 비어있지 않으면,
                    System.out.println("작성자 : " + writer1);
                    System.out.println("내용 : " + content1);
                    System.out.println("------------------------------------");
                }
                if (content2 != null){
                    System.out.println("작성자 : " + writer2);
                    System.out.println("내용 : " + content2);
                    System.out.println("------------------------------------");
                }
                if(content3 != null){
                    System.out.println("작성자 : " + writer3);
                    System.out.println("내용 : " + content3);
                    System.out.println("------------------------------------");
                }



            } // else if e



        } // for e
    } // main e
} // class e
