package 종합.과제.종합과제4;

public class WaitingController {
    private static final Waiting[] waitings = new Waiting[100];
    // private static final :  접근제한자
    // Waiting[] : 배열 타입
    // waitings  : 변수명
    // new Waiting[100] : 100번째 인덱스까지 존재하는
    // ----> 100번째 인덱스까지 있는 waitings 배열을 만든 것.
    // --> 접근제한자 써서 수정불가 , 어디서나 호출 가능


    // 대기 등록 기능 메소드
    public static boolean addWaiting(String phone, int count){
        // addWaiting 이름의 대기 등록 기능 메소드 만듬 , 매개변수는 String phone, int count
        Waiting waiting = new Waiting(phone , count );
        // Waiting 객체의 매개변수 값들을 대입하는 waiting 이름의 객체 생성
        for( int i = 0 ; i <= waitings.length -1 ; i++){ // 100번째까지 있는 waitings 배열을 순회
            if(waitings[i] == null){ // null 이면
                waitings[i] = waiting; // i번째 배열에 waiting 객체를 대입
                return true;            // 반환 , 메소드 종료
            } // if e
        } // for e
        return false;                   // != null 일때 반환.
    } // class e

    // 대기 현황 조회 기능 메소드

    public static Waiting[] getWaitingList(){
        return waitings;
    }
}
