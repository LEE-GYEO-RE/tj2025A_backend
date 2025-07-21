package 종합.과제.종합과제6.model.dao;

import 종합.과제.종합과제6.model.dto.WaitingDto;
import 종합.과제.종합과제6.view.WaitingView;

import java.util.ArrayList;

public class WaitingDao {

    // 싱글톤 생성
    private WaitingDao(){}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }

    // 여러개 게시물 저장할 ArrayList < > 생성
    private static ArrayList <WaitingDto> waitingDB = new ArrayList<>();

    // 등록 기능 구현
    public static boolean addWaiting(String phone, int count){
        boolean result = false;
        WaitingDto waitingDto = new WaitingDto(phone , count );
        // dto의 매개변수 값들 객체화 시켜서 저장
        waitingDB.add(waitingDto);
        // ArrayList에 객체 추가
        result = true;
        return result;
        // 성공시 result에 true 반환
    } // func e

    // 전체 대기 현황 조회 기능 구현
    public ArrayList<WaitingDto> getWaitingList(){
        return waitingDB;
        // 메소드 호출 시 저장된 ArrayList  반환
    } // func e

} // class e
