package 종합.과제.종합과제5.controller;

import 종합.과제.종합과제5.model.dao.WaitingDao;
import 종합.과제.종합과제5.model.dto.WaitingDto;

public class WaitingController {

    // 싱글톤 생성
    private WaitingController(){}
    private static final WaitingController control = new WaitingController();
    public static WaitingController getInstance(){
        return control;
    }

    // Dao 객체 싱글톤 가져오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 등록 처리 메소드
    // view 에게 전달받은 phone , writer 객체로 구성하여 dao 에게 전달 후 결과를 view에게 전달
    public boolean getWaiting(String phone , int count ){
        boolean result = false;
        // 여기서 result에 false 넣는 이유는?
        // result 에 false로 기본값 설정과 초기화 해주면서 유연성 확보, 컴파일 에러 방지
        // 밑에서 초기 false 값 다시 지정했으니깐 false는 필요없어짐.
        result = waitingDao.getWaiting(phone, count);
        // result 를 waitingDao.getWaiting(phone, count) 이거로 덮어버림.
        return  result;
    }


    // 조회 처리 메소드

    public WaitingDto [ ] WaitingPrint(){
        return waitingDao.WaintingPrint();
    }

}
