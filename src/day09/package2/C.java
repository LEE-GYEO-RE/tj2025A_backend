package day09.package2; // C클래스의 폴더(패키지) 위치
public class C {
    // 비공개 멤버변수
    private int 비공개변수;
    // 비공개 멤버변수를 반환하는 공개 메소드 , getter
    public int 반환메소드( ){
        // 유효성검사
        return 비공개변수; // 클래스내 비공개 변수 반환
    }
    private void 저장메소드( int 값 ){
        비공개변수 = 값;
    }
} // class end
