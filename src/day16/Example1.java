package day16;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {

        /*
            [ 예외 처리 ]

                1. 시스템 오류 : 시스템이 종료되는 심각한 수준의 문제

                2. 예외 : 개발자가 구현한 로직이나 사용자의 영향으로 의한 문제

                3. 예외 종류
                    1) 일반 예외 : 컴파일(실행)될 때 예외 처리 코드 여부 검사 예외
                        - 입출력 , 네트워크 , 파일 , JBDC(자바-DB연동) , 주로 자바외부 통신 : Class.forName() , Thread.sleep()

                    2) 실행 예외 : 컴파일(실행)될 때 예외 처리 코드 여부 검사 하지 않는 예외 , 개발자의 의존도가 크다.
                        * 웹/앱 라이브러리/프레임워크( Spring )는 자동 예외처리

                4. 예외란
                    - 예외/오류 발생시 예외를 고치는게 아니라 **흐름 제어** vs if문이랑 비슷함.
                    - 프로그램을 24시간 중단 없이 실행하기 위한 안전한 로직 구현 <100%는 없음 --> 유지보수 >

                5. 예외 클래스
                    Exception : 모든 예외들의 상위 클래스 -> 어떤 예외인지 모를 때 한번에 처리도 가능함.
                        - ClassNotFoundException  : 클래스를 못찾았을 때 발생되는 정보를 저장하는 클래스
                        - InterruptedException    : 흐름이 중단 되었을 때 발생되는 정보를 저장하는 클래스
                        - NullPointerException    : 객체가 없는데 객체에 접근연산자 사용하면 발생 클래스
                        - NumberFormatException
                        - ArrayIndexOutOfBoundsException
                        - InputMismatchException
                        등등

                6. 사용법
                    try{ 예외가 발생할 것 같은 코드 또는 일반예외 }
                    catch( 예외클래스명 매개변수명 ){ 지정한 예외발생시 처리할 코드 }
                    catch( 예외클래스명 매개변수명 ){ 지정한 예외발생시 처리할 코드 }
                    catch( 예외클래스명 매개변수명 ){ 지정한 예외발생시 처리할 코드 }   // catch 여러개 사용 가능
                    finally{ 예외 여부 상관없이 무조건 실행되는 코드}
        */

        // ------------------------------ 예제 에서는 강제로 예외 발생하는 상황 ---------------------------

        // [1] 일반 예외 : 실행되기 전에 알려줌. --> 예외가 있던/없던 무조건 예외처리 해야한다.
        try { // 1. 일반예외 발생 코드를 try{}로 감싼다.
            Class.forName("java.lang.string");  // Class.forName( 클래스경로 ); ---> 해당 경로의 클래스를 읽어오는 함수
        }catch (ClassNotFoundException e ){ // 2. catch( 예외클래스명 매개변수명 ){ } 에서 예외발생시 처리할 코드
            System.out.println("[예외발생1] String 클래스가 없습니다.");
        }

        // [2] 일반 예외 , 예외발생
        try{
            Class.forName("java.lang.String2"); // String2 클래스는 존재하지 않아서 예외 발생한다.
        }catch (ClassNotFoundException e ){
            System.out.println("[예외발생2] String2 클래스가 없습니다. " + e );
            // [예외발생] String2 클래스가 없습니다. java.lang.ClassNotFoundException: java.lang.String2
        }

        // [3] 일반 예외
        try {
            Thread.sleep(1000); // 코드 실행을 1초간 일시정시 함수.
        }catch ( InterruptedException e ){
            System.out.println("[예외발생3] sleep 도중에 오류 발생");
        }

        // [4] 실행 예외 : 프로그램 실행 도중에 발생하는 예외 , <예측>
        // !! .NullPointerException : 객체가 없는데 객체에 접근연산자 사용하면 발생하는 예외
        try {
            String str1 = "강호동";
            System.out.println(str1.length());  // 3 "문자열".length() : 문자열 길이 반환 함수
            String str2 = null;                 // 자바에서 null 이란 : 변수가 참조(저장)하는 값/객체가 없다는 뜻
            System.out.println(str2);           // null
            System.out.println(str2.length());
        }catch (NullPointerException e ){
            System.out.println("[예외발생4] 객체가 없어서 .length 사용불가능");
        }
        // .(접근연산자)는 객체내 메소드 호출 --> 당연히 참조할 객체 null이라 참조 못하는데 빨간줄은 안뜸.
        // for문 돌릴때 많이 씀.

        // [5] 실행 예외 : NumberFormatException
        try {
            String str3 = "100";        // 문자 100 저장 , 100 숫자 o
            String str4 = "1aa";        // 문자 1aa 저장 , 1aa 숫자 x
            int int3 = Integer.parseInt(str3);
            // Integer.parseInt( );    --> static 메소드임. 객체 생성 없이 바로 사용가능.
            // 문자열 타입을  int  타입으로 변환하여 사용
            int int4 = Integer.parseInt(str4);
            // "100" --> 100 가능 , "1aa" --> 숫자가 될 수 없음.
        }catch (NumberFormatException e){
            System.out.println("[예외발생5] 정수로 반환 불가능하다." + e );
        }

        // [6] 실행 예외 : ArrayIndexOutOfBoundsException : 존재하지 않는 인덱스 호출 예외
        try {
            int[] intArray = {1, 2, 3};
            System.out.println(intArray[0]);  // 1 0번 인덱스
            System.out.println(intArray[4]);  // 4번 인덱스 존재하지 않음. 오류 발생
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("[예외발생6] 존재하지 않는 인덱스입니다." + e );
        }

        // [7] 실행 예외 : InputMismatchException : 입력 데이터 타입이 일치하지 않을 때 예외
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("정수 입력 : ");
            int value7 = scan.nextInt();
        }catch (InputMismatchException e ){
            System.out.println("[예외발생7] 숫자를 입력해주세요." + e);
        }

        // [8] 다중 catch 와 finally
        try {
            Integer.parseInt("1AA");            // 예외 발생시 아래코드는 실행되지 않고 catch 이동

            int[] intArray = {1, 2, 3};
            System.out.println(intArray[10]);  // 10번 인덱스 없음. 무조건 오류

            String str = null;
            System.out.println(str.length());  // 객체 비었음 이것도 무조건 오류
        }
        catch (NumberFormatException e1 ){ System.out.println(e1); }
        catch (ArrayIndexOutOfBoundsException e2){ System.out.println(e2); }
        catch (NullPointerException e3 ){ System.out.println(e3);}
        catch (Exception e4 ){ System.out.println(e4); }
        // - 주의할점1 : 다중 catch 시 먼저 발생한 예외부터 하나의 예외 발생하고 1개의 catch 만 실행된다.
        // - 주의할점2 : Exception 클래스는 모든 예외를 처리 하므로 다중 catch 시에는 맨 아래에서 정의한다.
        finally { System.out.println("예외가 있던 없던 무조건 실행코드"); }

    } // main e
} // class e


































