package day14.실습12;

// 문제 1
class Person{
    String name; // name 멤버변수
}

class Student extends Person{
    int studentId; // studentId 멤버변수
}

// 문제 2

class Animal{
    void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    } // func e
} // class e

class Cat extends Animal{
    void makeSound(){
        System.out.println("고양이가 야옹하고 웁니다.");
    }
} // class e

// 문제 3

class Machine{
    Machine(){
        System.out.println("부모 클래스 생성자 실행");
    }
} // class e

class Computer extends Machine{
    Computer(){
        System.out.println("자식 클래스 생성자 실행");
    }
}

// 문제 4
class Figure{
    void draw(){
        System.out.println("도형 그리기");
    }
}
class Triangle extends Figure{
    void draw(){
        System.out.println("삼각형 그리기");
    }
}

// 문제 5
class Shape{
    void draw1(){
        System.out.println("도형 그립니다잉");
    }
}
class Circle extends Shape{
    void draw1(){
        System.out.println("원 그립니다잉");
    }
}
// 문제 6
class Vehicle{

}
class Bus extends Vehicle{
    void checkFare(){
        System.out.println("요금을 확인합니다.");
    }
}

// 문제 7
class Beverage{
    void drink(){
        System.out.println("음료를 마십니다.");
    }
}
class Coke extends Beverage{
    void drink(){
        System.out.println("콜라를 마십니다.");
    }
}
class Coffee extends Beverage{
    void drink(){
        System.out.println("커피를 마십니다.");
    }
}

// 문제 8
class Weapon{
    void attack(){
        System.out.println("무기로 공격합니다.");
    }
}
class Sword extends Weapon{
    void attack(){
        System.out.println("검으로 공격합니다.");
    }
}
class Gun extends Weapon{
    void attack(){
        System.out.println("총으로 공격합니다.");
    }
}
class Character{
    void use(Weapon weapon){
        weapon.attack();
    }
}

// 문제 9
class SuperClass{
    String name = "상위";
    void method(){
        System.out.println("상위 메소드 출력");
    }
}
class SubClass extends SuperClass{
    String name = "하위";
    void method(){
        System.out.println("하위 메소드 출력");
    }
}


public class 실습12 {
    public static void main(String[] args) {

        // 문제 1
        Student student = new Student();     // student 객체 생성
        student.name = "이겨레";              // 상속받은 name에 값 저장
        student.studentId = 2025;            // 자신의 studentId에 값 저장
        System.out.println(student.name);       // 출력
        System.out.println(student.studentId);  // 출력

        // 문제 2
        Cat cat = new Cat();    // cat 객체 생성
        cat.makeSound();        // 콘솔에 출력하는 함수(makeSound) 호출

        // 문제 3
        Computer computer = new Computer();
        // 부모 클래스 , 자식 클래스 순으로 호출됨.

        // 문제 4
        Figure figure = new Triangle(); // Triangle 객체를 Figure 타입 변수에 저장 (업캐스팅)
        // 원래는 객체 생성할 때 , 타입을 일치시켜야함 .
        // Figure f = new Figure(); 이렇게 아니면 Triangle t = new Triangle(); 이런식으로
        // 하지만 여기서는 Triangle 객체를 Figure 타입으로 선언하고 저장했음.
        // 이게 가능한 이유 ? Triangle 이 Figure 를 상속했기 때문에 부모의 타입을 참조 가능해서임


        // 문제 5
        Shape shape = new Circle();     // Circle 객체를 Shape 타입 변수에 저장 (업캐스팅)
        shape.draw1();                  // 원 그리기 출력
        // 4번에서 이어지게 shape.draw1()은 실제로 Circle의 draw1()을 불러오는 것.
        // draw1() 메소드가 오버라이딩 되어있으면 실제 객체 기준으로 메소드 실행됨.

        // 문제 6
        Vehicle vehicle = new Bus();    // 업캐스팅
        if( vehicle instanceof Bus){
            Bus bus = (Bus) vehicle;    // 다운캐스팅
            bus.checkFare();            // 자식클래스의 메소드 호출
        } // if e

        // 업캐스팅 : 하위 클래스 (자식) 의 객체를 상위 클래스 (부모) 타입으로 저장하는 것.
        // 부모 타입 상속하므로 타입도 자동 변환 가능 , (Vdhicle) bus 이런거 안해도됨.
        // 다운 캐스팅 : 상위 클래스 타입의 참조를 다시 하위 클래스 타입으로 (강제로!!)변환하는 것.
        // 다운 캐스팅 목적
            // 1. 자식 클래스에만 있는 멤버 , 메소드 쓰기 위해서
                // 다형성 활용하기 위해서, 상위 클래스 타입으로 하위 객체들 저장하고
                // 필요할 때만 각 객체의 고유 기능을 다운캐스팅해서 사용하는 구조.
        // 다운 캐스팅 할때는 instanceof 해서 꼭 확인하고 써야 오류 안남.
        // 부모 클래스에서 메소드 선언하면 오버라이딩 되면서 타입변환 안해도 되긴함. 여기서는 메소드 없어서 쓰려면 다운캐스팅 필요.


        // 문제 7
        Beverage[] d = {new Coke() , new Coffee() }; // 배열 생성 후 , 그 안에 객체들 저장
        for( Beverage d1 : d ){                     // 반복문 돌려서 요소 꺼냄
            d1.drink();                             // Coke , Coffee 객체의 메소드 출력
        } // for e

        // 문제 8
        //[문제 8] 다형성을 활용한 매개변수
//1. Weapon 클래스와 이를 상속받는 Sword, Gun 클래스를 만드세요.
// 각 클래스는 "무기로 공격합니다.", "검으로 공격합니다.", "총으로 공격합니다."를 출력하는 attack() 메소드를 가집니다. (오버라이딩 활용)
//2. Weapon 타입의 매개변수를 받아 그 객체의 attack() 메소드를 호출하는 Character 클래스와 use(Weapon weapon) 메소드를 만드세요.
//3. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤, 이 객체들을 Character의 use() 메소드에 인자로 전달하여 각기 다른 결과가 출력되는 것을 확인하세요.

        Sword sword = new Sword();
        Gun gun = new Gun();
        Character character = new Character();
        character.use( sword );
        character.use( gun );

        // 문제 9
        //[문제 9] 필드와 메소드의 오버라이딩 차이
//1. String name = "상위"; 필드와 method() 메소드("상위 메소드" 출력)를 가진 SuperClass를 만드세요.
//2. SuperClass를 상속받고, String name = "하위"; 필드와 method() 메소드("하위 메소드" 출력)를 가진 SubClass를 만드세요.
//3. SuperClass obj = new SubClass(); 로 객체를 생성한 뒤, obj.name과 obj.method()를 각각 호출했을 때의 결과를 확인하고,
// 왜 다른 결과가 나오는지 주석으로 설명하세요.
        SuperClass obj = new SubClass();
        System.out.println(obj.name);
        obj.method();
        // 메소드는 실제 객체 타입 기준이고 , 다형성이 적용됨. 그래서 호출 시 하위 클래스 메소드가 출력됨
        // 변수(필드 , 여기서는 name)는 참조 변수 타입 기준이됨 . 다형성이 적용 안됨.
        // 또한 변수는 컴파일 타임에 '타입'만 보고 결정됨 오버라이딩이 아니라 '숨김' 처리 됨
        // ----> 컴파일러에서 obj가 SuperClass 타입이여서 SuperClass.name 을 고정으로 사용함.

        // 문제 10
        //[문제 10] 다중 상속 관계
//1. Device 클래스를 만드세요.
//2. Device를 상속받는 Electronic 클래스를 만드세요.
//3. Electronic을 상속받는 Laptop 클래스를 만드세요.
//4. main 함수에서 Laptop 객체를 생성한 뒤,
// 이 객체가 Electronic 타입과 Device 타입으로도 형 변환이 가능한지 instanceof 연산자로 확인하고 결과를 출력하세요.



    } // main e
} // class e

//[JAVA] 실습12 : 클래스의 상속
//[ 문제 ] 아래 클래스 상속 관련 문제를 해결하시오.
//[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
//
//[문제 1] 기본 상속
//1. name(문자열) 멤버 변수를 가진 Person 클래스를 만드세요.
//2. Person 클래스를 상속받는 Student 클래스를 만드세요. Student 클래스에는 studentId(정수) 멤버 변수를 추가하세요.
//3. main 함수에서 Student 객체를 생성하고, 상속받은 name과 자신의 studentId에 값을 저장한 뒤 모두 출력하세요.
//
//[문제 2] 메소드 오버라이딩 (Method Overriding)
//1. "동물이 소리를 냅니다."를 출력하는 makeSound() 메소드를 가진 Animal 클래스를 만드세요.
//2. Animal을 상속받고, makeSound() 메소드를 재정의하여 "고양이가 야옹하고 웁니다."를 출력하는 Cat 클래스를 만드세요.
//3. main 함수에서 Cat 객체를 생성하고 makeSound() 메소드를 호출하여, 재정의된 내용이 출력되는지 확인하세요.
//
//[문제 3] 생성자 호출 순서
//1. 생성자에서 "부모 클래스 생성자 실행"을 출력하는 Machine 클래스를 만드세요.
//2. Machine을 상속받고, 생성자에서 "자식 클래스 생성자 실행"을 출력하는 Computer 클래스를 만드세요.
//3. main 함수에서 Computer 객체를 생성할 때, 콘솔에 출력되는 생성자 호출 순서를 확인하세요.
//
//[문제 4] 다형성: 자동 타입 변환 (Upcasting)
//1. Figure 클래스를 만드세요.
//2. Figure를 상속받는 Triangle 클래스를 만드세요.
//3. main 함수에서 Triangle 객체를 생성하여 Figure 타입의 변수에 저장하는 코드를 작성하고, 이것이 가능한 이유를 주석으로 설명하세요.
//
//[문제 5] 다형성과 오버라이딩
//1."도형을 그립니다."를 출력하는 draw() 메소드를 가진 Shape 클래스를 만드세요.
//2.Shape을 상속받고, draw() 메소드를 재정의하여 "원을 그립니다."를 출력하는 Circle 클래스를 만드세요.
//3.main 함수에서 Shape shape = new Circle(); 코드를 작성한 뒤, shape.draw()를 호출했을 때 어떤 결과가 나오는지 확인하고 그 이유를 주석으로 설명하세요.
//
//[문제 6] instanceof와 강제 타입 변환 (Downcasting)
//1. Vehicle 클래스와 이를 상속받는 Bus 클래스를 만드세요. Bus 클래스에만 checkFare() 메소드("요금을 확인합니다.")를 추가하세요.
//2. main 함수에서 Vehicle vehicle = new Bus(); 코드를 작성하세요.
//3. if문과 instanceof 연산자를 사용하여 vehicle 변수가 Bus 타입인지 확인하세요.
//4. 만약 Bus 타입이 맞다면, Bus 타입으로 강제 변환한 뒤 checkFare() 메소드를 호출하세요.
//
//[문제 7] 다형성을 활용한 객체 배열
//1. "음료를 마십니다."를 출력하는 drink() 메소드를 가진 Beverage 클래스를 만드세요.
//2. Beverage를 상속받는 Coke와 Coffee 클래스를 만들고,
// 각 클래스에서 drink() 메소드를 오버라이딩하여 "콜라를 마십니다.", "커피를 마십니다."를 출력하도록 하세요.
//3. main 함수에서 Beverage 타입의 배열을 생성하고, 그 안에 Coke 객체와 Coffee 객체를 저장하세요.
//4. 반복문을 사용하여 배열의 모든 요소를 꺼내 drink() 메소드를 호출하고, 각기 다른 결과가 출력되는 것을 확인하세요.
//
//[문제 8] 다형성을 활용한 매개변수
//1. Weapon 클래스와 이를 상속받는 Sword, Gun 클래스를 만드세요.
// 각 클래스는 "무기로 공격합니다.", "검으로 공격합니다.", "총으로 공격합니다."를 출력하는 attack() 메소드를 가집니다. (오버라이딩 활용)
//2. Weapon 타입의 매개변수를 받아 그 객체의 attack() 메소드를 호출하는 Character 클래스와 use(Weapon weapon) 메소드를 만드세요.
//3. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤, 이 객체들을 Character의 use() 메소드에 인자로 전달하여 각기 다른 결과가 출력되는 것을 확인하세요.
//
//[문제 9] 필드와 메소드의 오버라이딩 차이
//1. String name = "상위"; 필드와 method() 메소드("상위 메소드" 출력)를 가진 SuperClass를 만드세요.
//2. SuperClass를 상속받고, String name = "하위"; 필드와 method() 메소드("하위 메소드" 출력)를 가진 SubClass를 만드세요.
//3. SuperClass obj = new SubClass(); 로 객체를 생성한 뒤, obj.name과 obj.method()를 각각 호출했을 때의 결과를 확인하고,
// 왜 다른 결과가 나오는지 주석으로 설명하세요.
//
//[문제 10] 다중 상속 관계
//1. Device 클래스를 만드세요.
//2. Device를 상속받는 Electronic 클래스를 만드세요.
//3. Electronic을 상속받는 Laptop 클래스를 만드세요.
//4. main 함수에서 Laptop 객체를 생성한 뒤,
// 이 객체가 Electronic 타입과 Device 타입으로도 형 변환이 가능한지 instanceof 연산자로 확인하고 결과를 출력하세요.