package day14;

public interface TestInterface {
    // [3] 멤버변수 ***불가능***
    // int value1;

    // [4] 생성자  ***불가능***
    // TestInterface(){ }

    // [5] 메소드 ***불가능***
    // void method1(){}

    // [6] 상수 , 초기값 넣으면 상수.
    // 주의할점 : 상수는 무조건 초기값이 있어야 한다.
    public static final int value2 = 10; // 원래는 public static final 인데 생략가능
    int value3 = 20; // 얘도 상수 , 키워드는 생략

    // [7] 추상메소드 : 선언부만 선언하고 메소드에 실행문 {}가 없는 메소드
        // 추상 뜻 : 공통성과 본질을 착안하여 추출해서 파악
    // abstract 반환타입 메소드();
    // 실행문{}은 각 클래스가 구현(오버라이딩)
    abstract void method2();
    boolean method3(int a );             // 추상메소드 키워드 생략
}
