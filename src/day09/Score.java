package day09;

public class Score {
    private int score;  // private 접근제한자 가진 score 멤버변수

    public void setScore(int score){   // 메소드 정의
        if( score >= 0 && score <= 100 ){
            this.score =score;
        }else {
            System.out.println("유효하지 않은 점수입니다.");
        } // if e
    } // func e
} // class e
