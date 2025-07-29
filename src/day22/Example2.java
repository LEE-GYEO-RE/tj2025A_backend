package day22;

import java.util.ArrayList;
import java.util.Random;

public class Example2 {
    public static void main(String[] args) {

        /*
            [ Random ] 난수 클래스
                1. 사용법
                    1) 랜덤 객체 생성
                        Random random = new Random();
                    2) 주요 메소드
                        .nextInt()          : int 타입의 허용범위내 난수 생성
                        .nextInt( n );      : 0 부터 n-1 사이의 난수 생성
                        .nextInt( n ) + s   : s 부터 n 사이의 난수 생성

        */
        // 1. Random 객체 생성
        Random random = new Random();
        System.out.println(random);

        // 2. 1 ~ 10 사이의 난수 생성 ( int 타입 )
        int value1 = random.nextInt();
        System.out.println("value = " + value1);
        int value2 = random.nextInt( 10 ) + 1;
        System.out.println("value2 = " + value2);

        // 3. 0 ~ (n-1) 까지 난수 생성
        int value3 = random.nextInt( 100 );
        System.out.println("value3 = " + value3);

        // 4. 0 과 1 사이의 실수 생성
        double value4 = random.nextDouble();
        System.out.println("value4 = " + value4);

        // 5. true 와 false 생성
        boolean value5 = random.nextBoolean();
        System.out.println("value5 = " + value5);

        // 6. 임의의 여러개 데이터 중 하나 선택
        // 활용1] 추첨제
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석"); nameList.add("강호동"); nameList.add("신동엽");
        int randomIndex = random.nextInt( nameList.size() );  // .size() : ArrayList 길이 반환 메소드
        System.out.println("추첨된 이름 : " + nameList.get( randomIndex ));

        // 활용2] 새로운 비밀번호 , 인증코드 문자 난수 표현
        String code = "";    // 빈 문자열 생성
        for ( int i = 1; i <= 6 ; i++){ // 6자리 만들기 위한 6회전 반복
            Random ran = new Random();
            int val = ran.nextInt(26 ) + 97;  // a : 97 ~ z : 122
            char str = (char)val;
            System.out.println( str );  // a ~ z 까지 난수로 나옴
            code += str;
        } // for e
        System.out.println( "생성된 코드 : " + code );

        // 활용3] 아스키코드 패턴으로 난수 계산식을 만들지 못할 경우 직접 난수에 넣을 데이터를 배열로 선언
        char[] ranStr = { '0' , '1' , '2' , '3' , 'A' , 'a' , '!' };
        String newPwd = "";
        for( int i = 1 ; i <= 8; i++){
            Random ran1 = new Random();
            int val1 = ran1.nextInt( ranStr.length );
            newPwd += ranStr[val1];
        } // for e
        System.out.println("새로운 비밀번호 : " + newPwd);

        // 활용4] 주사위 : 1 ~ 6 사이
        int dice = random.nextInt( 6 ) + 1;
        System.out.println(" 주사위 : " + dice);

        // 활용5] 로또 번호 생성 : 1 ~ 45 사이의 중복없이 6자리 번호 생성
        ArrayList<Integer> lottoList = new ArrayList<>();
        for( int i = 1; i <= 6 ; i++ ) {
            int lotto = random.nextInt(45) + 1;      // 생성된 로또 번호
            if( lottoList.contains( lotto ) ){              // 리스트에 생성된 로또번호가 존재하면
                i--;    continue;                           // 이번 반복문 무효처리
            } // if e
            lottoList.add(lotto);                           // 생성된 로또번호를 리스트에 담기
        } // for e
        System.out.println(lottoList);

        // 활용6] 하나의 문자열에서 추출한 문자로 문자열 난수 생성
        String ranStr2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        int strlen = ranStr2.length();          // (1) 문자열 길이 구하기
        int ranIndex = random.nextInt(strlen);  // (2) 문자열 길이내 난수 생성
        char str = ranStr2.charAt( ranIndex );  // (3) 문자열 내 인덱스 위치한 문자 1개 추출
        System.out.println(str);


    } // main e
} // class e

































