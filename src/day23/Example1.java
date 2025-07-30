package day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example1 {
    public static void main(String[] args) {

        /*
            인터페이스 : 추상메소드를 가진 타입
            추상메소드 : 메소드를 선언만 하고 구현부{}를 정의하지 않은 메소드
            구현체 : 추상메소드를 가진 인터페이스를 implements 해서 추상메소드를 구현한 클래스의 객체
            ** 다형성 ** : 다양한 타입을 가지는 성질 , extends / implements 키워드 구조관계

            [ 컬렉션 프레임워크 ]
                - 컬렉션(수집) 프레임(틀) 워크(작업) : 자료 수집 방법 = 자료구조
                - 종류 : List , Set , Map 인터페이스
                - 구현체 :
                    1) List : ArrayList , Vector , LinkedList 등
                        .add( [인덱스] , 자료 )
                        .set( 인덱스 , 자료 )
                    2) Set : HashSet , TreeSet 등
                    3) Map : HashMap , TableMap 등

        */

        // [1] 인터페이스 타입 변수명 = new 클래스명();

            // (1)
        ArrayList <String > list1 = new ArrayList<>();
            // (2) ArrayList<>() 는 List <> 로 타입변환 된다. List<>를 implements 했기 때문에
        List< String > list2 = new ArrayList<>();


        // [2] List 인터페이스 주요 메소드

            // 1) .add( 자료 )  : 리스트내 지정한 자료를 마지막 요소 추가
        list2.add("유재석");
        list2.add("강호동");
        list2.add("신동엽");
        list2.add("유재석"); // 중복 허용.
        list2.add( 2 , "서장훈");  // 리스트 내 지정한 인덱스의 자료를 추가
        System.out.println("list2 = " + list2);

            // 2) .set( 인덱스 , 자료 ) : 리스트내 지정한 인덱스의 자료를 수정/변경
        list2.set( 0 , "유재석2");
        System.out.println("list2 = " + list2);
        
            // 3) .get( 인덱스 ) : 리스트 내 지정한 인덱스의 자료 호출/반환
        String result = list2.get( 2 ); // 서장훈 반환
        System.out.println("result = " + result);

            // 4) .size() : 리스트 내 전체 요소/자료 개수 반환
        int count = list2.size();
        System.out.println("count = " + count);

            // 5) .contains( 자료 ) : 리스트내 지정한 자료가 존재하면 true , 없으면 false
        boolean bool = list2.contains("서장훈");
        System.out.println("bool = " + bool);

            // 6) .indexOf( 자료 ) : 리스트내 지정한 자료의 인덱스 반환 , 없으면 -1
        int index = list2.indexOf("서장훈");       // 2
        int index1 = list2.indexOf("이겨레");
        System.out.println("index = " + index);
        System.out.println("index1 = " + index1);

            // 7) .remove( 인덱스 ) : 리스트 내 지정한 인덱스의 요소/항목/자료 삭제
        list2.remove( 2 );  // 2번 인덱스 (서장훈) 삭제
        System.out.println(list2);

            // 8) .isEmpty() : 리스트 내 요소가 비어있으면 true , 1개이상 존재하면 false
        System.out.println(list2.isEmpty() );   // false
        System.out.println(list1.isEmpty());    // true

            // 9) .clear() : 리스트내 모든 요소 삭제
        // list2.clear();
        // System.out.println(list2);  // 싹다 삭제 해서 빈 배열 나옴 : [ ]

            // 10) 리스트/배열 와 반복문 활용
                // 리스트 ( 여러가지 자료(객체) 들을 갖는 자료(객체) )
                // 여러가지 자료들을 순서대로 호출/순회/확인 == 반복문 통해 작업
            // (1) 일반 for 문
                for( int i = 1; i< list2.size() ; i++){
                    System.out.println(list2.get( i ));
                }
            // (2) 향상된 for 문
                for ( String str : list2 ){
                    System.out.println( str );
                }

            // (3) forEach 문 :
            // 리스트/배열명.forEach( )
            // list2.forEach( (반복변수) -> { 실행문 });
            // 리스트 내 첫번재 요소부터 마지막 요소까지 순서대로 반복변수에 대입하여 실행처리 한다.
            // 람다식/화살표 함수 : 복잡한 함수 선언 방식을 간소화 , ( 매개변수 )  -> { 실행문 };
                list2.forEach( (str) -> { System.out.println(str); });
                list2.forEach((  str ) -> { System.out.println(list1); });

        // -------------------------------------------------------- //
        // List : 순서대로 요소 저장하는 자료구조
        // ArrayList : 배열 구조로 사용되는 List 구현체 + 메소드 비동기화( 단일 스레드 플랫폼 )
        ArrayList< Integer > arrayList = new ArrayList<>();
        // Vector : 배열 구조로 사용되는 List 구현체 + 메소드가 동기화 ( 멀티 스레드 플랫폼 )
        Vector<Integer> vector = new Vector<>();
        // LinkedList : 링크(체인/꼬리연결) 구조로 사용되는 List 구현체 + 중간 삽입/삭제 효율성 극대화
            // 배열구조 : [ 5 ] [ 4 ] [ 7 ] [ 10 ]
                //        0      1     2      3
                // 만약에 1번 인덱스가 삭제 되면 2번 ,3번 인덱스는 한칸씩 이동
                // 즉] 중간에 변화가 있으면 뒤에 요소들의 위치변화
                // 하나 바꾸면 뒤에 나머지 싹다 바꿔야함 ex) 10만개 중에 하나 바꾸면 99만개 바꿔짐
            // 링크구조 : [ 5 ] -> [ 4 ] -> [ 7 ] -> [ 10 ]
                //          5/4주소값 -> 4/7주소값 -> 7/10주소값 -> 10/주소값없다.
                // 만약에 1번 인덱스가 삭제되면 0번 인덱스 꼬리(4주소값을 --> 7주소값) 변경
                // 즉] 중간에 변화가 있으면 변화된 요소와 앞 요소의 연결(꼬리) 변경
                // 하나 바꾸면 두개만 바뀜 ex) 10만개 중에 하나 바꾸면 두개만 바꾸면 됨
        LinkedList<Integer> linkedList = new LinkedList<>();

        List<Integer> integerList;  // 앞에 타입설정을 부모(List)로 설정하는게 좋음
        integerList = arrayList;
        integerList = vector;
        integerList = linkedList;
        // vector = arrayList; 형제끼리 안됨



    } // main e
} // class e








































