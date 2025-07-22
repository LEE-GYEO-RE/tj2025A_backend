package 종합.예제9.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.예제9.model.dto.BoardDto;
import 종합.예제9.view.BoardView;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

    // 싱글톤 생성
    // 지정한 클래스 내 하나의 객체를 미리 만들고 프로그램 내 하나의 객체만 존재
    private BoardDao(){
        // -- 싱글톤 생성시 csv 오픈
        openCSV();
    }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }

    // DB 대신할 리스트 선언 <나중에 DB쓸거임 오늘만 씀>
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // 등록
    public boolean boardWrite(BoardDto boardDto ){
        // boolean : 반환타입으로 성공시 true 실패시 false
        // boardWrite : 임의의 함수명
        // BoardDto boardDto : 매개변수
        boardDB.add(boardDto); // 리스트(db) 에 DTO를 저장한다.

        // * CSV 저장
        saveCSV();

        return true;            // 성공시 true 반환
    } // func e

    // 전체 조회
    public ArrayList<BoardDto> boardPrint(){
        // ArrayList<BoardDto> : 반환타입으로 모든 dto를 반환한다.
        return boardDB; // boardDB 변수의 타입은 ArrayList<BoardDto>
    } // func e


    private String path = "src/종합/예제9/data.csv";
    // CSV 파일 경로 지정
    // -------------------- 1. CSV 파일 연동 함수 ----------------------
    public void openCSV(){
        File file = new File(path);     // 파일 객체 생성
        if(file.exists()){              // 파일 존재 하면 정보 불러오기 .exists() : 존재여부 반환 함수
            loadCSV();
        }else {                         // 아니면 파일 생성
            try {file.createNewFile(); }      // .createNewFile() : 파일 생성 함수
            catch (IOException e ){ System.out.println(e);}
        }
    }

    // -------------------- 2. CSV 입력(호출) 함수
    public void  loadCSV(){
        try {
            FileReader fileReader = new FileReader(path);       // FileReader 이용한 읽기모드 객체 생성
            CSVReader csvReader = new CSVReader(fileReader);    // CSVReader 에 FileReader 대입하여 CSV 객체 생성
            List<String[]> inData = csvReader.readAll();        // .readAll() 함수로 모든 정보를 읽어온다.
            for (String[] row : inData) {                      // 향상된 for문
                String content = row[0];                        // 첫번째 열
                String writer = row[1];                         // 두번째 열
                BoardDto boardDto = new BoardDto(content, writer);    // 각 열들을 하나의 dto로 생성
                boardDB.add(boardDto);                          // 생성된 dto를 리스트에 저장
            } // for e
            csvReader.close();
            // csvReader 객체 안전하게 닫기 : 메모리 누수 방지 : 파일의 용량이 커서 자동 초기화 보다 직접 초기화가 안전함.
        }catch (Exception e ){ System.out.println(e); }
    } // func e

    // -------------------- 3. CSV 출력(저장) 함수
    public void saveCSV(){
        try {
            FileWriter fileWriter = new FileWriter(path);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            List<String[]> outData = new ArrayList<>();
            for (BoardDto boardDto : boardDB) {
                String[] row = {boardDto.getContent(), boardDto.getWriter()};
                outData.add(row);
            } // for e
            csvWriter.writeAll(outData);
            csvWriter.close();
        }catch (Exception e) { System.out.println(e); }
    }

} // class e






















