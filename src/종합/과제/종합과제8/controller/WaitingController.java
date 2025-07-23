package 종합.과제.종합과제8.controller;


import 종합.과제.종합과제8.model.dao.WaitingDao;
import 종합.과제.종합과제8.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {

    // 싱글톤 생성
    private WaitingController (){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){return instance;}

    // 싱글톤 가져오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 등록 기능 구현
    public boolean addWaiting(String phone , int count){                // 입력받은 매개변수 phone , count
        WaitingDto waitingDto = new WaitingDto( 0 , phone ,count );     // phone , count만 받는 새로운 객체 생성
        boolean result = waitingDao.addWaiting(waitingDto);             // 새로운 객체 dao에게 전달 후 결과 받기
        return result;                                                  // view 에게 결과 반환
    } // func e

    // 전체 조회 기능 구현
    public ArrayList<WaitingDto> waitingPrint(){
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();       // dao에게 함수 요청 후 ArrayList 타입으로 결과 받기
        return result;                                                  // view 에게 결과 반환
    } // func e

    // 대기 취소 기능 구현
    public boolean waitingDelete(int wno){
        boolean result = waitingDao.waitingDelete(wno);
        return result;
    } // func e

    // 대기 정보 수정 기능 구현
    public boolean waitingUpdate(int wno , int count){                  // 매개변수 wno(수정할 번호) , count(수정할 인원)
        WaitingDto waitingDto = new WaitingDto( wno, null, count );     // 새로운 dto 객체에 count 새로 넣어서 저장
        System.out.println(">> Controller 디버그: wno = " + wno);
        System.out.println(">> Controller 디버그: count = " + count);
        boolean result = waitingDao.waitingUpdate(waitingDto);          // 새로 저장한거 dao로 보내서 결과 받기
        return result;                                                  // view 에게 결과 반환
    } // func e


} // class e
