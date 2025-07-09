package 종합.과제.종합과제3;

import java.util.Scanner;

public class 종합과제3 {
    public static void main(String[] args) {

        WaitingController controller = new WaitingController();

        for( ; ; ) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            System.out.println("선택 > ");

            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

            if (choose == 1) {

                System.out.println("전화번호 : ");  String phone = scan.next();
                System.out.println("인원수 : ");   int count = scan.nextInt();

                boolean result = controller.addWaiting( phone ,count );     // addWaiting() 메소드 호출 , 메소드 실행(입력받은 두 인수값 전달) 후 반환값 result에 저장
                if( result ){                                        // 결과 true 면 아래 출력
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else {                                                     // 결과 false 면 아래 출력
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }
            }

            if( choose == 2){
                System.out.println("============= 대기 현황 =============");
                Waiting3[] waitings  = controller.getWaitingList();
                for( int i = 0 ; i<= waitings.length -1 ; i++){
                    Waiting3 waiting = waitings[i];
                    if( waiting != null ){
                        System.out.println(i+1 +"."+ "연락처: " + waiting.phone+ "- 인원:" +waiting.count+ "명");
                        System.out.println("------------------------------------");
                    }
                }
            }
        }
































    }

}
