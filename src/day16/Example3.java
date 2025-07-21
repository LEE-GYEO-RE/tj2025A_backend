package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 파일 입출력 클래스 ]
            1. 쓰기/출력/내보내기 방법 . 자바 --> 외부
                - FileOutputStream 클래스
            2. 읽기/입력/가져오기 방법 , 자바 <-- 외부
                - FileInputStream 클래스

        */

        // [1] 파일 쓰기

        // (1) 파일 경로 설정
        String path = "./src/day16/test1.txt";       // 파일의 위치 , 상대경로 또는 절대경로
        // 해당 패키지명(day16) 오른쪽 클릭 -> [경로/참조 복사] -> 컨텐츠로부터 경로 복사후 -> 파일명작성

        // (2) 파일 출력 객체 생성 * 무조건 (FileNotFoundException) 일반예외 발생
            // FileOutputStream fout = new FileOutputStream(파일 경로 );

        // (3) 예외처리 하기
        try {

            FileOutputStream fout = new FileOutputStream( path );

            // (4) 파일에 쓰기 , write( 바이트데이터 ); * 무조건 (IOException) 일반예외 발생
            // "문자열".getBytes() : 문자열 --> 바이트 배열 변환하는 반환 함수
            fout.write("자바에서 작성한 텍스트입니다. " .getBytes() );

        }catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않습니다." + e);
        }catch (IOException e){
            System.out.println("입출력 도중에 오류가 발생했다." + e);
        }

        // [2] 파일 읽기
        // (1) 경로는 위에서 선언한 path 그대로 사용.
        // (2) 파일 입력 객체 생성
            // FileInputStream fin = new FileInputStream(파일경로);
        try {

            FileInputStream fin = new FileInputStream(path);

            // (3) 읽어온 바이트 들을 저장할 배열을 저장한다.
            byte [] bytes = new byte[43];   // 43바이트를 저장할 배열을 준비

            // (4) 읽어오기 , .read( 바이트배열 ); * 무조건 (IOException) 일반예외 발생
            fin.read(bytes);

            // (5) new String( 바이트배열 ); 읽어온 바이트를 문자열로 반환
            System.out.println(new String(bytes));

        }catch (FileNotFoundException e ){
            System.out.println("파일 또는 경로가 존재하지 않습니다. " + e );
        }catch (IOException e ){
            System.out.println("파일 읽어오는데 문제가 발생했습니다." + e );
        }
    } // main e
} // class e



















