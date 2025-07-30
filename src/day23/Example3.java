package day23;

import java.sql.SQLOutput;
import java.util.*;

public class Example3 {
    public static void main(String[] args) {

        /*
            [ 컬렉션 프레임워크3 ]
            List 인터페이스 : 순서(인덱스) 대로 저장하는 구조
            set 인터페이스 : 순서(인덱스) 없이 저장하는 구조
            Map 인터페이스 : key와value를 한쌍(entry) 으로 여러 쌍을 저장하는 구조
                -> HTML/CSS/JS <--> JAVA <--> DB
                -> JSON : 자바스크립트에서 사용하는 객체 형식
                -> 자바에는 json 없어서 json과 비슷한 형식은 map
        */

        // [1] HashMap 객체 생성 , < key타입 , value타입 >
        Map< String , Integer> map = new HashMap<>();

        // [2] 주요 메소드

            // 1) .put( key자료1 , value자료2 ) : Map 객체 내 key와 value 자료를 한쌍(entry) 저장
        map.put("유재석" , 95 );   // "유재석" 자료는 key(속성명) , 95 자료는 value(속성값)
        map.put("강호동" , 100 );  // "강호동" 속성명에 100 저장
        map.put("신동엽" , 78 );
        map.put("유재석" , 67 );   // key(속성명) 중복이 불가능 , key 는 식별자!!
        map.put("서장훈" , 100 );  // value(속성값) 중복이 가능
        // 변수명( 상징적인 이름 ) , 변수값( 상징적인 이름에 저장된 실질적인 자료 )
        System.out.println("map = " + map);
        // map = {서장훈=100, 유재석=67, 강호동=100, 신동엽=78}
        // 자바랑 자바스크립트 간의 자료 변환 할때 많이 씀

            // 2) .get( key ) : Map 객체내 지정한 key의 value 반환
        System.out.println(map.get("유재석")); // 67

            // 3) .size( ) : Map 객체내 entry(쌍) 개수 반환
        System.out.println(map.size()); // entry : 4 , key : 4 , value : 4 , 자료 : 8

            // 4) .remove( key ) : Map 객체내 지정한 key의 entry(쌍) 삭제
        map.remove("유재석");
        System.out.println("map = " + map); // map = {서장훈=100, 강호동=100, 신동엽=78}

            // 5) .containsKey( key ) , .containsValue( value )
        System.out.println(map.containsKey("강호동")); // true
        System.out.println(map.containsValue(65));    // false

            // 6) .clear() : Map 객체내 모든 entry 삭제
        // map.clear();
        // System.out.println(map);    // 빈 객체 반환 { }

            // 7) .isEmpty() : Map 객체내 entry 하나도 없으면 true , 1개이상이면 false 반환
        System.out.println(map.isEmpty());  // false

            // 8) .entrySet() : Map 객체내 모든 entry를 set 인터페이스로 반환
        System.out.println(map.entrySet()); // [서장훈=100, 강호동=100, 신동엽=78] : {} -> [] 객체에서 배열로 바뀜

            // 9) .keySet() : Map 객체내 모든 key를 set 인터페이스로 반환
        System.out.println(map.keySet()); // [서장훈, 강호동, 신동엽]

            // 10) .values() : Map 객체내 모든 value를 List 인터페이스 반환
        System.out.println(map.values()); // [100, 100, 78] -> List 인터페이스로 반환하기 때문에 중복 가능!!!!!

        // --------> 규칙성 없는 자료(비정형화) : Map
        // --------> 규칙성 있는 자료(정형화)   : DB , DTO

        // [3] Map 과 반복문 관계

        // 1) 일반 for문 표현 못함 : 인덱스가 없어서

        // 2) 향상된 for문
        for( String key : map.keySet() ){ // Map 객체내 모든 key를 반복한다.
            System.out.println(key);            // key      * value 활용하여 key 호출 불가능
            System.out.println(map.get(key));   // value    * key 활용하여 value 호출 가능
        }

        // 3) forEach문
        map.keySet().forEach((key) -> {
            System.out.println(key);
            System.out.println(map.get(key));
        });

        // 활용] JSON( javascript 객체 ) <----> Map/Dto ( JAVA 객체 )
        // DTO는 미리 멤버변수 정의/설계 , n회성 객체
        // Map은 멤버변수 설계하지 않고 사용. 1회성 객체

        // [4] 구현체
        // Map 인터페이스 : key 와 value 를 (자료2개) 를 한쌍(entry : 자료 1개 )으로 여러개 쌍을 저장

        // 1) HashMap       : key와 value로 구성된 entry객체를 저장하는 구조
        HashMap< Integer , Object > hashMap = new HashMap<>();

        // 2) HashTable     : key와 value로 구성된 entry객체를 저장하는 구조 + 동기화 메소드 제공 ( 멀티 스레드 플랫폼 )
        Hashtable< Integer , Object > hashtable = new Hashtable<>();

        // 3) Treemap       : key와 value로 구성된 entry객체를 저장하는 구조 + key값 기준으로 자동 정렬(오름차순)
        TreeMap< Integer , Object > treeMap = new TreeMap<>();

        // 4) Properties    : key와 value로 구성된 entry객체를 저장하는 구조 + 제네릭이 없음 + 주로 세팅/설정 파일 사용됨. Spring환경
        Properties properties = new Properties();

        // **** 다형성 ****
        Map< Integer , Object > map2;
        map2 = hashMap;
        map2 = hashtable;
        map2 = treeMap;



    } // main e
} // class e


































