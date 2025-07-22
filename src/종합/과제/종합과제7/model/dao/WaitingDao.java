package 종합.과제.종합과제7.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.과제.종합과제7.model.dto.WaitingDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {

    // 싱글톤 생성 : 객체 하나 생성해서 프로그램 내 이 객체는 하나만 있다고 선언하는 것
    private WaitingDao(){
        openCSV();
        // 싱글톤 생성시 CSV 바로 연동!
    }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }

    // DB 대신 리스트 선언
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // 등록
    public boolean addWaiting(WaitingDto waitingDto){
        waitingDB.add(waitingDto);  // db에 dto 저장
        saveCSV();                  // csv에 저장
        return true;
    } // func e

    // 전체 조회
    public ArrayList<WaitingDto> waitingPrint(){    // 반환타입으로 모든 dto 반환.
        return waitingDB; // waitingDB 타입 :  ArrayList<WaitingDto>
    }

    // CSV 파일 경로 지정
    private String path = "src/종합/과제/종합과제7/data.csv";

    // CSV 파일 연동 함수
    public void openCSV(){
        File file = new File(path);         // 파일 객체 생성
        if(file.exists()){                  // 파일 존재하면 정보 불러오기
            loadCSV();                      // csv 호출
        }else {                             // 파일 없으면
            try {
                file.createNewFile();       // file(path) 생성
            }catch (IOException e){
                System.out.println(e);
            }
        }
    } // func e

    // CSV 입력(호출) 함수
    public void loadCSV(){
        try {
            FileReader fileReader = new FileReader(path);               // FileReader 이용한 읽기보드 객체 생성
            CSVReader csvReader = new CSVReader(fileReader);            // CSVReader 에 FileReader 대입해서 CSV 객체 생성
            List<String[]> inData = csvReader.readAll();                // .readAll() 함수로 모든 정보 읽기
            for (String[] row : inData) {                               // 배열타입으로 반복문 실행
                String phone = row[0];                                  // 각 행의 첫번째 열은 전화번호
                String count = row[1];                                  // 각 행의 두번째 열은 인원수
                // 두번째 열은 인원 수
                // 여기서 매개변수 저장을 int로 했으면 Integer.parseInt(row[1])로 타입변환 해줘야함
                // 단순 출력이니 그냥 String으로 매개변수 저장함. 나중엔 무조건 타입 맞춰주고 빼내고 저장할때도 타입 맞춰주는게 좋음
                WaitingDto waitingDto = new WaitingDto(phone, count);   // 각 열들을 새로운 객체 하나(dto)로 생성
                waitingDB.add(waitingDto);                              // 그리고 그걸 객체로 리스트에 저장
            } // for e
            csvReader.close();                                          // 안전히 객체 닫기
        }catch (Exception e ){
            System.out.println(e);
        }
    } // func e

    // CSV 출력(저장) 함수
    public void saveCSV(){
        try {
            FileWriter fileWriter = new FileWriter(path);                       // FileWriter 파일 쓰기모드 객체 생성
            CSVWriter csvWriter = new CSVWriter(fileWriter);                    // CSVWriter에 FilewWriter 객체 대입해서 생성 --> OpenCSV 쓰기위해
            List<String[]> outData = new ArrayList<>();                         // 비어있는 리스트 생성
            // db에 있는 모든정보를 빈 리스트(outData)에 넣어주기 위한 반복문
            for (WaitingDto waitingDto : waitingDB) {
                String[] row = {waitingDto.getPhone(), waitingDto.getCount()}; // Dto의 전화번호 , 인원수 하나씩 배열로 구성
                outData.add(row);                                               // outData에 저장
            } // for e
            csvWriter.writeAll(outData);                                        // 저장된 outData를 .writeAll해서 CSV 내보내기
            csvWriter.close();                                                  // 안전하게 객체 닫기
        }catch (Exception e ){
            System.out.println(e);
        }
    } // func e

} // class e
