package 종합.과제.종합과제2;

import java.util.Scanner;

public class 종합과제2 { // class s
    public static void main(String[] args) { // main s

        // 메인 화면 출력
        // 입력에 따른 출력 화면
        // 메모리 설계
        // 각 기능 별 구현
        Waiting2[] waitings = new Waiting2[100];                                      // 배열 100개 만들었음 선언
        for( ; ; ) {                                                                // 무한루프  for문

            System.out.println("=========== 맛집 대기 시스템 ===========");            // 메인 화면 출력
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.println("선택 > ");

            Scanner scan = new Scanner(System.in);                                  // 입력받기
            int choose = scan.nextInt();                                            // 입력받은 값 변수명에 저장

            if( choose == 1 ){                                                      // 1 선택시
                System.out.println("전화번호 : ");    String number = scan.next();   // 전화번호 입력받기
                System.out.println("인원수 : ");       int count = scan.nextInt();   // 인원수 입력받기
                Waiting2 waiting = new Waiting2();                                    // waiting 객체 선언
                waiting.number = number;                                            // waiting 객체의 number 속성명에 입력받은 number 값 저장
                waiting.count = count;                                              // waiting 객체의 count 속성명에 입력받은 count 값 저장
                boolean check = false;                                              // false : 기본 상태 설정
                for( int index = 0 ; index <= waitings.length -1 ; index++){        // waitings의 마지막 index 까지 조회
                    if( waitings[index] == null ){                                  // waitings의 인덱스번째까지 null 이면
                        waitings[index] = waiting;                                  // waiting 객체 대입
                        check = true;                                               // true로 상태변환
                        break;                                                      // 반복문 종료  -> if(check)문 ㄱㄱ
                    }
                }
                if(check) {                                                         // check 면 아래 출력
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else {                                                             // 100번째 index까지 다 차있으면 아래 출력
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }
            } else if (choose == 2 ) {                                              // 2 선택시
                System.out.println("============= 대기 현황 =============");
                for( int index = 0 ; index <= waitings.length -1 ; index++){        // waitings 마지막 index번째까지 조회
                    Waiting2 waiting = waitings[index];                              // waiting 객체에 index번째 대입
                    if( waiting != null){                                           // waiting 객체가 null 아니면 아래 출력
                        System.out.println("연락처 : " + waiting.number + " - 인원 : "+ waiting.count);
                        System.out.println("------------------------------------");
                    }
                }
            }
        } // 무한루프 for end
    } // main e
} // class e
