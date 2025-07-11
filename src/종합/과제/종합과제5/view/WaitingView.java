package 종합.과제.종합과제5.view;

import 종합.과제.종합과제5.controller.WaitingController;
import 종합.과제.종합과제5.model.dto.WaitingDto;

import java.util.Scanner;

public class WaitingView {

    // 싱글톤 세팅
    private WaitingView(){}
    private static final WaitingView view = new WaitingView();
    public static WaitingView getInstance(){
        return view;
    }

    // 싱글톤 가져오기
    private WaitingController con = WaitingController.getInstance();

    // 멤버변수로 Scanner 선언
    private Scanner scan = new Scanner(System.in);

    // 메인 화면 출력
    public void index() {
        for (; ; ) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 >");
            int choose = scan.nextInt();
            if (choose == 1 ){getWaiting();}
            else {WaitingPrint();}
        } // for e
    }// func e

    public void getWaiting() {
            System.out.println("전화번호 :");   String phone = scan.next();
            System.out.println("인원수 : ");   int count = scan.nextInt();
            boolean result = WaitingController.getInstance().getWaiting(phone ,count);
            if( result ) {
                System.out.println("[안내] 대기 등록이 완료되었습니다.");
            }else {
                System.out.println("[경고] 대기 등록에 실패하였습니다.");
            }
    }

    public void WaitingPrint() {
        System.out.println("============= 대기 현황 =============");
        WaitingDto[] result = con.WaitingPrint();
        for (int i = 0; i < result.length; i++) {
            WaitingDto waitingDto = result[i];
            if (waitingDto != null) {
                System.out.printf("%d 연락처 : %s - 인원 : %d명 \n", i + 1, waitingDto.getPhone(), waitingDto.getCount());
                System.out.println("------------------------------------");

            }// if e
        } // for e
    }// func e
} //class e
