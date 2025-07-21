package 종합.과제.종합과제6.controller;

import 종합.과제.종합과제6.model.dao.WaitingDao;
import 종합.과제.종합과제6.model.dto.WaitingDto;
import 종합.과제.종합과제6.view.WaitingView;

import java.util.ArrayList;

public class WaitingController {
    // 싱글톤 생성
    private WaitingController(){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){
        return instance;
    }

    // dao 싱글톤 가져오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 등록 기능 구현
    public boolean addWaiting(String phone , int count ){
        boolean result = false;
        // result 값 false 로 초기 설정
        result = waitingDao.addWaiting(phone , count);
        // phone , count 입력받은 값 dao 등록 기능 함수로 전달하기 위해 저장
        return result;
        // 그리고 반환
    } // func e

    // 전체 조회 기능 구현
    public ArrayList <WaitingDto> getWaitingList(){
        return waitingDao.getWaitingList();
        // dao 에게 모든 게시물 반환받아서 다시 반환하는 것
    }

}
