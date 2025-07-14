package day11;

import java.util.ArrayList;
import java.util.Scanner;

public class 실습11 {
    public static void main(String[] args) {

        // 문제 1
        ArrayList <String> nameList = new ArrayList<>();

        nameList.add("유재석");
        nameList.add("강호동");
        nameList.add("신동엽");
        System.out.println(nameList);

        // 문제 2
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("사과"); fruits.add("바나나"); fruits.add("딸기");
        System.out.println(fruits);

        for (int i = 0; i < fruits.size() ; i ++ ){
            String f = fruits.get(i);
            System.out.printf("인덱스 %d : %s \n" , i , f );
        }

        // 문제 3
        for ( String f : fruits ){
            System.out.println(f);
        }

        // 문제 4

        ArrayList <String> alp = new ArrayList<>();
        alp.add("A");
        alp.add("B");
        alp.add("C");
        alp.add("D");
        alp.add("E");
        System.out.println(alp);

        alp.remove(2);
        System.out.println(alp);

        // 문제 5

        ArrayList <String> pl = new ArrayList<>();
        pl.add("자바"); pl.add("파이썬"); pl.add("C++");
        System.out.println(pl);
        pl.add(1 , "자바스크립트");
        System.out.println(pl);

        // 문제 6


//2. new Book(...)을 사용하여 3권의 책 객체를 생성하고 library 리스트에 추가하세요.
//3. 향상된 for문을 사용하여 library에 저장된 모든 책의 제목과 저자를 출력하세요.

        ArrayList <Book> library = new ArrayList<>();
        Book b1 = new Book("제목1" , "제목1");
        Book b2 = new Book("제목2" , "제목2");
        Book b3 = new Book("제목3" , "제목3");
        library.add(b1);
        library.add(b2);
        library.add(b3);
        for( Book b : library){
            System.out.println("제목 : " + b.getTitle() );
            System.out.println("저자 : " + b.getAuthor() );
        }


        // 문제 7

        ArrayList <String> inputList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        for( ; ; ) {

            String input = scan.nextLine();
            if(input.equals("종료")){
                break;
            } // if e
            inputList.add(input);
        } // for e
        System.out.println(inputList);
        // 문제 8

        ArrayList <String> sb = new ArrayList<>();
        sb.add("국어"); sb.add("수학"); sb.add("사회"); sb.add("과학");
        System.out.println(sb);
        sb.set( 1, "영어");
        System.out.println(sb);


    } // main e
} // class e




//[JAVA] 실습11 : ArrayList 클래스
//[ 문제 ] 아래 ArrayList 관련 문제를 해결하시오.
//[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
//
//[문제 1] String 타입의 요소를 저장할 수 있는 ArrayList를 nameList 라는 이름으로 생성하세요.
//1. .add() 메소드를 사용하여 "유재석", "강호동", "신동엽" 세 개의 이름을 리스트에 추가하세요.
//2. 리스트의 모든 요소를 System.out.println()으로 한 번에 출력하세요.
//
//[문제 2] 다음과 같이 초기화된 ArrayList가 있습니다.
//1. ArrayList<String> fruits = new ArrayList<>();
//2. fruits.add("사과"); fruits.add("바나나"); fruits.add("딸기");
//3. 일반 for문을 사용하여, 각 인덱스와 해당 인덱스의 요소를 "인덱스 0: 사과" 형식으로 모두 출력하세요.
//
//[문제 3] 문제 3의 fruits 리스트를 사용합니다.
//1. 향상된 for문 을 사용하여 리스트의 모든 요소를 하나씩 출력하세요.
//
//[문제 4] "A", "B", "C", "D", "E"를 요소로 가지는 ArrayList를 생성하세요.
//1. .remove() 메소드를 사용하여 2번 인덱스의 요소("C")를 삭제하세요.
//2. 삭제 후의 리스트 전체를 출력하여 결과가 올바른지 확인하세요.
//
//[문제 5] "자바", "파이썬", "C++"를 요소로 가지는 ArrayList를 생성하세요.
//1. .add(인덱스, 요소) 메소드를 사용하여 1번 인덱스에 "자바스크립트"를 삽입하세요.
//2. 삽입 후의 리스트 전체를 출력하여 순서가 올바르게 변경되었는지 확인하세요.
//
//[문제 6] title(문자열)과 author(문자열) 멤버 변수를 가진 Book 클래스를 만드세요.
//1. Book 객체를 저장할 수 있는 ArrayList를 library 라는 이름으로 생성하세요.
//2. new Book(...)을 사용하여 3권의 책 객체를 생성하고 library 리스트에 추가하세요.
//3. 향상된 for문을 사용하여 library에 저장된 모든 책의 제목과 저자를 출력하세요.
//
//[문제 7] Scanner를 사용하여 사용자로부터 문자열을 계속해서 입력받습니다.
//1. 입력받은 문자열은 ArrayList에 순서대로 저장합니다.
//2. 만약 사용자가 "종료" 라는 단어를 입력하면, 입력을 멈추고 그때까지 리스트에 저장된 모든 내용을 출력한 뒤 프로그램을 종료하세요.
//
//[문제 8] "국어", "수학", "사회", "과학"을 요소로 가지는 ArrayList를 생성하세요.
//1. .set(인덱스, 요소) 메소드를 사용하여 1번 인덱스의 "수학"을 "영어"로 수정하세요.
//2. 수정 후의 리스트 전체를 출력하여 결과가 올바른지 확인하세요.
