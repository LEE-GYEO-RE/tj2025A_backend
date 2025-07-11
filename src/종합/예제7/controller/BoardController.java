package 종합.예제7.controller;

import 종합.예제7.model.dao.BoardDao;
import 종합.예제7.model.dto.BoardDto;

public class BoardController {

    // 처리 순서
    // V ---> C ---> M(DAO)

    // - 싱글톤 만들기
    private BoardController(){}
    private static final BoardController control = new BoardController();
    public static BoardController getInstance(){
        return control;
    }

    // DAO 객체 (싱글톤) 객체 가져오기 : 멤버변수 / 여러 메소드에서 쓰기 위해서 함수 밖에 생성
    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 등록 처리 메소드 :
    // view 에게 전달받은 content , writer 객체로 구성하여 dao 에게 전달 후 결과를 view에게 전달
    public boolean boardWrite( String content , String writer ){
        BoardDto boardDto = new BoardDto(content , writer );// 1) 매개변수 객체화
        boolean result = boardDao.boardWrite(boardDto);  // 2) dao에게 객체를 전달후 결과 받기
        return result;      // dao에게 받은 결과를 view에게 반환하기
    }

    // 2. 조회 처리 메소드

    public BoardDto[] boardPrint(){
        BoardDto[] result = boardDao.boardPrint();// - DAO 에게 게시물 조회 요청 후 반환값을 저장한다.
        return  result;
    }

}
