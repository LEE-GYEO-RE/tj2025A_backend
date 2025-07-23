package 종합.과제.종합과제8.view;

import 종합.과제.종합과제8.controller.WaitingController;
import 종합.과제.종합과제8.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingView {

    // 싱글톤 생성
    private WaitingView (){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){return instance;}

    // controller 싱글톤 가져오기
    private WaitingController waitingController = WaitingController.getInstance();

    // Scanner 객체 생성
    private Scanner scan = new Scanner(System.in);

    // 메인 화면 구성
    public void index(){
        for( ; ; ){
            try{
                System.out.println("=========== 대기번호 프로그램 ===========");
                System.out.println("1.대기등록 2.대기현황조회 3.대기취소 4.대기정보수정 ");
                System.out.println("선택 > ");
                int choose = scan.nextInt();
                if(choose == 1 ){ addWaiting(); }
                else if (choose == 2) { waitingPrint(); }
                else if (choose == 3) { waitingDelete(); }
                else if (choose == 4 ) { waitingUpdate(); }
                else {System.out.println("[안내] 존재하지 않는 번호입니다.");}
            }catch (InputMismatchException e){
                System.out.println("[안내] 입력 타입이 일치하지 않습니다.");
                scan = new Scanner(System.in);  // 잘못 선택하면 입력객체 초기화
            }catch (Exception e){
                System.out.println("[오류] 관리자에게 문의하세요");
            } // catch e

        } // for e
    } // func e

    // 등록 화면
    public void addWaiting(){
        System.out.println("전화번호 : "); String phone = scan.next();
        System.out.println("인원수 : ");   int count = scan.nextInt();
        boolean result = waitingController.addWaiting(phone , count);   // controller에 전달 -> 리턴 값 저장
        if(result) System.out.println("[안내] 대기 등록 성공");
        else System.out.println("[안내] 대기 등록 실패");
    } // func e

    // 전체 조회 화면
    public void waitingPrint(){
        ArrayList<WaitingDto> result = waitingController.waitingPrint();
        // controller 에게 함수요철 후 결과값 ArrayList 타입으로 저장
        System.out.println("------------------");
        System.out.println("wno \t 연락처 \t 인원수 \n");
        System.out.println("------------------");
        for( WaitingDto dto : result ){                                 // 향상된 for문 , 저장되어있는 리스트에 속성들 조회
            System.out.printf("%d \t %s \t %d\n",
                    dto.getWno() , dto.getPhone() , dto.getCount() );   // 조회하면서 속성들 가져와서 출력
        } // for e
    } // func e

    // 특정 대기 취소 화면
    public void waitingDelete(){
        System.out.println("취소할 대기번호 : ");  int wno = scan.nextInt();
        boolean result = waitingController.waitingDelete(wno);
        if(result) System.out.println("[안내] 대기취소 성공");
        else { System.out.println("[안내] 대기취소 실패");}
    } // func e

    // 대기 정보 수정 화면
    public void waitingUpdate(){
        System.out.println("수정할 대기번호 : ");  int wno = scan.nextInt();
        System.out.println("수정할 인원 : ");    int count = scan.nextInt();
        boolean result = waitingController.waitingUpdate( wno , count );
        if(result) System.out.println("[안내] 인원 수정 성공");
        else { System.out.println("[안내] 인원 수정 실패");}
    } // func e

} // class e
