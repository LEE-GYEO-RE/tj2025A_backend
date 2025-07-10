package 종합.예제6;

// 데이터 모델 : 게시물 모델링

public class Board {
    // 1. 멤버변수 : *관례적* 멤버변수는 private

    // * 모델링에 들어갈 속성
    private String content;
    private String writer;

    // 2. 생성자 : *관례적* 기본생성자 1개와 전체 매개변수 갖는 생성자 (2개) / * 상황에 따라 추가하면됨
    // 자동 : 해당 클래스에서 오른쪽 클릭 -> [생성] -> [생성자] -> 모든 멤버변수 복수선택 후 -> [확인]

    // 기본 생성자
    public Board(){}

    // 전체 매개변수를 갖는 생성자
    public Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 3. 메소드 :

    // 주로 private 으로 선언된 멤버변수를 외부(다른 클래스) 로부터 접근할수 있도록 getter/setter 지원한다.
    // 자동 : 해당 클래스를 오른쪽 클릭 -> [생성] -> [getter 및 setter] -> 모든 멤버변수 복수선택 후 -> [확인]

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
    // -----------------------------> getter/setter 메소드는 private 으로 된 속성들을 가져오기 위한 메소드? 로만 생각하면 됨. 그냥 관례적으로 ---------- //

    // ---> 원래는 객체 출력하면 주소값이 출력됐음 . toString() 자동완성 하면 , 객체 출력 시 문자열로 반환해서 , 속성 값 나옴
    @Override // 상속개념 아직 안배움
    public String toString() {
        return "Borad{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

} // class e
