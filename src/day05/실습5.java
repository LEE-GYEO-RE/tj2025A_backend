package day05;

import java.util.Scanner;

public class 실습5 { // class s
    public static void main(String[] args) { // main s
        /*
        // 문제 1
        for( int i = 1 ; i <= 10 ; i++){
            System.out.println(i);
        }

        // 문제 2
        for( int j = 10 ; j >= 1 ; j-- ){
            System.out.println(j);
        }

        // 문제 3
        int sum = 0; // 누적합계 변수 초기값
        for( int z = 1 ; z <= 50 ; z++){
            sum = sum + z; // sum += z
        }
        System.out.println(sum);

        // 문제 4
        for( int x = 1 ; x <= 20 ; x++){
            if( (x % 2 == 0) ){
                System.out.println(x);
            }
        }


        // 문제 5
        for( int a = 1 ; a <= 30 ; a++){
            if( a % 3 == 0 ){
                continue;
            }
            System.out.println(a);
        }

        // 문제 6
        int sum = 0;
        for( int b = 1 ; b <= 100; b++){
            sum += b;
            if( sum > 100 ){
                break;
            }
        }
        System.out.println(sum);

        // 문제 7

        for( int s = 1 ; s <= 5 ; s++ ){
            System.out.println();
            for ( int ss = 1 ; ss <= s ; ss++){
                System.out.print("*");
            }
        }

        // 문제 8
        for( int a = 1 ; a <= 5 ; a++ ){
            System.out.println(); // 줄바꿈 처리
            for( int b = 1 ; b <= 6-a ; b++){
                System.out.print("*");
            }
        }

        // 문제 9
        int count = 0;                                                              // 반복문 밖에서 반복 횟수 선언 : 누적합계
        for( ; ; ){
            Scanner scan = new Scanner(System.in);                                  // (1) 입력객체 생성하여 변수에 저장
            String str = scan.next();                                               // (2) 문자열 입력 받아 문자열 변수에 저장
            System.out.println( str );                                              // (3) 입력받은 값 출력
            if( str.equals("end")){                                                 // (4) 자바에서 문자열 비교는 .equals() 함수 사용
                System.out.printf("프로그램 종료 합니다. [ 총 %d회 입력 ] \n" , count);
                break;                                                              // (5) 가장 가까운 반복문 종료 : 무한 루프 종료
            }
            count++;                                                                // (6) 입력 횟수 == 반복 횟수 저장하는 변수
        } // for e

        // 문제 10

        int july1 = 3532100;
        int july2 = 9123700;
        int july3 = 5183400;
        int july4 = 11738700;

        int result1 = july1/10000;
        int no1 = result1/100;
        for( int i = 1 ; i<= no1 ; i++){                // 1부터 result1을 100으로 나눈 값까지 1씩 증가
            System.out.print("■");                      // 그 값을 리터럴 "■" 로 출력
        }
        System.out.println(result1 + "만원");            // '■■■353만원' 형식으로 출력

        int result2 = july2/10000;
        int no2 = result2/100;
        for( int i = 1 ; i<= no2 ; i++){
            System.out.print("■");
        }
        System.out.println(result2 + "만원");

        int result3 = july3/10000;
        int no3 = result3/100;
        for( int i = 1 ; i<= no3 ; i++){
            System.out.print("■");
        }
        System.out.println(result3 + "만원");

        int result4 = july4/10000;
        int no4 = result4/100;
        for( int i = 1 ; i<= no4 ; i++){
            System.out.print("■");
        }
        System.out.println(result4 + "만원");

         */
        // 문제 11
        // 메인 화면 출력
        // 입력 객체 생성
        // 입력 선택 시 출력 되는 기능 구현
        // 출력 될때 필요한 메모리 설계
        // * balance 변수 : 초기 잔금 0부터 해서 입금 했을 때 + (입금 메모리), 출금했을 때 -(출금 메모리) 하여 현재 금액 저장하는 변수
        // 여러 사람이면 [ ] 배열로 만들면 됨.

        // 시각적인 요소 생성
        int balance = 0;                                                    // for문 밖에 선언 , 잔고는 누적 해야하니깐
        for( ; ; ){                                                         // 무한 루프 , 특정한 break 전까지 계속 실행
            System.out.println("---------------------------------");        // 메인화면 출력
            System.out.println("1:입금 | 2:출금 | 3:잔고 | 4:종료");
            System.out.println("---------------------------------");
            System.out.print("선택 > ");
            Scanner scan = new Scanner(System.in);                          // 입력 객체 생성 , 변수에 저장
            int choose = scan.nextInt();                                    // 입력 받은 정수를 변수에 저장

            // 선택 판단
            if( choose == 1 ){                                              // 만약 '1'을 선택했으면
                System.out.print("입금액: " );
                int money = scan.nextInt();
                balance += money;                                           // 잔고에 입금 누적 더하기
                System.out.println(money + "원");
            }
            else if( choose == 2 ){
                System.out.print("출금액 : ");
                int money = scan.nextInt();
                if( money <= balance ){ balance -= money; }                 // 출금액이 잔고보다 작으면 누적 빼기
                else {
                    System.out.println("[안내] 잔고가 부족합니다.");            // 출금액이 잔고보다 크면 안내 메시지
                }

            }
            else if( choose == 3 ){                                         // 잔고 출력
                System.out.print("잔고 : " + balance);
                System.out.println();

            }
            else if( choose == 4 ) {                                        // 프로그램 종료 선택시 break;로 반복문 종료
                System.out.println("프로그램을 종료합니다. ");
                break;
            }
        }

    } // main e
} // class e
//JAVA] 실습5 : 반복문
//[ 문제 ] 아래 반복문 관련 문제
//[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
//
//[문제 1] for문을 사용하여 1부터 10까지의 숫자를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
//
//[문제 2] for문을 사용하여 10부터 1까지의 숫자를 역순으로 출력하는 프로그램을 작성하시오.
//
//[문제 3] for문을 사용하여 1부터 50까지 모든 정수의 합계를 구하여 최종 결과를 출력하시오.
//출력 예시:
//1부터 50까지의 합계: 1275
//
//[문제 4] for문과 if문을 사용하여, 1부터 20까지의 숫자 중 짝수만 출력하는 프로그램을 작성하시오.
//
//[문제 5] 1부터 30까지의 숫자 중, 3의 배수는 건너뛰고 나머지 숫자만 출력하는 프로그램을 작성하시오.
//요구 조건: continue 문을 반드시 사용하시오.
//
//[문제 6] 1부터 순서대로 숫자를 더해나갈 때, 합계가 처음으로 100을 초과하는 시점의 숫자와 그때까지의 합계를 출력하고 반복문을 즉시 종료하시오.
//요구 조건: break 문을 반드시 사용하시오.
//출력 예시:
//14까지 더했을 때 합계가 105로 100을 넘습니다.
//
//[문제 7] 중첩 for문을 사용하여 아래와 같이 별(*)로 이루어진 직각삼각형을 출력하시오.
//출력 예시:
//*
//**
//***
//****
//*****
//
//[문제 8] 중첩 for문을 사용하여 아래와 같이 별(*)로 이루어진 역직각삼각형을 출력하시오.
//출력 예시:
//*****
//****
//***
//**
//*
//
//
//[문제 9]  Scanner와 무한루프를 사용하여,
// 사용자가 "end"를 입력할 때까지 계속해서 문자열을 입력받는 프로그램을 작성하시오. "end"가 입력되면,
//그 전까지 입력된 문자열의 총 횟수를 계산하여 아래 출력 예시와 같이 출력한 뒤 프로그램을 종료하시오.
//요구 조건:
//무한루프를 사용하시오 (for(;;) 또는 while(true)).
//입력 횟수를 저장할 count 변수를 사용하시오.
//break를 사용하여 루프를 탈출하시오.
//문자열 비교는 .equals() 메소드를 사용하시오.
//실행 예시:
//1회 입력 : 자바
//2회 입력 : 자바스크립트
//3회 입력 : 파이썬
//4회 입력 : HTML
//5회 입력 : CSS
//6회 입력 : C언어
//7회 입력 : end
//[안내] 프로그램을 종료 합니다.[총 6회 입력]
//
//[문제 10] 아래 선언된 4개의 변수는 7월 각 주차별 매출액입니다.
// 각 매출액을 '만원' 단위로 변환하고, 백만원 단위마다 '■' 문자로 시각화하여 아래 출력 예시와 같이 보고서를 출력하시오.
//선언 코드:
//int july1 = 3532100;
//int july2 = 9123700;
//int july3 = 5183400;
//int july4 = 11738700;
//요구 조건:
//매출액을 10000으로 나눈 몫을 사용하여 '만원' 단위를 계산합니다.
//'만원' 단위 값을 다시 100으로 나눈 몫만큼 for문을 사용하여 '■' 문자를 반복 출력합니다.
//출력 예시:
//------- 7월 매출액 -------
//1주차 : ■■■353만원
//2주차 : ■■■■■■■■■912만원
//3주차 : ■■■■■518만원
//4주차 : ■■■■■■■■■■■1173만원
//
//
//[문제 11]  Scanner와 for(;;) 무한루프를 사용하여 간단한 ATM 기기를 만드시오.
//요구 조건:
//사용자에게 "1:입금 | 2:출금 | 3:잔고 | 4:종료" 메뉴를 보여줍니다.
//Scanner로 메뉴 번호를 입력받습니다.
//1번을 선택하면 "입금액:"을 물어보고, 입력받은 금액만큼 잔고(balance)를 증가시킵니다.
//2번을 선택하면 "출금액:"을 물어보고, 입력받은 금액만큼 잔고를 감소시킵니다. (단, 잔고보다 큰 금액은 출금할 수 없다고 안내)
//3번을 선택하면 현재 잔고를 출력합니다.
//4번을 선택하면 "프로그램을 종료합니다." 메시지를 출력하고 break를 이용해 무한루프를 탈출합니다.
//초기 잔고는 0으로 시작합니다.
//실행 예시:
//---------------------------------
//1:입금 | 2:출금 | 3:잔고 | 4:종료
//---------------------------------
//선택> 1
//입금액> 10000
//---------------------------------
//1:입금 | 2:출금 | 3:잔고 | 4:종료
//---------------------------------
//선택> 3
//잔고> 10000
//---------------------------------
//1:입금 | 2:출금 | 3:잔고 | 4:종료
//---------------------------------
//선택> 4
//프로그램을 종료합니다.