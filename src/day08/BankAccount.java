package day08;

public class BankAccount {
    String accountNumber;
    String ownerName;
    int balance;

    BankAccount(String accountNumber , String ownerName ,int balance ){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    int deposit(int x){
        balance += x;           // 누적 값이 나와야함
        return balance;
    }
    // boolean deposit( int x ){ balance += x ; return true ;}
    // int vs boolean : 성공/실패

    int withdraw(int y){
        balance -= y;           // 누적 값이 나와야함
        return balance;         // 원래라면 잔액이 더 큰지 확인해야함. if(balance > y) 이런식으로
    }

}
