package day17;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {

        // OpenCSV 라이브러리 설치
        // 각종 자바 관련 라이브러리 공유 : https://mvnrepository.com/
        // (1) OpenCSV : https://mvnrepository.com/artifact/net.sf.opencsv/opencsv/2.3
        // (2) [JAR] 다운로드 버튼 클릭
        // (3) 해당 패키지로 넣기
        // (4) 현재 프로젝트에 지정한 라이브러리 등록
        // 해당 .JAR 파일을 오른쪽 클릭 --> 가장 하단 [라이브러리 추가]

        // ------> 쓰는 이유
        //  CSV 분해할때 split으로 행 열 구분 시 ,(쉼표)들로 구분이 어려워서(""큰 따옴표 안에 , 있으면 그것도 분해해버림) 유효성 검사를 해야함
        //  유효성 검사 귀찮기 때문에 라이브러리로 쓰는 거.

        // OPENCSV 라이브러리 사용해보기
            // CSVReader( new FileReader( 파일경로 ) ) : CSV 읽어오는 클래스
                // --> .readAll() : 데이터를 List<String[]> 타입으로 반환 하는 함수
            // CSVWriter( new FileWriter( 파일경로 ) )  : CSV 출력하는 클래스
                // --> .writeAll( List 객체 ) : List 객체를 CSV로 내보내는 함수
        try {
            // 1. 파일 경로 지정
            String path = "src/day17/인천광역시 부평구_맛있는 집.csv";
            // 2. 파일 읽기모드 객체 생성 , 예외 처리 , 한글 인코딩 Charset.forName("EUC-KR")
            FileReader fileReader = new FileReader(path , Charset.forName("EUC-KR"));
            // 3. CSVReader 클래스 이용한 file 읽어오기
            CSVReader csvReader = new CSVReader(fileReader);
            // 4. 바이트로 읽어오는 게 아니라 한번에 읽음 .readAll() : List<String[]> 반환
            List<String[]> inDate = csvReader.readAll();
                // List 인터페이스 타입 : ArrayList 구현체
            System.out.println(inDate);
            // 5. 반복문 이용한 순회
            for(int i = 0; i < inDate.size() ; i++){
                String[] row = inDate.get(i);
                System.out.printf("업소명 : %s , 지정메뉴 : %s \n" , row[1] , row[3] );
            }
        }catch (Exception e ){
            System.out.println("예외처리" + e );
        }
    } // main e
} // class e
