package 심화.심화과제1;

import java.util.Scanner;

public class BankService1 {
    public static void main(String[] args) {

        for( ; ; ){
            System.out.println("============== KB Bank  ==============");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고");
            System.out.println("======================================");
            System.out.println("선택 > ");

            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

            if( choose == 1 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 계좌 등록 ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                System.out.println("[안내] 계좌 등록이 완료되었습니다.");
            } // if e

            if( choose == 2 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 입금 ---");
                System.out.println("계좌번호 :");   String account = scan.next();
                System.out.println("비밀번호 :");   int password = scan.nextInt();
                System.out.println("입금액 :");    int deposit = scan.nextInt();
                System.out.println("[안내] 입금이 완료되었습니다.");
                System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
            } // if e

            if( choose == 3 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 출금 ---");
                System.out.println("계좌번호 :");   String account = scan.next();
                System.out.println("비밀번호 :");   int password = scan.nextInt();
                System.out.println("출금액 :");    int Withdrawal = scan.nextInt();
                System.out.println("[안내] 출금이 완료되었습니다.");
                System.out.println("[경고] 잔액이 부족합니다.");
            } // if e

            if( choose == 4 ){
                System.out.println("============== KB Bank  ==============");
                System.out.println("--- 잔고 확인 ---");
                System.out.println("계좌번호 :");
                System.out.println("비밀번호 :");
                System.out.println("[잔고] : %d \n ");
            }
        } // for e
    } // main e
} // class e
