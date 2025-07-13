package 심화.심화과제2;

import java.util.Scanner;

public class BankService2 {
    private boolean getAccount;

    public static void main(String[] args) {

        BankController2 bc2 = new BankController2();
        // static 안썼으니 메소드 호출 할때 , 객체로 생성
        Scanner scan = new Scanner(System.in);
        // 입력받을 값 Scanner로 생성 준비

        for( ; ;){
            System.out.println("=========== KB Bank ===========");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체");
            System.out.println("============================");
            System.out.println("선택 > ");

            int choose = scan.nextInt();

            if(choose == 1 ){ // 계좌등록
                System.out.println("--- 계좌 등록 (보내는 사람) ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();

                boolean result = bc2.getAccount ( account , password );
                // getAccount 메소드에서 입력받은 계좌 , 비밀번호 값을 result에 저장 boolean은 자료형
                if( result ){
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                }else { // 메소드 실행 후 null이 아니면 불가능 출력
                    System.out.println("[경고] 등록 실패! 100개 꽉 참");
                }
            } // if1 e

            if(choose == 2 ){ // 입금
                System.out.println("--- 입금 ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                System.out.println("입금액 :");    int money = scan.nextInt();

                boolean result1 = bc2.getDeposit(account , password , money);
                // 여기도 마찬가지로 getDeposit 에서 값 받은 거 실행 후 result1에 저장
                if( result1 ){
                    System.out.println("[안내] 입금이 완료되었습니다.");
                }else {
                    System.out.println("[경고] 계좌정보 불일치");
                }
            } // if2 e

            if(choose == 4 ){ // 잔고 확인
                System.out.println("--- 잔고 확인 (보내는 사람) ---");
                System.out.println("계좌번호 : ");  String account = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                int result2 = bc2.getMoney(account , password );
                if( result2 >= 0 ){
                    System.out.println("[잔고] : " + result2 );
                }
            } // if4 e

            if(choose == 5 ){
                System.out.println("--- 계좌 이체 ---");
                System.out.println("보내는 분 계좌번호 : ");  String sendaccount = scan.next();
                System.out.println("비밀번호 : ");  int password = scan.nextInt();
                System.out.println("받는 분 계좌번호 : ");  String reciveaccount = scan.next();
                System.out.println("이체할 금액 : "); int transfer = scan.nextInt();
                System.out.println("[안내] 이체가 완료 되었습니다. ");
            } // if 5 e
        } // for 무한 루프 e
    } // main e
} // class e
