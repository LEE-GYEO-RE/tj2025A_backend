package day04;

import java.util.Scanner;

public class Example1 { // class s
    public static void main(String[] args) { // main s
        /*
        [ 반복문 ]
        1. 조건에 따른 결과가 충족(true) 했을 때 (반복)코드 실행
        2. 형태
            for( 초기값 ; 조건문 ; 증감식){
                실행문;
            }
            - 초기값 : 반복문에서 사용되는 변수 *주로 반복 횟수            , int i = 1;
            - 조건문 : 반복변수의 조건문 *주로 반복횟수제한                , i <= 10;
            - 증감식 : 반복변수의 증가 또는 감소 변화식 *주로 반복횟수 증감  , i++
        3. 실행순서
            1) 초기값 -> 2)조건문 -> 3)실행문 -> 4)증감식
                     -> 5)조건문 -> 6)실행문 -> 7)증감식
                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                     -> !) 조건이 false 이면 반복문 종료
        4. for중첩가능 : 상위 for문이 1회전 마다 하위 for문의 전체 회전
            for( ){
                for() { }
            }
        5. 주요 키워드 :
            1) break;       : 가장 가까운 반복문 {} 종료/탈출
            2) continue;     : 가장 가까운 반복문(증감식) 이동
        6. 무한루프
            1) for( ; ; ){ }
            2) while( true ){ }
         */

        // [1] 1부터 5까지 출력 ,
        for( int i = 1 ; i <= 5; i++){
            System.out.println(i);
        }

        // [2] 중첩 : 구구단
        for( int i = 2 ; i <= 9 ; i++){
            for( int j = 1 ; j <= 9 ; j++){
                System.out.printf( "%d X %d = %d \n" , i , j , i*j );
            } // for2 e
        } // for1 e

        // [3] break : 1부터 10까지 출력 , 만약 5이면 반복문종료
        for( int no = 1; no <=10 ; no++){
            System.out.println(no);
            if( no == 5 ){
                break;
            } // if e

        } // for e

        // [4] continue : 1부터 10까지 반복 , 만약에 5를 찾았으면 출력 생략
        for( int no4 = 1; no4 <= 10 ; no4++){
            if( no4 == 5 ){
                continue;
            }
            System.out.println(no4);
        }

        // [5] for( ; ; ){} : 무한 반복 , 종료조건은 필요할수 있음
        // (1)
        for( ; ; ){
            System.out.print("무한 입력 [종료 : 'x' ]");
            String input = new Scanner(System.in).next(); // 키보드로부터 입력받아 저장
            if( input.equals("x")){ break;}             // 만약에 입력한 문자열이 "x" 이면 반복문 탈출 , 무한루프 종료
        }
        // (2)
        // while ( true ){ }
    } // main e
} // class e



















