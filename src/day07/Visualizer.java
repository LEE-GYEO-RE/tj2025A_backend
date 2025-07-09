package day07;

public class Visualizer {
    String getStar(int x){
       String a = "";
       for( int i = 1 ; i <= x ; i++){
           a +="★"; // 한번씩 1부터  x까지 ★ 누적
       }
        return a; // 최종 문자열 a 반환
    } // func end
} // class end
