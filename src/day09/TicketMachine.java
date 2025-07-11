package day09;

public class TicketMachine {
    static int totalTickets = 0;
    // 정적 변수 선언 , 여기서 totalTickets을 static 으로 클래스 변수로 설정했음
    // TicketMachine 의 모든 객체가 이 변수를 공유함
    //-------> 그래서 그 값이 누적될 수 있는 것
    // 저게 만약 없으면 , 객체마다 totalTickets 값이 독립적이게 됨
    //-------> 그러면 누적값이 아니라 따로따로 나옴

    void issueTicket(){
        totalTickets ++;
        System.out.println("티켓 1장을 발권했습니다.");
    }

     static void printTotalTickets(){
        System.out.println("총 발권수 "+ totalTickets);
    }

}
