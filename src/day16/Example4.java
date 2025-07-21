package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {


        try {
            // 예제1 : 키보드로부터 입력받은 텍스트 저장
            // (1) 키보드로부터 아무거나 입력받기
            Scanner scan = new Scanner(System.in);
            System.out.println("저장할 내용 : ");
            String str = scan.next();

            // (2) 파일의 경로 지정
            String path = "./src/day16/test2.txt";   // 임의 파일명과 경로 지정
            // (3) 파일 쓰기
            FileOutputStream fout = new FileOutputStream(path);
            // (4) 입력받은 문자열을 바이트 변환
            // 왜? Stream은 바이트만 쓰기/읽기 가능하다.
            byte[] outByte = str.getBytes();
            // (5) 변환된 바이트를 내보내기
            fout.write( outByte );

            // 예제2 : 파일로 부터 텍스트를 호출
            // (1) File 클래스 : 지정한 파일의 정보를 제공하는 객체 , new File();
            File file = new File(path);
            System.out.println(file.isFile());      // .isFile() : 파일 경로 여부 반환 true/false
            System.out.println(file.getName());     // .getName() : 파일 이름 반환
            System.out.println(file.length());      // .length() : 파일 용량(바이트) (long) 반환
            System.out.println(file.exists());      // .exists() : 파일 존재 여부 반환 ture/false

            // System.out.println(예외발생);

            // file.delete();                       // 지정한 경로에 파일 삭제 함수
            // file.creatoNewFile();                // 지정한 경로에 파일 생성 함수


            if(file.exists()) {
                FileInputStream fin = new FileInputStream( path);    // 파일 입력 객체 생성
                byte[ ] inByte =  new byte[(int)file.length()];       // 읽어온 바이트들을 저장한 바이트 배열 선언
                fin.read(inByte);                               // 파일 내 바이트 읽어오기
                String inStr = new String ( inByte );           // 읽어온 바이트 배열을 문자열로 변환
                System.out.println(inStr);



            }

        }catch (Exception e ){
            System.out.println("예외발생 : " + e);
        }

    } // main e
} // class e
