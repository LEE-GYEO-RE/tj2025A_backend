package 종합.예제6;

// 컨트롤러 : 기능/제어 담당
public class BoardController {

    // 멤버변수
    private static final Board[] boards = new Board[100];
        // private : 현재 클래스에서만 접근 키워드
        // static : 객체 없이 접근 가능한 키워드
        // final : 수정 불가능 키워드

    // 생성자

    // 메소드

        // 등록 메소드 : public 써서 다른 클래스에서 접근 가능

    public static boolean doPost( String content , String writer ){ // day 08과 다른 건 public , static만 추가된거

        Board board = new Board( content , writer );// 매개변수로 객체 생성
        for( int i = 0 ; i < boards.length; i++){
            if(boards[i] == null ){
                boards[i] = board;
                return true;    // 저장성공 뜻을 true로 부여하여 반환
            } // if e
        } // for e
        return false; // 저장실패 뜻을 false 로 부여하여 반환
    } // class e

        // 조회 메소드
    public static Board[] doGet(){
        return boards;
    }

} // class e
