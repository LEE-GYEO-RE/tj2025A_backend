package day09;

public class BankAccount {
    private String accountNumber;
    // 멤버변수 생성

    public BankAccount(String accountNumber){
        // accountNumber 초기화 하는 생성자 생성
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        // 객체의 값 가져와서 return 값 줘서 읽을 수 있게
        // Getter 메소드 생성
        return this.accountNumber;
    }

}
