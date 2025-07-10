package day09;

class D{
    // final int 최종변수; // final 은 초기값이 필요( = 10; )
    final int 최종변수 = 10;

    // static
    static int 비멤버변수;   // 객체내 포함하지 않고 클래스가(new) 하지 않아도 사용가능

    // 상수 만들기
    static final int 상수 = 10;

    // [5] static 아닌 메소드에서는 static 있거나 없거나 호출 가능.
    void 멤버메소드1(){}
    static void 비멤버메소드(){}
    void 멤버메소드2(){
        멤버메소드1();   // 가능
        비멤버메소드();   // 가능
    }

    // main 함수는 static 임, 그래서 static 아닌 메소드 호출 할때 , 객체 쓰는거임
    // static 메소드면 메소드 호출 할때 , 클래스명 붙이는 것도 방법임
    // 예] System.out.println(); 에서 System : 클래스명 , out : 이게 static임. 그래서 객체 생성 x
    // 메소드 호출하는 방법들은 다양함 , 관례적인 방법들이 있음. 협업할 때 그 규칙대로 하셈.


} // class e

public class Example2 { // class s


    void 멤버메소드(){}              // static 아닌 메소드
    static  void  비멤버메소드(){}    // static 메소드

    public static void main(String[] args) { // main s

        // [1] final 멤버변수 호출 가능 , 수정 불가능
        D d = new D();
        System.out.println(d.최종변수); // 호출가능
        // d.최종변수 = 20;             // 수정 불가능

        // [2] static 정적변수에 호출 , 클래스명.정적변수명;
        System.out.println(D.비멤버변수);    // 가능
        D.비멤버변수 = 20;
        System.out.println(d.비멤버변수);

        // [3] 상수 호출 , 클래스명.상수명;
        System.out.println(D.상수);

        // [4] static 메소드 내 static 유무 메소드 호출
        // 멤버메소드();                         // 불가능 : static 없는 메소드라

        Example2 exam = new Example2();
        exam.멤버메소드();                       // 가능 : 객체 생성해서 메소드 호출하면 가능

        비멤버메소드();                           // 가능 : 객체 없이 사용 가능

        // [5] static 메소드가 아닌 static 유무 메소드 호출


        /*
        [ final ] * 최후의
            1. 고정 상태를 정의할때 사용하는 키워드
            2. 사용법
                final 타입 멤버변수
            3. 주의할점 : 초기값이 무조건 존재 해야함.

        [ static ] * 정적인
            1. 프로그램이 실행될때 메모리가 할당되고 프로그램이 종료될때 메모리 삭제되는 키워드
            2. 사용법 : static 타입 멤버변수 ---------> static변수
            3. 주의할점 : 멤버변수(객체내변수) 공유x new vs static(객체외) 공유o
            ========> 프로그램내 딱 1개만 존재하는 변수를 선언할 때 사용.
            ========> 서로 다른 객체들이 공유해서 사용한다.
            // 객체 생성 없이 클래스명으로 호출 가능

        [ 상수 ] : 변하지 않는 변수
            1. 사용법 : static final 타입 상수명; // js 에서는 const 쓰면됨
            2. 주의할 점 :
                1) 수정불가능
                2) 프로그램내 딱 1개만 존재
                3) 상수명은 대문자 사용

        [ static 유무 중요한 이유 ]
            !!!!!!!!!! : static으로 선언된 메소드는 같은 클래스내 메소드를 호출할 수 없다.
            ------>  static 함수 안에서는 static이 아닌 함수를 부를 수 없다.
            ----->> static 아닌 함수 부르려면 객체 생성해서 객체를 통해 메소드 호출.


            class Test{
                static void main3(){ }
                void main2(){}
                static void main(){
                    main2()              // 불가능 : main 함수는 우선할당이 되면서 main2 읽지못함
                    new Test().main2()  // 가능 : Test객체 new로 불러와서 그 안에 있는 main2함수 불러오기 가능
                    main3(){}           // 가능 : main함수는 우선할딩이 되면서 우선할당횐 main2 읽을 수 있음
                }
            }



        */
    } // main e
} // class e
