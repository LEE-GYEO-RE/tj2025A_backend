package day09;

public class Member {

    // 1. 멤버변수
    // 2. 생성자
    // setId 메소드가 초기화해줘서 여기선 필요없음
    // 3. 메소드
    private String id;              // 1

    public void setId(String id){    // 3 Setter 메소드
        this.id = id;                // 계속 수정해줘야 해서 id값 초기화
    }

    public String getId( ){         // 3 Getter 메소드
        return this.id;
    }
} // class end
