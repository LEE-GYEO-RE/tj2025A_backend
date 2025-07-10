package 종합.과제.종합과제4;

import java.util.Scanner;

public class WaitingService { // class s
    public static void main(String[] args) { // main s



        for ( ; ; ){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            System.out.println("선택 > ");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

            if( choose == 1 ){

                System.out.println("전화번호 : "); String phone = scan.next();
                System.out.println("인원 : ");    int count = scan.nextInt();
                boolean result = WaitingController.addWaiting( phone ,count );
                // static 썻으니깐 메소드 호출 할때 , 객체 생성 안해도됨.
                if( result ) {
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else {
                    System.out.println("[경고] 대기 등록이 불가능 하요 돌아가세요");
                }
            }
            else if( choose == 2 ){
                Waiting[] waitings = WaitingController.getWaitingList();
                // WaitingController 클래스의 getWaitingList() 메소드 호출
                // 그 값을 ( 100개까지 저장 가능한  waitings 배열 조회하는)
                //  Waiting[] 의 배열타입을 가진 변수 waitings에 대입

                //-------------->
                // 궁극적으로 초기에 선언한 100개까지 저장 가능한 Waiting[] waitings 이라는 배열을
                // 모두 가져와서 출력 해야함.
                // 기능/제어 하는 클래스에서 초기 선언 -> 대기 현황 조회 메소드에 return 값으로 저장
                // -> 실행하는 클래스에서 써야하니 메소드 호출 -> 반복문 돌려서 저장된 값 모두 출력

                for( int i = 0; i< waitings.length; i++){
                    // waitings 배열을 순회
                    Waiting waiting = waitings[i];
                    // waitings i 번째의 값을
                    // waiting 이라는 Waiting 객체 타입의 변수에 대입
                    if( waiting != null ){
                        System.out.println("============= 대기 현황 =============");
                        System.out.println( i+1 + "." + "연락처: " + waiting.getPhone() + " 인원: " + waiting.getCount() );
                        // i+1                : for문 안에있으니깐 = i번째부터 (0부터) +1 해주면서 누적 출력
                        // waiting.getPhone() : waitings 배열의 인덱스번째 속성값을 getter 메소드로 가져와


                    } // if e
                } // for e
            } // if e
        } // for e
    } // main e
} // class e
