package 종합.예제7.model.dto;

// (역할) 데이터의 모델 이면서 이동 객체
public class BoardDto {

    // 1. 멤버변수 : 모두 private 한다. 설계
    private String content;
    private String writer;

    // 2. 생성자 : 기본생성자 , 풀생성자는 기본!! , 다른건 나중에 추가 하셈

    public BoardDto(){ } // 기본생성자

    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 3. 관례적인 메소드

    // 1) getter and setter
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

    // 2) toString
    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
