package day23;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Example2 {
    public static void main(String[] args) {
        /*
            [ 컬렉션 프레임워크2 ]
                List 인터페이스 : 배열/링크 구조 , 인덱스 있다. 중복 허용한다. (인덱스가 식별자)
                Set 인터페이스  : 집합구조 , 인덱스 없다. 중복 허용하지 않는다. (자료가 식별자) + 중복없는 집합 표현 할때 씀

        */

        // [1] HashSet 객체 생성
        Set< String > set1 = new HashSet<>();

        // [2] 주요 메소드
            // 1) .add( 자료 ) : 집합 내 지정한 자료를 추가한다. 인덱스(순서) 없음
        set1.add("유재석");
        set1.add("강호동");
        set1.add("신동엽");
        set1.add("유재석"); // 이미 존재하는 자료는 중복이므로 불가능.
        System.out.println("set1 = " + set1); // set1 = [유재석, 강호동, 신동엽] 중복되는 "유재석" 자동 제거
            // 2) .size() : 집합 내 자료/요소 개수 반환
        System.out.println(set1.size()); // 3

            // 3) .contains( 자료 ) : 집합 내 자료가 존재하면 true , 없으면  false 반환
            // .set() , .get() 메소드 없음 --> 인덱스 없어서
        System.out.println(set1.contains("강호동")); // true

            // 4) .remove( 자료 ) : 집합 내 자료가 존재하면 삭제 없으면 삭제 안함
        set1.remove("강호동");
        System.out.println("set1 = " + set1); // set1 = [유재석, 신동엽] "강호동" 있어서 삭제

            // 5) .isEmpty() : 집합 내 자료/요소가 하나도 없으면 true , 1개이상이면 false 반환
        System.out.println(set1.isEmpty()); // false

            // 6) .clear() : 집합내 모든 자료/요소 삭제
        // set1.clear();

        // [3] 집합과 반복문 관계
        // 1) 일반 for문 표현 불가능 : 인덱스가 없어서..!!

        // 2) 향상된 for문 : for( 타입 반복변수명 : 리스트/집합명 ) { }
        for( String str : set1 ){ System.out.println(str); }

        // 3) forEach 문 : 리스트/집합명.forEach( ( 반복변수명 ) -> { 실행문 } );
        set1.forEach( (str) -> { System.out.println(str); });

        // [4] 구현체
        // Set 인터페이스 : 순서 보장 없이 요소들을 저장하는 구조
        // 1) HashSet : 중복 없는 여러개 요소 저장 + 빠르다.
        HashSet<Integer> hashSet = new HashSet<>();
        // 2) TreeSet : 중복 없는 여러개 요소 저장 + 저장된 자료들을 자동으로 정렬(오름차순)
        TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add( 10 ); treeSet.add( 20 );
        System.out.println(treeSet);
        // 3) LinkedHashSet : 중복 없는 여러개 요소 저장 + 링크구조 + 순서(인덱스 없는) 보장 + 느리다.
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();


        // ** 다형성 ** 자식은 부모가 될 수 있다.!!!!!!!!!! 타입변환 된다
        Set<Integer> set2;
        set2 = hashSet;
        set2 = treeSet;
        set2 = linkedHashSet;

        // [활용] JDBC : ResultSet
        // ResultSet -> 인덱스가 없음
        // .next() : 다음 집합으로 이동한다는 메소드

    } // main e
} // class e












































