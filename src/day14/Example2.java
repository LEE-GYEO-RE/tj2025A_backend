package day14;

class Car{ // 자동차
    Tire tire;
    void run(){ this.tire.roll();}
}

class Tire{ // 타이어
    void roll(){
        System.out.println("[일반] 타이어가 회전");
    }
}

// 일반타이어로부터 상속받아 한국타이어에서 roll 메소드 재정의
class HankookTire extends Tire{
    void roll(){
        System.out.println("[한국] 타이어가 회전(업그레이드) ");
    }
}

// 일반타이어로부터 상속받아 금호타이어에서 roll 메소드 재정의
class KumhoTire extends Tire{
    void roll(){
        System.out.println("[금호] 타이어가 회전(업그레이드)");
    }
}


public class Example2 {
    public static void main(String[] args) {

        // (1) Car 객체 생성
        Car myCar = new Car();
        // myCar.run(); // 멤버변수(tire)가 null 이라 오류
        myCar.tire = new Tire();    // 멤버변수에 tire 객체 대입
        myCar.run();    // 이제는 null 아니기 때문에 일반 타이어 회전 출력

        // (2) 타이어 교체
        myCar.tire = new HankookTire(); // 멤버변수에 한국타이어 객체 대입
        myCar.run(); // 한국타이어 회전 출력

        // (3) 타이어 교체
        myCar.tire = new KumhoTire(); // 멤버변수에 금호타이어 객체 대입
        myCar.run(); // 금호타이어 회전 출력

        // !! : Tire 타입의 멤버변수는 Tire 객체, Htire 객체 ,Ktire 객체를 모두 대입 받을 수 있다!!
        // 이유 : 상속받아서 자동타입변환됨. 뭘 상속받음? ----> extends 하면 모든 거 물려줌. 재정의하려면 void로 바꾸면됨.
        // ex) 리모콘 , 닌텐도 등등 하나의 버튼으로 클래스 바꾸면서 다양한 기능 생성 가능


        System.out.println( myCar.tire instanceof Tire);  // instanceof : 타입 확인 : true
        System.out.println( myCar.tire instanceof KumhoTire); // true
        System.out.println( myCar.tire instanceof HankookTire ); // false
        // 이유 : KumhoTire 객체가 생성될때 : KumhoTire 객체 , Tire 객체 생성
        // 하위타입의 객체를 생성하면 상위타입의 객체도 생성된다.
        // 즉] KumhoTire 객체가 생성될때 HankookTire 객체는 생성되지 않는다. --> 형제관계라서

    } // main e
} // class e
