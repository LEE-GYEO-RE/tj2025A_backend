package day06;
        class Book{
            String title;   // 멤버변수
            String author;
            int price;
        } // Book class end

        public class 실습7 { // class s
            public static void main(String[] args) { // main s
                // 문제 1 (실무에서 비권장 . 파일에 class 많으면 관리가 힘듬)
                // * 자바에서 객체 생성하기 위해서는 *클래스*가 필요하다.

                // 1) .java (실습7) 파일내 여러개 클래스 선언
                // class Book{ }

                // 2) 객체를 생성하고 ,  new 클래스명();에 변수를 저장.
                Book b1 = new Book();
                b1.title = "이것이 자바다.";
                b1.author = "신용권";
                b1.price = 30000;

                Book b2 = new Book();
                b2.title = "자바의 정석";
                b2.author = "남궁성";
                b2.price = 28000;

                // 3) 두 객체의 모든 정보 각각 출력
                System.out.println(b1.title + "\t" + b1.author + "\t" + b1.price + "\t");
                System.out.println(b2.title + "\t" + b2.author + "\t" + b2.price + "\t");

                // 문제 2
                Pet p1 = new Pet();
                p1.name = "초코";
                p1.species = "푸들";
                p1.age = 3;

                Pet p2 = new Pet();
                p2.name = "나비";
                p2.species = "코리안숏헤어";
                p2.age = 5;

                System.out.printf("이름 : %s , 종류 : %s , 나이 : %d살 \n" , p1.name , p1.species , p1.age);
                System.out.printf("이름 : %s , 종류 : %s , 나이 : %d살 \n" , p2.name , p2.species , p2.age);

                // 문제 3
                Rectangle wh = new Rectangle();
                wh.width = 10;
                wh.height = 5;
                System.out.printf( "사각형의 넓이 : %d \n" , wh.width * wh.height );

                // 문제 4
                BankAccount a = new BankAccount();
                a.accountNumber = "111-222-3333";
                a.ownerName = "유재석";
                a.balance = 10000;
                a.balance += 5000;
                System.out.printf("입금 후 잔액 : %d \n" , a.balance );
                a.balance -= 3000;
                System.out.printf("출금 후 잔액 : %d \n" , a.balance );

                // 문제 5
                Product n1 = new Product();
                n1.name = "새우깡";
                n1.price = 1500;

                Product n2 = new Product();
                n2.name = "콜라";
                n2.price = 2000;

                if( n1.price > n2.price){
                    System.out.println(n1.name);
                }
                else{
                    System.out.println(n2.name);
                }

                // 문제 6
                Member u = new Member();
                u.id = "admin";
                u.isLogin = false;
                System.out.println("로그인 전 상태 : " + u.isLogin);
                u.isLogin = true;
                System.out.printf("로그인 후 상태 : [%s]\n" , u.isLogin);

                // 문제 7
                Television t = new Television();
                t.channel = 7;
                t.volume = 20;


            } // main e
        } // class e


//[문제 1] Book 클래스를 만드세요. 이 클래스는 title(문자열), author(문자열), price(정수) 멤버 변수를 가집니다.
//1. main 함수에서 Book 객체 2개를 생성하세요.
//2. 첫 번째 객체에는 "이것이 자바다", "신용권", 30000을, 두 번째 객체에는 "자바의 정석", "남궁성", 28000을 각각 저장하세요.
//3. 두 객체의 모든 정보를 각각 출력하세요.
//
//[문제 2] Pet 클래스를 만드세요. name(문자열), species(문자열, 품종), age(정수) 멤버 변수를 가집니다.
//1. main 함수에서 Pet 객체 2개를 생성하세요.
//2. 첫 번째 객체에는 "초코", "푸들", 3을, 두 번째 객체에는 "나비", "코리안숏헤어", 5를 각각 저장하세요.
//3. "이름: [이름], 종류: [품종], 나이: [나이]살" 형식으로 각 반려동물의 프로필을 출력하세요.
//
//[문제 3] Rectangle 클래스를 만드세요. width(정수)와 height(정수) 멤버 변수를 가집니다.
//1. main 함수에서 Rectangle 객체를 하나 생성하고, width에 10, height에 5를 저장하세요.
//2. 해당 객체의 width와 height 값을 곱하여 "사각형의 넓이: [넓이]"를 출력하세요.
//
//[문제 4] BankAccount 클래스를 만드세요. accountNumber(문자열), ownerName(문자열), balance(정수, 잔액) 멤버 변수를 가집니다.
//1. main 함수에서 BankAccount 객체를 하나 생성하고, 계좌번호는 "111-222-3333", 예금주는 "유재석", 초기 잔액은 10000으로 저장하세요.
//2. balance에 5000을 더하여 입금 상황을 구현하고, "입금 후 잔액: [잔액]"을 출력하세요.
//3. 다시 balance에서 3000을 빼서 출금 상황을 구현하고, "출금 후 잔액: [잔액]"을 출력하세요.
//
//[문제 5] Product 클래스를 만드세요. name(문자열)과 price(정수) 멤버 변수를 가집니다.
//1. main 함수에서 Product 객체 2개를 생성하고, 각각 "새우깡", 1500과 "콜라", 2000 정보를 저장하세요.
//2. if문을 사용하여 두 객체의 price를 비교하고, 더 비싼 상품의 이름을 출력하세요.
//
//[문제 6] Member 클래스를 만드세요. id(문자열)와 isLogin(boolean) 멤버 변수를 가집니다.
//1. main 함수에서 Member 객체를 하나 생성하고, 아이디는 "admin", isLogin은 false로 초기화하세요.
//2. "로그인 전 상태: [isLogin 값]"을 출력하세요.
//3. 객체의 isLogin 값을 true로 변경하여 로그인 상황을 구현하세요.
//4. "로그인 후 상태: [isLogin 값]"을 출력하세요.
//
//[문제 7] Television 클래스를 만드세요. channel(정수)과 volume(정수) 멤버 변수를 가집니다.
//1. main 함수에서 Television 객체를 생성하고, channel은 7, volume은 20으로 초기화하세요.
//2. 객체의 channel 값을 11로 변경하고, volume 값은 2 감소시킨 뒤, 변경된 채널과 볼륨을 출력하세요.
//
//[문제 8] Player 클래스를 만드세요. name(문자열), power(정수), speed(정수) 멤버 변수를 가집니다.
//1. main 함수에서 Player 객체 2개를 생성하세요.
//2. 첫 번째 객체에는 "손흥민", 90, 95를, 두 번째 객체에는 "이강인", 85, 92를 각각 저장하세요.
//3. 두 객체의 power와 speed의 합을 각각 계산하고, 합이 더 높은 선수의 이름을 출력하세요.
//
//[문제 9] MenuItem 클래스를 만드세요. name(문자열), price(정수), isSignature(boolean, 대표메뉴 여부) 멤버 변수를 가집니다.
//1. main 함수에서 MenuItem 객체 3개를 생성하고, 첫 번째는 "김치찌개", 8000, true, 두 번째는 "된장찌개", 8000, false, 세 번째는 "계란찜", 3000, false로 저장하세요.
//2. if문을 사용하여 isSignature가 true인 메뉴 객체를 찾아, "[대표메뉴] [메뉴이름] : [가격]원" 형식으로 출력하세요.
//
//[문제 10] UserProfile 클래스를 만드세요. name(문자열), age(정수), mbti(문자열) 멤버 변수를 가집니다.
//1. main 함수에서 UserProfile 객체를 하나 생성하세요.
//2. Scanner를 사용하여 사용자로부터 이름, 나이, MBTI를 순서대로 입력받으세요.
//3. 입력받은 값들을 생성된 객체의 각 멤버 변수에 저장하세요.
//3. 모든 정보가 저장된 객체의 멤버 변수들을 가져와 "--- 프로필 ---", "이름: [이름]", "나이: [나이]", "MBTI: [MBTI]" 형식으로 출력하세요.

