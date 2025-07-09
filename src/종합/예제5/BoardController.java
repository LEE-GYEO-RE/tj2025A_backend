package 종합.예제5;

// 제어/로직 담당 클래스
// 담당 왜 필요함? : 복잡한 로직/코드를 역할/담당 나누어 유지보수 관리 함.
// 예를 들어 , 1인식당이 테이블 3개면 다 담당 가능
// 1인식당인데 테이블 100개면? ㅈ됨 서빙/음식/재고 등 담당 나눠서 관리해야됨
public class BoardController {
    // 멤버변수
    Board[] boards = new Board[100]; // Board 객체 100개 만들수 있는 배열 객체(board) 생성

    boolean doPost(String content, String writer){  // 게시물 등록 기능 메소드 : 입력받은 자료 받아서 객체 생성 후 배열에 저장
        // 메소드 이름       : doPost
        // 매개변수         : 저장할 내용과 작성자 : String content, String writer
        // 반환값          : 성공/실패 == boolean

        Board board = new Board(content , writer ); // 1. 생성자를 이용한 초기화 객체 만들기
        for(int i = 0 ; i<=boards.length -1 ; i++) {// 2. 배열내 빈공간을 찾아서 생성된 객체 대입
            if( boards[i] == null ){                // 만약 i번째 요소가 null 이면
                boards[i] = board;                  // i번째에 생성한 객체 대입
                return true;                        // return 이란 메소드 값 반환이면서 메소드의 종료를 뜻함
            }// if end
        } // for end
        return false;                               // for에서 null이 존재하지 않을 때 , false 반환
    } // func end


    Board[ ] doGet(){    // 게시물 조회 기능 메소드 : 현재 저장된 모든 객체들을 갖고 있는 배열 호출
        // 메소드 이름       : doGet
        // 매개변수          : 출력이라 매개변수 없음
        // 반환값           : boards     , 배열 타입 = Board[]
        return boards;
    }// func end

} // class end

