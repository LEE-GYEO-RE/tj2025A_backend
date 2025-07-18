package day15;

// * extends 는 하나의 클래스 vs implements 여러개의 인터페이스
interface Buy{

    // 상수~!

    void buy(); // - 추상 메소드 public abstract << 생략 가능 ***** 추상메소드 *****

    // + 디폴트 메소드 : 인터페이스 타입에서 구현한 메소드 사용가능.
    public default void method1(){ }

    // + 정적 메소드 : 인터페이스 타입에서 정적 구현 메소드
    public static  void  method2(){ }

    // + private 메소드 : 현재 인터페이스타입 에서만 사용가능한 구현 메소드
    private void method3(){ }

    // + private static 메소드 : 현재 인터페이스타입 에서만 정적 구현 메소드
    private static void method4(){}


}
interface Sell{ void sell(); }
class  Customer extends Object implements Buy , Sell{
    // extends : 클래스 1개당 상속은 1개의 클래스만 가능 , 다형성 표현에 제약이 생김
    // implements : 클래스 1개당 구현은 여러개의 인터페이스 가능 , 포괄적인 다형성

    // * 각기 다른 인터페이스들의 추상메소드 재정의/구현 (오버라이딩) 하기
    public void buy() { System.out.println("[판매]");}
    public void sell() { System.out.println("[구매]");}

} // class e


public class Example2 {
    public static void main(String[] args) {

        // [1]
        Buy buy = new Customer();
        // [2]
        buy.buy();
        // buy.sell(); 불가능 : 오버라이딩 안되있음

        // [3] 디폴트 메소드
        buy.method1();

        // [4] 정적(객체없이) 메소드
        Buy.method2();

        // [5] private 메소드 ? 구현체에서 구현하지 않음
        // private 메소드는 오버라이딩 금지 ,

        // [6] private 정적 메소드
        // 타입 내부적으로 사용되는 정적 메소드


    } // main e
} // class e
