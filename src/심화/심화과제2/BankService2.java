package 심화.심화과제2;

import java.util.Scanner;

public class BankService2 {
    public static void main(String[] args) {

        for( ; ;){
            System.out.println("=========== KB Bank ===========");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체");
            System.out.println("============================");
            System.out.println("선택 > ");

            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

            if(choose == 1 ){
                System.out.println("--- 계좌 등록 (보내는 사람) ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                System.out.println("[안내] 계좌 등록이 완료되었습니다.");
            }

            if(choose == 2 ){
                System.out.println("--- 입금 ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                System.out.println("입금액 :");    int money = scan.nextInt();
                System.out.println("[안내] 입금이 완료되었습니다.");
            }

            if(choose == 4 ){
                System.out.println("--- 잔고 확인 (보내는 사람) ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                System.out.println("[잔고] :");    int money = scan.nextInt();
            }

            if(choose == 5 ){
                System.out.println("--- 계좌 이체 ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                System.out.println("[잔고] :");    int money = scan.nextInt();
            }






        }

    } // main e
} // class e
