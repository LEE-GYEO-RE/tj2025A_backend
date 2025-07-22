package 종합.예제9.controller;

import 종합.예제9.model.dao.BoardDao;
import 종합.예제9.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {

    // 싱글톤 생성
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }

    // 싱글톤 가져오기
    public BoardDao boardDao = BoardDao.getInstance();

    // 등록
    public boolean boardWrite(String content , String writer ){
        // 매개변수로 dto 객체 생성
        BoardDto boardDto = new BoardDto(content , writer);
        // dao 에게 저장할 객체를 전달하여 결과 받기
        boolean result = boardDao.boardWrite( boardDto );
        // 결과 view에게 리턴
        return result;
    } // func e

    // 전체 조회
    public ArrayList<BoardDto> boardPrint(){
        // dao에게 매개변수 없이 모든 dto정보를 요청하여 받는다.
        ArrayList<BoardDto> result = boardDao.boardPrint();
        // 결과를 view에게 리턴
        return result;
    } // func e

} // class e
