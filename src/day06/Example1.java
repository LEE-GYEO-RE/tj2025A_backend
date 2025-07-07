package day06;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Example1 { // class s
    public static void main(String[] args) { // main s

        /*
            [ 배열 ]
                1. 정의 : *동일한* 자료형(타입)의 여러개 데이터를 순서대로 저장하는 타입

                2. 특징
                    1) 동일한 타입 : 서로 다른 타입의 데이터를 같은 배열에 저장할 수 없다.
                    2) 고정 길이 : 배열은 한번 생성되면 길이 수정 불가.
                    3) 요소 초기값 : 요소의 초기값이 없으면 자동으로 기본값 대입
                        정수 : 0 , 실수 : 0.0 , 논리 : false , 객체(배열) : null

                3. 사용법
                    1) 선언/생성
                        (1) new 타입[길이];                 ,   int [ ] 변수명 = new int[ 3 ];
                        (2) { 값1 , 값2 , 값3 }            ,   double[ ] 변수명 = { 3.14 , 5.1 ,70.67 }

                    2) 호출
                        (1) 변수명                         , 배열(객체) 의 주소값
                        (2) Arrays.toString( 변수명 );     , 배열 내 요소 값들을 문자열로 반환
                        (3) 변수명[인덱스]
                            * 인덱스란? 배열내 저장된 요소들의 순서번호 , 0번부터 시작
                            * 변수명.length : 배열내 요소개수 반환 , 배열의 길이
                    3) 수정
                        (1) 변수명 = new 타입[ 3 ];          , 전체 배열 수정
                        (2) 변수명[인덱스] = 새로운값;        , 특정 인덱스의 값 수정

                    4) 삭제/추가 * 특정한 요소 삭제는 존재하지 않는다. 자바 배열은 고정 길이 이므로 중간에 요소 총개수 변경할 수 없음.

                    5) 배열과 반복문
                        (1) 일반 for문
                            for( int index =0 ; index <= 배열변수명.length -1 ; index++){
                                타입 변수명 = 배열변수명[index];
                            }
                        (2) 향상된 for문 , 인덱스 없이 배열내 요소값 하나씩 변수에 대입 반복
                            for( 타입 변수명 : 배열변수명){
                            }

        */

        // [1] 배열 선언 1 : 선언만
        int[] array1 = new int[3];

        // [2] 배열 선언2 : 선언과 초기화
        String[] array2 = { "봄" , "여름" ,"가을" , "겨울" };

        // [3] 출력 : 객체의 주소값 반환
        System.out.println( array1 );                   // I@4c873330 : 객체 주소값(컴퓨터가 사용하는 메모리 위치 정보)
        System.out.println( array2 );                   // [Ljava.lang.String;@119d7047 : 객체의 주소값

        // [4] Arrays.toString : 배열 내 요소들을 문자열로 반환
        System.out.println(Arrays.toString(array1));    // [0, 0, 0] : 배열내 요소값들을 문자열로 반환
        System.out.println(Arrays.toString(array2));    // [봄, 여름, 가을, 겨울]

        // [5] 배열내 특정 인덱스 값 출력
        System.out.println(array1[0]);                  // 0
        System.out.println(array2[0]);                  // 봄

        // [6] 배열내 총 요소 개수 반환
        System.out.println(array2.length);              // 배열내 길이 반환 : 4

        // [7] 특정한 요소 값 수정
        array1[0] = 10;
        System.out.println( array1[0]);                 // 10
        array2[0] = "spring";
        System.out.println( array2[0]);                 // spring

        // [8] 삭제/추가 불가. 선언할 때 초기 인덱스 값만 사용 가능
        // array1[3] = 40;                              // 오류 : Index 3 out of bounds for length 3

        // [9] 반복문
        // (1) 일반 for문
            for( int index = 0; index <= array1.length -1; index ++){   // index는 0부터 마지막 인덱스까지 1씩 증가 반복
                int value = array1[index];                              // index번째 요소 값 호출
                System.out.println(value);                              // 10 , 0 , 0
            } // for end

        // (2) 향상된 for문 , for( 요소타입 반복변수명 : 배열변수명 ) { }
            for( String value : array2 ){                               // JS : for( let 변수명 of 배열변수명 ) { }
                System.out.println(value);                              // spring , 여름 , 가을 ,겨울
            } // for end

    } // main e
} // class e















































