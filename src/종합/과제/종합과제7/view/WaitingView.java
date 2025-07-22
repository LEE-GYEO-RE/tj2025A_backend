package 종합.과제.종합과제7.view;


import 종합.과제.종합과제7.controller.WaitingController;
import 종합.과제.종합과제7.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {

    // 싱글톤 생성
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){
        return instance;
    }

    // 싱글톤 가져오기
    public WaitingController controller = WaitingController.getInstance();

    // 입력객체
    private Scanner scan = new Scanner(System.in);

    // 메인 뷰
    public void index(){
        for( ; ; ){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if(choose == 1 ){addWaiting();}
            else if(choose == 2){waitingPrint();}
        } // for e
    } // func e

    // 등록 뷰
    public void addWaiting(){
        System.out.println("전화번호 : ");  String phone = scan.next();
        System.out.println("인원 : ");    String count = scan.next();
        boolean result = controller.addWaiting(phone , count);
        if(result){
            System.out.println("대기 등록 성공");
        }else {
            System.out.println("대기 등록 실패");
        }
    } // func e

    // 전체 조회 뷰
    public void waitingPrint(){
        ArrayList<WaitingDto> result = controller.waitingPrint();
        for( WaitingDto dto : result ){
            System.out.println("전화번호 : " + dto.getPhone());
            System.out.println("인원 : " + dto.getCount());
            System.out.println("------------------------");
        }
    } // func e

} // class e















