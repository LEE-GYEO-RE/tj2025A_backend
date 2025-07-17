package day14;


class 상위클래스{
    int value1 = 10; int value2 = 20; // 멤버변수
    상위클래스(){ System.out.println("[상위클래스 인스턴스생성] "); } // 생성자
    void showValue(){ // 메소드
        System.out.println(">>상위클래스의 메소드 실행<<");
    } // func e
} // class e


class 하위클래스 extends 상위클래스 { // 클래스B extends 클래스A{ }
    int value3 = 30;    int value2 = 40;    // 멤버변수
    하위클래스(){ System.out.println("[하위클래스 인스턴스생성]");} // 생성자
    void showValue2(){ // 메소드
        System.out.println(">>하위클래스의 메소드 실행<<");
    } // func e

    void showValue(){ // 메소드2
        System.out.println(">>하위클래스의 메소드 실행<<");
    }

} // class  e


public class Example1 {
    public static void main(String[] args) {

        // (1) 상위클래스 객체 생성
        상위클래스 obj1 = new 상위클래스();
        obj1.showValue();
        // obj1.showValue2(); // 하위클래스의 멤버 접근불가

        // (2) 하위클래스 객체 생성
        하위클래스 obj2 = new 하위클래스();
        obj2.showValue(); // 현재타입
        obj2.showValue2(); // 상위타입 접근 가능

        // -----> 상위에서 하위 접근 불가 , 하위에서 상위 접근 가능 / 부모는 자식 접근 못함 , 자식은 부모 접근 가능

        // (3) 멤버변수명이 동일할때 구분 : 멤버변수는 객체마다 할당
        System.out.println(obj2.value1 );   // 상위클래스의 멤버변수 접근 가능 --> 10
        System.out.println(obj2.value3 );   // 현재클래스의 멤버변수 접근 가능 --> 30
        System.out.println(obj2.value2 );   // 상위타입/하위타입내 동일한 멤버변수명이 존재할때 현재 타입 우선 --> 40

        상위클래스 obj3 = obj2;               // 하위타입에서 상위타입으로 변환
        System.out.println(obj3.value2 );   // 동일한 멤버변수 호출 --> 20

        // (4) 메소드명이 동일할때 구분 : 오버라이딩
        // 메소드는 객체마다 할당이 아니고 메소드는 모든 객체들이 공유
        // 오버로딩 vs 오버라이딩
        // 오버라이딩 : 부모가 물려준 메소드를 자식이 재정의 한다.
        // 주의할점 : 메소드가 동일할 때 오버라이딩 메소드 최우선 실행
        obj2.showValue(); // obj2(하위타입) 일때 현재타입 메소드 실행
        obj3.showValue(); // obj3(상위타입) 일때 *태생*타입의 메소드 우선 실행

        상위클래스 obj4 = new 상위클래스();
        obj4.showValue(); // 이건 태생타입이 상위클래스인거임


    } // main e
} // class e
