package day17.DB연동예제.controller;

import day17.DB연동예제.model.dao.WaitingDao;
import day17.DB연동예제.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // 싱글톤 생성
    private WaitingController(){ }
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){
        return instance;
    }

    // 싱글톤 가져오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 등록 기능
    public boolean addWaiting(String phone , int count ){
        WaitingDto waitingDto = new WaitingDto( phone ,count );
        boolean result = waitingDao.addWaiting(waitingDto);
        return result;
    }

    // 전체 조회 기능
    public ArrayList<WaitingDto> waitingPrint(){
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();
        return result;
    }







} // class e
