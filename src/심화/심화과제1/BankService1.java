package 심화.심화과제1;

import java.util.Scanner;

public class BankService1 {
    public static void main(String[] args) {

        BankController1 bc = new BankController1();
        // BankController1 클래스에 있는 메소드들 호출하기 위해서 bc 객체 생성
        Scanner scan = new Scanner(System.in);
        // 무한 루프 밖에 지정하는 게 메모리에 좋음
        for( ; ; ){
            System.out.println("============== KB Bank  ==============");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고");
            System.out.println("======================================");
            System.out.println("선택 > ");

            int choose = scan.nextInt();

            if( choose == 1 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 계좌 등록 ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();

                boolean result = bc.getAccount( account , password );
                // 입력받은 값을 인수로 전달 후 , getAccount 메소드 실행한 결과를 result 변수에 저장 ,
                if( result ) { // 메소드 실행 후 , return true 이면 아래 출력
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                }else { // 메소드 실행 후 null 존재하지 않으면 , 아래출력
                    System.out.println("[경고] 등록 가능 계좌의 한도가 넘었습니다.");
                }
            } // if1 e

            if( choose == 2 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 입금 ---");
                System.out.println("계좌번호 :");   String account = scan.next();
                System.out.println("비밀번호 :");   int password = scan.nextInt();
                System.out.println("입금액 :");    int deposit = scan.nextInt();
                boolean result1 = bc.getDeposit(account ,password ,deposit);
                if( result1 ) {
                    System.out.println("[안내] 입금이 완료되었습니다.");
                }else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }
            } // if2 e

            if( choose == 3 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 출금 ---");
                System.out.println("계좌번호 :");   String account = scan.next();
                System.out.println("비밀번호 :");   int password = scan.nextInt();
                System.out.println("출금액 :");    int withdrawal = scan.nextInt();
                boolean result2 = bc.getWithdrawal( account , password ,withdrawal );
                if( result2 ) {
                    System.out.println("[안내] 출금이 완료되었습니다.");
                }else{   // 메소드 값이 false면?
                    System.out.println("[경고] 잔액이 부족합니다.");
                }
            } // if3 e

            if( choose == 4 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 잔고 확인 ---");
                System.out.println("계좌번호 :");   String account = scan.next();
                System.out.println("비밀번호 :");   int password = scan.nextInt();
                int result3 = bc.getMoney( account , password );
                if( result3 >= 0 ) {
                    System.out.println("[잔고] : " + result3);
                }
            } // if4 e

        } // for e
    } // main e
} // class e
