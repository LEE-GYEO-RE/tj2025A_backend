package 종합.과제.종합과제8;


import 종합.과제.종합과제8.controller.WaitingController;
import 종합.과제.종합과제8.model.dto.WaitingDto;
import 종합.과제.종합과제8.view.WaitingView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // 등록 기능 테스트
        boolean result = WaitingController.getInstance().addWaiting("010-1234-1234" , 5 );
        System.out.println(result);

        // 전체 조회 기능 테스트
        ArrayList<WaitingDto> result1 = WaitingController.getInstance().waitingPrint();
        System.out.println(result1);

        // 대기 취소 기능 테스트
        boolean result2 = WaitingController.getInstance().waitingDelete( 2 );
        System.out.println(result2);

        // 대기 정보 수정 기능 테스트
        boolean result3 = WaitingController.getInstance().waitingUpdate( 2 , 99 );
        System.out.println(result3);


        // 메인 화면 출력
        WaitingView.getInstance().index();
    } // main e
} // class e
