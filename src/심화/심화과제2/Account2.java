package 심화.심화과제2;

public class Account2 {

    String account; // 계좌번호 멤버변수
    int password;   // 비밀번호 멤버변수
    int money;      // 돈


    // int balance;  잔액 멤버변수 -- > 굳이 필요없음 , 생성자에서 매개변수로 지정하고 , 인수값 받아오면 됨

    Account2(String account , int password ){
        this.account = account;
        this.password = password;
        this.money = 0;
    }
}
