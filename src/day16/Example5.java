package day16;

import java.io.File;
import java.io.FileInputStream;

public class Example5 {
    public static void main(String[] args) {

        // 예제2 : 공공데이터포털에서 CSV 파일 다루기
        // CSV : 데이터 속성을 행과 열로 구분 , 행(,쉼표) , 열(\n)
        // 1. 공공데이터 홈페이지
        // 2. '부평구 맛있는 집' 검색
        // 3. '인천광역시 부평구_맛있는 집 현황'
        // 4. [ 다운로드 ]
        // 5. 현재 패키지에 저장(인천광역시 부평구_맛있는집.csv)

        try { // (4) 모든 코드를 감싼 try 예외 처리

            // (1) 파일 존재 여부 확인
            String path = "src/day16/인천광역시 부평구_맛있는 집.csv";
            File file = new File(path);
            System.out.println(file.exists());      // 경로에 파일이 존재하면 true

            // (2) 존재하면 파일 읽어오기
            if (file.exists()) {

                // (3) 파일 입력 객체 생성
                FileInputStream fin = new FileInputStream(path);

                // (5) 읽어온 바이트를 저장할 바이트배열을 용량 만큼 선언
                byte[] bytes = new byte[(int)file.length()];

                // (6) 바이트 읽어서 배열에 저장
                fin.read(bytes);

                // (7) 읽어온 바이트를 문자열로 반환
                // "EUC-KR" : 파일내 (한글)인코딩 안될경우 String 생성자 인수로 추가
                String str = new String(bytes , "EUC-KR");
                System.out.println(str);

                // (8) ************** CSV 분해하기 ****************
                // 속성(열) 구분 : ,(쉼표)        행 구분 : \n
                // .split("구분문자"); : 지정한 구분문자 기준으로 쪼개서 배열 반환 함수
                System.out.println(str.split("\n")[0]);
                // 첫 행 : 연번,업 소 명,소재지,지정메뉴,전화번호,업태
                System.out.println(str.split("\n")[1].split(",")[1]);
                // 두번째 행의 두번째 열 : (주)온누리푸드온누리장작구이
                //----------------------------------------
                String [] 행데이터 = str.split("\n"); // 행 단위로 쪼개서 배열에 저장
                for(int i = 0 ; i < 행데이터.length ; i++){
                    String row = 행데이터[i];
                        // System.out.println(row);                // 한 줄 (행/row) 씩 출력
                    String[] 열데이터 = row.split(",");      // 행을 열 단위로 쪼개서 배열에 저장
                        // System.out.println(열데이터[1]);        // 업소명
                        // System.out.println(열데이터[3]);        // 지정메뉴
                    System.out.printf("업소명 : %s , 지정메뉴 : %s \n" , 열데이터[1] , 열데이터[3]);
                } // for e
            } // if e
        }catch (Exception e ){ System.out.println(e); }

    } // main e
} // class e
