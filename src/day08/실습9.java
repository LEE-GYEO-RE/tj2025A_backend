package day08;

public class 실습9 { // class s
    public static void main(String[] args) { // main s
        // 문제 1

        Book b1 = new Book("이것이 자바다" , "신용권" , 30000 );
        Book b2 = new Book("자바의 정석" , "남궁성" , 28000);
        System.out.printf("%s \t %s \t %d \n" , b1.title , b1.author ,b1.price);
        System.out.printf("%s \t %s \t %d \n" , b2.title , b2.author ,b2.price);

         // 문제 2

        Pet p1 = new Pet("초코", "푸들", 3);
        Pet p2 = new Pet("나비", "코리안숏헤어", 5);
        System.out.printf("%s \t %s \t %d \n" , p1.name , p1.species ,p1.age );
        System.out.printf("%s \t %s \t %d \n" , p2.name , p2.species ,p2.age );

        // 문제 3

        Rectangle r1 = new Rectangle( 10 , 5);
        int result = r1.getArea( );
        System.out.printf("사각형의 넓이 : [%d]\n" , result );

        // 문제 4

        BankAccount bank1 = new BankAccount("111-222-3333", "유재석", 10000);
        int result1 = bank1.deposit(5000);      // 누적값이 나오게ㅐ 해야함 += ~~;
        int result2 = bank1.withdraw(3000);     // 누적값이 나오게 해야함 -= ~~;
        System.out.println("최종 잔액 : " + result2);

        // 문제 5

        Goods drink = new Goods();
        Goods drink1 = new Goods("콜라", 2000);

        System.out.printf("%s \t %d\n " , drink.name , drink.price );
        System.out.printf("%s \t %d\n " , drink1.name , drink1.price);

        // 문제 6

        Member m1 = new Member();
        System.out.printf("%s \t %s \n" , m1.id , m1.isLogin);

        // 문제 7

        Television t1 = new Television( 7, 20);
        System.out.printf("채널 : %d \t , 볼륨 : %d\n" , t1.channel , t1.volume);


        // 문제 8
        //[문제 8]
//2. main 함수에서 이 생성자를 사용하여,
// ("손흥민", 90, 95) 정보를 가진 객체와 ("이강인", 85, 92) 정보를 가진 객체를 생성하세요.
//3. 두 객체의 정보를 각각 출력하여 확인하세요.

        Player u1 = new Player("손흥민", 90, 95 );
        Player u2 = new Player("이강인", 85, 92 );
        System.out.printf("이름 : %s \t , 파워 : %d \t , 스피드 : %d \n" , u1.name , u1.power , u1.speed);
        System.out.printf("이름 : %s \t , 파워 : %d \t , 스피드 : %d \n" , u2.name , u2.power , u2.speed);



















    } // main e
} // class e
//[JAVA] 실습9 : 클래스와 객체의생성자
//[ 문제 ] 아래 클래스와 생성자 관련 핵심 문제를 해결하시오.
//[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
//
//[문제 1] Book 클래스를 만드세요. (title, author, price 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. Book 클래스에 title, author, price를 매개변수로 받아 멤버 변수를 초기화하는 생성자를 만드세요.
//2. main 함수에서 이 생성자를 사용하여, ("이것이 자바다", "신용권", 30000) 정보와 ("자바의 정석", "남궁성", 28000) 정보를 가진 Book 객체 2개를 생성하고, 각 객체의 정보를 출력하세요.
//
//[문제 2] Pet 클래스를 만드세요. (name, species, age 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. Pet 클래스에 name, species, age를 매개변수로 받아 초기화하는 생성자를 만드세요.
//2. main 함수에서 이 생성자를 사용하여, ("초코", "푸들", 3) 정보와 ("나비", "코리안숏헤어", 5) 정보를 가진 Pet 객체 2개를 생성하고, 각 객체의 프로필을 출력하세요.
//
//[문제 3] Rectangle 클래스를 만드세요. (width, height 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. width와 height를 매개변수로 받아 초기화하는 생성자를 만드세요.
//2. 사각형의 넓이(width * height)를 계산하여 반환하는 getArea() 메소드를 만드세요.
//3. main 함수에서 (10, 5) 값을 가진 Rectangle 객체를 생성하고, getArea() 메소드를 호출하여 "사각형의 넓이: [넓이]"를 출력하세요.
//
//[문제 4] BankAccount 클래스를 만드세요. (accountNumber, ownerName, balance 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. 세 멤버 변수를 모두 초기화하는 생성자를 만드세요.
//2. 입금(deposit)과 출금(withdraw) 기능을 하는 메소드를 각각 만드세요.
//3. main 함수에서 ("111-222-3333", "유재석", 10000) 정보로 객체를 생성한 뒤, 5000원을 입금하고 3000원을 출금한 후의 최종 잔액을 출력하세요.
//
//[문제 5] Goods 클래스를 만드세요. (name, price 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. Goods 클래스에 생성자를 두 개 만드세요(오버로딩).
//2. 기본 생성자: name은 "미정", price는 0으로 초기화
//3. 매개변수가 있는 생성자: name과 price를 매개변수로 받아 초기화
//4. main 함수에서 기본 생성자로 객체 하나, 매개변수가 있는 생성자로 ("콜라", 2000) 정보를 가진 객체 하나를 각각 생성하고, 두 객체의 정보를 모두 출력하세요.
//
//[문제 6] Member 클래스를 만드세요. (id, isLogin 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. Member 클래스에 기본 생성자를 만들고, 이 생성자 안에서 id는 "guest", isLogin은 false로 초기화되도록 하세요.
//2. main 함수에서 new Member()로 객체를 생성하고, 초기화된 id와 isLogin 값을 출력하여 확인하세요.
//
//[문제 7] Television 클래스를 만드세요. (channel, volume 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. channel과 volume을 매개변수로 받아 초기화하는 생성자를 만드세요.
//2. main 함수에서 (채널 7, 볼륨 20) 상태를 가진 Television 객체를 생성하고, 해당 객체의 정보를 출력하세요.
//
//[문제 8] Player 클래스를 만드세요. (name, power, speed 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. 세 멤버 변수를 모두 초기화하는 생성자를 만드세요.
//2. main 함수에서 이 생성자를 사용하여, ("손흥민", 90, 95) 정보를 가진 객체와 ("이강인", 85, 92) 정보를 가진 객체를 생성하세요.
//3. 두 객체의 정보를 각각 출력하여 확인하세요.
//
//[문제 9] MenuItem 클래스를 만드세요. (name, price, isSignature 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. 세 멤버 변수를 모두 초기화하는 생성자를 만드세요.
//2. main 함수에서 이 생성자를 사용하여 "김치찌개", 8000, true 정보를 가진 객체를 생성하고, isSignature가 true인지 확인한 후 "[대표메뉴] 김치찌개 : 8000원" 형식으로 출력하세요.
//
//[문제 10] UserProfile 클래스를 만드세요. (name, age, mbti 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
//1. 세 멤버 변수를 모두 초기화하는 생성자를 만드세요.
//2. Scanner를 사용하여 사용자로부터 이름, 나이, MBTI를 입력받으세요.
//3. 입력받은 값들을 사용하여 UserProfile 객체를 생성하고, 저장된 모든 정보를 출력하세요.