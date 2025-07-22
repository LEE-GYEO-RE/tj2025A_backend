package 종합.과제.종합과제7.controller;


import 종합.과제.종합과제7.model.dao.WaitingDao;
import 종합.과제.종합과제7.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {

    // 싱글톤 생성
    public WaitingController(){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){
        return instance;
    }

    // 싱글톤 가져오기
    public WaitingDao waitingDao = WaitingDao.getInstance();

    // 등록
    public boolean addWaiting(String phone , String count){
        WaitingDto waitingDto = new WaitingDto(phone , count );     // 매개변수로 dto 객체 생성
        boolean result = waitingDao.addWaiting(waitingDto);         // dao에게 객체 전달해서 결과 받기
        return result;                                              // 결과 받은거 view로 주기 위한 return
    } // func e

    // 전체 조회
    public ArrayList<WaitingDto> waitingPrint(){                    // ArrayList<WaitingDto> 타입의 Dto 정보 요청하기 위한 타입 설정
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();   // dao에게 dto 정보 요청
        return result;                                              // 결과 view에게 리턴
    } // func e

} // class e
