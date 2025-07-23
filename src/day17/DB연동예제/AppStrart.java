package day17.DB연동예제;

import day17.DB연동예제.controller.WaitingController;
import day17.DB연동예제.model.dao.WaitingDao;
import day17.DB연동예제.model.dto.WaitingDto;

import java.util.ArrayList;

public class AppStrart {
    public static void main(String[] args) {

        // 등록 함수 테스트
        boolean result = WaitingController.getInstance().addWaiting("1" , 1);
        System.out.println(result);

        // 조회 함수 테스트
        ArrayList<WaitingDto> result1 = WaitingController.getInstance().waitingPrint();
        System.out.println(result1);


    } // main e
} // class e
