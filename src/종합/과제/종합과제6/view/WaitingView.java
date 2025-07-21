package 종합.과제.종합과제6.view;

import 종합.과제.종합과제6.controller.WaitingController;
import 종합.과제.종합과제6.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {

    // 싱글톤 생성
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){
        return instance;
    }

    // controller싱글톤 가져오기
    private WaitingController controller = WaitingController.getInstance();

    // Scanner 객체 생성
    private Scanner scan  = new Scanner(System.in);

    // 프로그램 최초 화면
    public void index() {
        for (; ; ) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1) addWaiting();
            else if (choose == 2 ) getWaitingList();
        } // for e
    } // func e

    // 등록 입출력 구현
    public void addWaiting(){
        System.out.println("전화번호 : ");  String phone = scan.next();
        System.out.println("인원 : ");    int count = scan.nextInt();
        boolean result = controller.addWaiting(phone , count);
        if(result) System.out.println("[안내] 대기 등록 성공 ");
        else System.out.println("[안내] 대기 등록 실패");
    } // func e

    // 전체 조회 입출력 구현
    public void getWaitingList(){
        System.out.println("============= 대기 현황 =============");
        ArrayList<WaitingDto> result = controller.getWaitingList();
        for (int i = 0 ; i < result.size() ; i++){
            WaitingDto waitingDto = result.get(i);
            System.out.println(i+1 + "연락처 : " + waitingDto.getPhone() + "- 인원 : " + waitingDto.getCount() + "명" );
            System.out.println("------------------------------------");
        } // for e
    } // func e

} // class e
