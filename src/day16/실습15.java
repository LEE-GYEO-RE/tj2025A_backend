package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class 실습15 {
    public static void main(String[] args) throws IOException {


        // 문제 1
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("하루 후기 : ");
            String str = scan.nextLine();

            String path = "src/day16/diary.txt";
            // String 타입으로 경로 지정
            FileOutputStream fout = new FileOutputStream(path);
            // 파일 쓰기
            byte[] outByte = str.getBytes();
            // 입력받은 문자열 바이트 반환
            fout.write(outByte);
            // 변환된 바이트

            // 문제 2
            File file = new File(path);
            // 경로의 파일 생성 후 file 에 저장
            if(file.exists()){ // 파일이 존재하면
                FileInputStream fin = new FileInputStream(path);
                // 파일 입력 객체 생성
                byte [] inByte = new byte[(int)file.length()];
                // 파일 용량만큼 저장하는 바이트 배열 생성
                fin.read(inByte);
                // 파일 내 바이트 읽어오기
                String inStr = new String( inByte );
                // 읽어온 바이트 문자열로 반환
                System.out.println(inStr);
            }

            // 문제 3
            File file1 = new File(path);
            System.out.println(file1.isFile());     // 파일 경로 여부 반환
            System.out.println(file1.getName());    // 파일 이름 반환
            System.out.println(file1.length());     // 파일 용량 반환
            System.out.println(file1.exists());     // 파일 존재 여부 반환

        }catch (Exception e){
            System.out.println("예외처리" + e);
        }

        // 문제 4

        String path4 = "src/day16/visit_log.txt";
        Scanner scan = new Scanner(System.in);
        System.out.println("방문할 사람?");
        String visitname = scan.nextLine();
        String log = visitname + "님이 방문했습니다" + System.lineSeparator();
        // System.lineSeparator() : 안전한 줄바꿈

        try {
            FileOutputStream fout = new FileOutputStream(path4 , true );
            // true : 방문기록 저장 , 콘솔 종료 후 새로 쓰면 새로 입력한 값 저장.
            byte[] outByte = log.getBytes();
            // 입력받은 문자열 바이트로 변환
            fout.write(outByte);
            // 변환된 바이트 내보내기
            fout.close();
            // 안전하게 프로그램 닫기
        }catch (Exception e ){
            System.out.println("예외처리 " + e );
        }

        // 문제 5
        Scanner scan5 = new Scanner(System.in);
        System.out.println(" 이름 : ");       String name5 = scan5.next();
        System.out.println(" 전화번호 : ");     String phone = scan5.next();
        System.out.println(" 사는 도시 : ");    String city = scan5.next();

        String info = new String( name5 + "," + phone + "," + city + System.lineSeparator() );

        String path5 = "src/day16/contacts.csv";

        try {
            FileOutputStream fout5 = new FileOutputStream(path5 , true);
            byte[] bytes5 = info.getBytes();
            fout5.write(bytes5);
            fout5.close();
        }catch (Exception e ){
            System.out.println("예외처리" + e);
        }

        // 문제 6

        Scanner scan6 = new Scanner(System.in);
        System.out.println("좋아하는 영화 제목 : ");   String title = scan6.nextLine();
        System.out.println("한줄 감상평 : ");        String review = scan6.nextLine();

        String textReview = (title + " : " + review + System.lineSeparator() );
        String path6 = "src/day16/movie_review.txt";

        try {
            FileOutputStream fout6 = new FileOutputStream(path6, true);
            byte[] bytes6 = textReview.getBytes();
            fout6.write(bytes6);
            fout6.close();

            // 문제 7
            File file = new File(path6);
            // 지정한 파일 정보 제공하는 객체  new File(); 생성 , file 에 저장
            if(file.exists()){ // file 있으면
                FileInputStream fin6 = new FileInputStream(path6);
                // 파일 입력 객체 생성
                byte [] inByte6 = new byte[(int)file.length()];
                // 파일 용량 만큼 저장하는 byte 배열 생성
                fin6.read(inByte6);
                // 파일의 바이트 배열 읽기
                String inStr6 = new String(inByte6);
                // 읽은 파일 String 문자열로 생성 후 저장.
                System.out.println(inStr6);
            } // if e

        }catch (Exception e ){
            System.out.println("예외 처리 " + e );
        }


        // 문제 8
        try {
            String path8 = "src/day16/bupyeong_population.csv";
            // 경로로 파일 가져오기 타입 : String
            File file8 = new File(path8);
            // 가져온 파일 새 File 객체로 저장
            System.out.println(file8.exists());
            // 파일 있으면 출력해보기

            if (file8.exists()) {   // 파일 존재하면 파일 읽을 거임
                FileInputStream fin8 = new FileInputStream(path8);
                // 파일 입력 객체 생성하고 저장
                byte[] bytes8 = new byte[(int) file8.length()];
                // 파일 용량 만큼 바이트 배열로 생성해서 저장
                fin8.read(bytes8);
                // 파일 읽기
                String str8 = new String(bytes8, "EUC-KR");
                // 바이트 배열 String 타입 "문자열"로 다시 반환 , 한글 인코딩
                System.out.println(str8);

                // csv 분해
                String[] row = str8.split("\n");        // 행(row) 단위로 쪼개서 배열에 저장
                for (int i = 0; i < row.length; i++) {  // 행(단위) 첫 줄 인덱스 조회
                    String r = row[i];
                    // System.out.println(r);
                    String[] cul = r.split(",");        // 행(row)을 열(cul) 단위로 쪼개서 배열에 저장
                    // System.out.println(cul[0]);
                    // System.out.println(cul[1]);
                    System.out.printf("동별 : [%s] , 총 인구 : [인구수(계) %s ]명\n", cul[0], cul[1]);
                } // for e
            } // if e
        }catch (Exception e) {
            System.out.println("예외처리" + e );
        }


    } // main e
} // class e



/*

[JAVA] 실습15 : 파일 처리
[ 문제 ] 아래 파일 처리 관련 문제를 해결하시오.
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.

[문제 1] 파일에 일기 쓰기
1. FileOutputStream을 사용하여 src 폴더 내에 src/diary.txt 파일을 생성하세요.
2. "오늘 날씨는 맑았다. 자바 공부는 재미있다." 라는 문자열을 바이트로 변환하여 파일에 쓰세요.
3. try-catch를 사용하여 예외 처리하세요.

[문제 2] 파일에 작성된 일기 읽기
1. FileInputStream을 사용하여 문제 1에서 생성한 src/diary.txt 파일을 읽어오세요.
2. 읽어온 바이트 데이터를 String으로 변환하여 콘솔에 출력하세요.

[문제 3] File 클래스로 파일 정보 확인하기
1. File 객체를 src/diary.txt 경로로 생성하세요.
2. .exists(), .getPath(), .getName(), .length()
메소드를 각각 사용하여 해당 파일의 존재 여부, 경로, 이름, 크기(바이트)를 출력하세요.

[문제 4] 방문 로그 누적 기록하기
1. FileOutputStream을 사용하여 src/visit_log.txt 파일을 여세요.
2. Scanner로 방문자 이름을 입력받아,
"OOO님이 방문했습니다.\n" 형식의 문자열을 visit_log.txt 파일의 기존 내용 뒤에 추가하세요.
3. 프로그램을 여러 번 실행하여 방문 기록이 계속 누적되는지 확인하세요.

[문제 5] 연락처를 CSV 형식으로 파일에 저장하기
1. Scanner를 사용하여 사용자로부터 이름, 전화번호, 사는 도시를 순서대로 입력받으세요.
2. 입력받은 데이터들을 쉼표(,)로 연결하여 하나의 String으로 만드세요.
(예: "유재석,010-1234-5678,서울")
3. 해당 문자열을 contacts.csv 파일에 저장하세요. (줄바꿈 문자 \n 포함)

[문제 6] 영화 감상평을 파일에 저장하기
1. Scanner를 사용하여 사용자로부터 좋아하는 영화 제목과 감상평을 한 줄로 입력받으세요.
2. 입력받은 내용을 src 폴더 내의 src/movie_review.txt 파일에 저장하세요.

[문제 7] 저장된 감상평 파일 읽기
1. 문제 3에서 생성된 src/movie_review.txt 파일의 내용을 읽어오세요.
2. File 클래스의 .length()를 사용하여 파일 크기만큼 바이트 배열을 선언하고, 파일 전체를 한 번에 읽어오세요.
3. 읽어온 내용을 콘솔에 출력하세요.

[문제 8] 공공데이터 CSV 파일 읽고 분석하기
1. **공공데이터포털(data.go.kr)**에서 '부평구_인구현황'을 검색하여 CSV 파일을 다운로드하고,
src 폴더에 bupyeong_population.csv 라는 이름으로 저장하세요.
2. FileInputStream을 사용하여 해당 파일을 읽어오세요.
(주의: 한글 깨짐 방지를 위해 new String(bytes, "EUC-KR") 사용)
3. 읽어온 전체 내용을 줄바꿈(\n) 기준으로 분리하여 String 배열에 저장하세요.
4. for문을 사용하여 배열의 각 줄(각 동의 인구 정보)을 순회하며,
'행정기관'과 '총인구수'만 추출하여 "동별: [ 동별 ], 총 인구: [ 인구수(계)   ]명" 형식으로 출력하세요.


*/