package day07;

public class 실습8 {
    public static void main(String[] args) {
        // 문제 1
        Printer p1 = new Printer(); // 객체 생성
        p1.printMessage();          // 객체 내 메소드 호출

        // 문제 2
        Greeter g1 = new Greeter();
        g1.greet("이겨레");
        // "이겨레" : 인수/인자 값은 메소드의 매개변수 대입된다.
        // *** 인수/인자 값의 타입과 매개변수 타입은 일치 ***

        // 문제 3
        SimpleCalculator s1 = new SimpleCalculator();
        int result = s1.add(10 , 4);
        System.out.println(result);

        // 문제 4
        Checker c1 = new Checker();         // Checker 객체 생성
        boolean result2 = c1.isEven( 4 );   // 메소드 호출 하고 메소드 isEven 에 값 설정
        System.out.println(result2);

        // 문제 5
        Lamp l1 = new Lamp();   // 객체 생성
        l1.turnOn();            // 메소드 turnOn 호출
        l1.turnOff();           // 메소드 turnOff 호출

        // 문제 6
        Product mm = new Product();
        boolean result6 =mm.sell( 12 );
        System.out.println(result6);

        // 문제 7
        Visualizer v1 = new Visualizer();
        v1.getStar( 5 );

        // 문제 8
// [문제 8] ParkingLot 클래스를 만드세요.
//1. 주차 시간(분)을 매개변수로 받아, 요금 규정에 따라 계산된 최종 주차 요금을 반환하는 calculateFee 메소드를 정의하세요.
//2. 요금 규정:
//기본 요금: 최초 30분까지 1,000원
//추가 요금: 30분 초과 시, 매 10분마다 500원씩 추가
//일일 최대 요금: 20,000원
//3. main 함수에서 calculateFee 메소드에 65, 140을 각각 인자로 전달하여 반환된 요금을 출력하세요.


    }
}




//[JAVA] 실습8 : 클래스와 객체의메소드
//[ 문제 ] 아래 클래스와 메소드 관련 문제를 해결하시오.
//        [ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
//
//        [문제 1] Printer 클래스를 만드세요.
//1. "안녕하세요, 메소드입니다."라고 출력하는 printMessage 메소드를 정의하세요. (매개변수 X, 반환값 X)
//2. main 함수에서 Printer 객체를 생성하고, printMessage 메소드를 호출하세요.
//
//          [문제 2] Greeter 클래스를 만드세요.
//1. 문자열(이름) 하나를 매개변수로 받아, "안녕하세요, [이름]님!"이라고 출력하는 greet 메소드를 정의하세요. (매개변수 O, 반환값 X)
//2. main 함수에서 Greeter 객체를 생성하고, 자신의 이름을 인자로 전달하여 greet 메소드를 호출하세요.
//
//          [문제 3] SimpleCalculator 클래스를 만드세요.
//1. 정수 두 개를 매개변수로 받아, 두 수의 합을 반환하는 add 메소드를 정의하세요. (매개변수 O, 반환값 O)
//2. main 함수에서 SimpleCalculator 객체를 생성하고, add 메소드를 호출하여 반환된 결과를 변수에 저장한 뒤, 그 변수를 출력하세요.
//
//        [문제 4] Checker 클래스를 만드세요.
//1. 정수 하나를 매개변수로 받아, 그 수가 짝수이면 true, 홀수이면 false를 반환하는 isEven 메소드를 정의하세요.
//2. main 함수에서 isEven 메소드를 호출하고, 반환된 값에 따라 "짝수입니다." 또는 "홀수입니다."를 출력하세요.
//
//        [문제 5] Lamp 클래스를 만드세요. isOn (boolean) 멤버 변수를 가집니다.
//1. turnOn 메소드를 호출하면 isOn이 true가 되고, turnOff 메소드를 호출하면 false가 되도록 두 메소드를 정의하세요.
//2. main 함수에서 Lamp 객체를 생성하고, turnOn과 turnOff를 차례로 호출하며 각 단계에서 램프의 상태(isOn 값)를 출력하여 확인하세요.
//
//        [문제 6] Product 클래스를 만드세요. name(문자열)과 stock(정수) 멤버 변수를 가집니다.
//1. Product 클래스 안에, 구매 수량을 매개변수로 받아 재고를 차감하는 sell 메소드를 정의하세요.
// 이 메소드는 재고가 충분하면 재고를 줄이고 true를, 부족하면 "재고 부족" 메시지를 출력하고 false를 반환합니다.
//2. main 함수에서 Product 객체를 생성하고 초기 재고를 10으로 설정한 뒤, sell 메소드를 호출하여 구매를 시도하고 결과를 확인하세요.
//
//          [문제 7] Visualizer 클래스를 만드세요.
//1. 정수 하나를 매개변수로 받아, 그 숫자만큼 "★" 문자를 반복하여 하나의 문자열로 만들어 반환하는 getStars 메소드를 정의하세요.
//2. main 함수에서 getStars(5)를 호출하여 반환된 문자열 "★★★★★"를 출력하세요.
//
//        [문제 8] ParkingLot 클래스를 만드세요.
//1. 주차 시간(분)을 매개변수로 받아, 요금 규정에 따라 계산된 최종 주차 요금을 반환하는 calculateFee 메소드를 정의하세요.
//2. 요금 규정:
//기본 요금: 최초 30분까지 1,000원
//추가 요금: 30분 초과 시, 매 10분마다 500원씩 추가
//일일 최대 요금: 20,000원
//3. main 함수에서 calculateFee 메소드에 65, 140을 각각 인자로 전달하여 반환된 요금을 출력하세요.