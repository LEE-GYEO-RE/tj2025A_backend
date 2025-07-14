package 종합.예제8.controller;

import 종합.예제8.model.dao.BoardDao;
import 종합.예제8.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {

    // 싱글톤 생성
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }

    // dao 싱글톤 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // 등록 기능 구현
    public boolean addBoard(String content , String writer){
        boolean result = false;
        result = boardDao.addBoard(content , writer );
        // dao에게 매개변수 전달하고 결과값 받는다. 생략가능
        return result;
    } // func e

    // 전체 조회 기능 구현
    public ArrayList<BoardDto> getBoardList(){
        return boardDao.getBoardList();
        // dao에게 요청후 모든 게시물(dto)들을 반환받아 view에게 반환
    } // func e

} // class e
