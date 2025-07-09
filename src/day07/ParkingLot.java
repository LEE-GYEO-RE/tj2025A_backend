package day07;

public class ParkingLot {
    // 메소드/API 설계
    // 1. 함수명 : claculateFee
    // 2. 매개변수 : 주차 시간(분) , int time
    // 3. return 값 : 최종 주차 요금 , int fee

    int calculateFee ( int time ){

        int fee = 0;

        if( time <= 30){
            fee = 1000;
        } else if (time > 30) {
            fee = 1000 + ((time - 30) / 10 * 500);
        } else if (fee > 20000) {
            fee = 20000;
        }

        return  fee;
    } // func end
} // class end
