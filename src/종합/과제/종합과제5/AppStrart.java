package 종합.과제.종합과제5;

import 종합.과제.종합과제5.view.WaitingView;

public class AppStrart {
    public static void main(String[] args) {

        // 패키지 구성

        // 요구사항에 필요한 메모리 설계

        // 각 MVC 패턴의 패키지별 클래스 구성
            // 각 클래스에 싱글톤 세팅!  view , controller , dao 클래스
            // 각 싱글톤 호출하고 , 저장하는 멤버변수 선언

        // AppStart 에서 최초 출력 메소드 생성

        // 메모리 설계에 따른 dto 만들기 * 메모리 설계 표를 보고 멤버변수 구성

        // 관례적으로 dto에
            // 기본 생성자 , 전체 생성자 , setter/getter/toString 메소드 자동 생성

        // dao 에 여러개 dto를 저장하는 배열 선언 <- DB 사용시 생략 ,

        // API 명세서 작성 : (기능 설명서)
            // 순번에 따른 기능명 , 매개변수명 , 매개변수 값 예 , 반환 , 반환값 예
                // 순번1 : 대기등록(기능명) , 매개변수명(String phone , int count) , 반환(boolean)
                // 순번2 : 대기전체조회(기능명) , 매개변수x(검색조회면 있음) , 반환(waitingDto[]) , 반환값(배열 내 객체들)
                // 기능명 정하기 = ex) getWaiting() , WaitingPrint()

        // 기능(함수)들을 MVC 패턴으로 3가지 만들기
            // 대기 등록 기능 인 getWaiting()을 dao , controller , view 파트별로 만들어야함
            // 조회 기능 WaitingPrint() 도 마찬가지

        // 화면 연동

        WaitingView.getInstance().index();
    }
}
