package 종합.과제.종합과제5.model.dao;

import 종합.과제.종합과제5.model.dto.WaitingDto;
// WaitingDto import로 가져옴

public class WaitingDao {

    //싱글톤 패턴
    public WaitingDao(){}  // 지정한 클래스에 기본 생상자 private 함

    // 지정한 클래스에 객체(인스턴스) 선언
    private static final WaitingDao dao = new WaitingDao();

    // 지정 클래스에 getInstance 메소드 선언
    public static WaitingDao getInstance(){
        return dao;
    }

    // 멤버변수 // 데이터베이스 쓰면 생략할거임 // 우리는 배열
    private static final WaitingDto[] waitings = new WaitingDto[100];


    // 대기 등록 메소드

    public boolean getWaiting( String phone , int count ){

        WaitingDto waitingDto = new WaitingDto(phone , count ); //
        for( int i = 0 ; i< waitings.length ; i++){
            if( waitings[i] == null){
                waitings[i] = waitingDto;
                return true;
            } // if e
        } // for e
        return false;
    } // func e

    // 대기 현황 조회 메소드
    public WaitingDto [ ] WaintingPrint(){
        return waitings;
    } // func e

} // class e
