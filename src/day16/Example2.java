package day16;

public class Example2 {

    // (1) 예외가 발생하는 메소드 , 반환타입 메소드명() throws 예외클래스명 { }
    public static void method1() throws NullPointerException {
        String str = null;
        System.out.println(str.length());   // 100% 예외 발생 예측됨. 객체 없으니깐
        // * 예외 발생시 예외 던지기(throws)
    }

    // (2) 예외가 발생하는 메소드 
    // 일반 예외 클래스들은 주로 throws 예외 코드 존재한다.
    // 실행 예외 클래스들은 주로 throws 예외 코드 없다.
    public static void method2() throws ClassNotFoundException {
        Class.forName("com.sql.jdbc");      // 일반 예외 : 무조건 예외처리.. 예외 발생 할 것 같은 코드
    }

    public static void main(String[] args) {

        // [8] 예외던지기 : 예외 발생시 메소드를 호출한 곳으로 예외 전달/리턴
        // --> 한곳에서 예외처리 하기위해 메소드 내부에서 발생한 예외를 이동/전달/리턴 할 수 있다.
        try { method1();} // <---- 예외가 발생하는 메소드 호출
        catch (NullPointerException e ){ System.out.println("method1의 예외 발생");}

        try { method2();}  // <--- 예외가 발생하는 메소드 호출
        catch (ClassNotFoundException e ){ System.out.println("method2의 예외 발생"); }

    } // main e
} // class e
