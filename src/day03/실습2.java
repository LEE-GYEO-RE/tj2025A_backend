package day03; // 현재 .java 파일의 패키지/폴더 명

import java.util.Scanner;

public class 실습2 {  // [컴파일/번역] 자바의 모든 코드는 클래스{} 안에서 작성해야한다.  // class s
    public static void main(String[] args) { // main s
        byte a = 10;
        int b = 200;
        long result = a + b;
        System.out.println( "1.결과 : " + result );

        // 2. 강제타입변환
        double z = 3.141592;
        System.out.println("2.결과 : " +(int)z);

        // 3. 입력함수
        Scanner scan = new Scanner(System.in);                              // 입력객체를 변수에 대입 , Scanner : 자동완성 입력
        System.out.print("이름을 입력하세요 : ");
        String name = scan.next();                                          // 입력객체 이용한 입력함수 , .next()
        System.out.print("나이를 입력하세요 : ");
        int age = scan.nextInt();                                           // 입력함수가 반환한 값을 변수에 대입
        System.out.printf("%s님의 나이는 %d세 입니다. \n" , name , age );

        // 4. 입력함수 :
        System.out.print("게시물번호를 입력하세요 : ");
        int bno = scan.nextInt();
        System.out.print("게시물 제목을 입력하세요 : ");
        scan.nextLine();                                                    // nextLine(); 앞에 의미 없는 nextLine(); 하나 선언
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력하세요 : ");
        String content = scan.nextLine();
        System.out.printf("[%d번 게시물] \n" , bno);                         // printf 활용한 서식 출력 , %d정수 , %s 실수
        System.out.printf("제목 : %s \n" , title);                          // printf( "서식문자" , 변수/값 )
        System.out.printf("내용 : %s\n" , content);                         // \n 줄바꿈처리 가능


        // 5. char
        System.out.print("성별을 입력하세요(남/여) : ");
        char sex = scan.next().charAt(0);                               // *문자 1개 입력함수는 없으므로 문자열 함수를 사용 후, .charAt(인덱스)
        System.out.printf("입력하신 성별은 %s 입니다. \n" , sex);


        // 6.
        System.out.print(" 키를 입력하세요 : ");
        double cm = scan.nextDouble();
        System.out.printf("당신의 키는 약 %dcm 이군요\n" , (int)cm);

        // 7.
        //이름 (String), 나이 (int), 키 (double), 프로그래머 여부 (boolean)
        //입력 예시:
        //이름: 김자바
        //나이: 25
        //키: 165.8
        //프로그래머입니까? (true/false): true
        //출력 예시:
        //--- 자기소개 ---
        //이름: 김자바
        //나이: 25
        //키: 165.8cm
        //프로그래머 여부: true

        System.out.print("이름을 입력하세요 : ");
        String name2 = scan.next();
        System.out.print("나이를 입력하세요 : ");
        int age2 = scan.nextInt();
        System.out.print("키를 입력하세요 : ");
        double cm2 = scan.nextDouble();
        System.out.print("당신은 프로그래머 입니까? : ");
        boolean pro = scan.nextBoolean();
        System.out.println("---자기 소개 ---");
        System.out.println("이름 : " + name2);
        System.out.println("나이 : " + age2);
        System.out.println("키 : " + cm2 + "cm");
        System.out.println("프로그래머 여부 : " + pro);



    } // main e
} // class e

/*
[실습2] *제출용
[ 문제] 아래 타입변환, 입력함수 관련 7문제
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.

문제 1: a 와 b 두 변수의 합을 long 타입의 변수에 저장하여 그 결과를 출력하시오.
선언 코드 :
byte a = 10;
int b = 200;
출력 예시:
결과: 210

문제 2: 실수 3.141592를 double 타입 변수에 저장한 뒤, 이 변수를 int 타입으로 강제 변환하여 정수 부분만 출력하시오.
선언 코드 :
double z = 3.141592;
출력 예시:
원본 double 값: 3.141592
변환된 int 값: 3

문제 3: Scanner를 이용하여 사용자의 이름(String)과 나이(int)를 입력받아, "OOO님의 나이는 OO세 입니다." 형식으로 출력하는 코드를 작성하시오.
입력 예시:
이름을 입력하세요: 유재석
나이를 입력하세요: 51
출력 예시:
유재석님의 나이는 51세 입니다.

문제 4: Scanner를 이용해 게시물 번호(int), 제목(String), 내용(String)을 순서대로 입력받아 출력하시오.
요구 조건: 제목과 내용은 띄어쓰기가 포함될 수 있으므로 nextLine()을 사용하시오.
입력 예시:
게시물 번호: 1
제목: 자바는 재미있어요
내용: 정말입니다. 다들 동의하시죠?
출력 예시:
[ 1번 게시물 ]
제목: 자바는 재미있어요
내용: 정말입니다. 다들 동의하시죠?

문제 5: Scanner를 이용해 성별을 한 글자('남' 또는 '여')로 입력받아 char 타입 변수에 저장하고, 입력된 성별을 출력하시오.
요구 조건: Scanner에는 nextChar() 함수가 없으므로 next().charAt(0)을 활용하시오.
입력 예시:
성별을 입력하세요(남/여): 남
출력 예시:
입력하신 성별은 '남' 입니다.

문제 6: Scanner를 이용해 사용자의 키를 double 타입(예: 178.5)으로 입력받은 후,
이 값을 int 타입으로 강제 변환하여 "당신의 키는 약 OOOcm 이군요." 라고 정수 부분만 출력하시오.
입력 예시:
키를 입력하세요: 178.5
출력 예시:
당신의 키는 약 178cm 이군요.

문제 7: Scanner를 사용하여 아래 4가지 정보를 순서대로 입력받아 출력하는 코드를 작성하시오.
이름 (String), 나이 (int), 키 (double), 프로그래머 여부 (boolean)
입력 예시:
이름: 김자바
나이: 25
키: 165.8
프로그래머입니까? (true/false): true
출력 예시:
--- 자기소개 ---
이름: 김자바
나이: 25
키: 165.8cm
프로그래머 여부: true
*/