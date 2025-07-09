package 종합.과제.종합과제3;

public class WaitingController {

    // 멤버 변수
    Waiting3[] waitings = new Waiting3[100];  // watings 객체 100개 저장할 수 있는 배열


    boolean addWaiting(String phone, int count){ // 대기 등록 기능 메소드 정의

        Waiting3 wate = new Waiting3( ); //  Waiting 객체 생성
        wate.phone = phone;
        wate.count = count;
        for (int i = 0 ; i <= waitings.length -1 ; i++){ // waitings 객체 null 찾기
            if( waitings[i] == null){
                waitings[i] = wate;                     // 찾았으면 wate 객체 waitings의 i번째에 넣기
                return true;                            // 성공시 true
            }
        }
        return false;                                   // 실패시 false
    }



    Waiting3[] getWaitingList(){                // 대기 현황 출력 메소드
        return waitings;                        // waitings 객체 반환
    }
}
