package 종합.예제8.model.dao;

import 종합.예제8.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardDao {

    // 싱글톤 생성
    private BoardDao(){}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }

    // 여러개 게시물(DTO)들을 저장할 리스트 선언
    private ArrayList <BoardDto> boardDB = new ArrayList<>();


    // 등록 기능 구현
    public boolean addBoard(String content, String writer){
        boolean result = false;
        BoardDto boardDto = new BoardDto( content , writer );
        // 매개변수 값들을 객체화 하기
        boardDB.add(boardDto);
        // 리스트에 생성한 객체 추가하기
        result = true;
        // 성공시 result에 성공의미로 'true' 대입
        return result;
    } // func e

    // 전체 조회 기능 구현
    public ArrayList <BoardDto> getBoardList(){
        return boardDB;
    } // func e

} // class e
