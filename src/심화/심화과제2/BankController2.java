package 심화.심화과제2;

public class BankController2 {

    // 클래스 3개 생성
    // 객체 100개 저장할 수 있는 배열 생성
    // 매개변수로 입력받을 값 지정 -> 생성자 생성 시 같이 할 예정
    // 메소드 생성

    // 1. 계좌등록 메소드
    // 2. 입금 메소드
        // 1) 입금 성공 시 출력 기능
        // 2) 계좌번호 다를 때 , 입금 실패 출력 기능
    //  출금 메소드 ==> 필요없네..?ㅋㅋ
    // 3. 잔고 출력 메소드
        // 1. 출금 , 입금 시 누적 증감 기능
        // 2. 이체 했을 때 , 누적 차감 기능
        // 3. 이체 받았을 때 , 누적 더하기 기능
    // 4. 계좌이체 메소드
        // 1. 성공 시 출금 (누적 차감)
        // 2. 비밀번호 오류 시 경고 메시지
        // 2. 잔액 부족 시 잔액부족 메시지
    // 메소드 호출
    // 출력

    // 객체 100개 저장할 수 있는 account2s 생성
    Account2 [ ] account2s = new Account2[100];

    // 계좌 등록 메소드
    boolean getAccount(String account ,int password){
        Account2 account2 = new Account2(account , password );
        // Account2 생성자에서 값 가져오기
        for (int i = 0; i < account2s.length ; i++){
            // 100개 저장 가능한  account2s 0번째부터 순회
            if(account2s[i] == null ){
                // i번째가 null 이면
                account2s[i] = account2;
                // i번째 인덱스에 account2 값 대입
                return true;
            } // if e
        } // for e
        return false;
    } // func e

    // 입금 메소드
    boolean getDeposit(String account ,int password , int deposit){
        for( int i = 0 ; i < account2s.length ; i ++){
            // 100개 저장 가능한 account2s 0번째부터 순회
            if( account2s[i] != null
                    && account2s[i].account.equals(account) && account2s[i].password == password){
                // i번째 인덱스가 null , 비어있지 않으면서
                // i번째 인덱스의 account(계좌번호)와 passeord(비밀번호)가 입력 받은 거랑 같으면
                account2s[i].money += deposit;
                // i번째 인덱스의 잔액에 입금액 누적 더하기 해서 대입
                return true;
            } // if e
        } // for e
        return false;
    } // func e

    // 출금 메소드
    boolean getWithdrawal(String account , int password ,int withdrawal){
        for( int i = 0 ; i < account2s.length ; i++){
            // 입금 메소드에서와 같이 순회
            if( account2s[i] == null ) continue;
                // 만약 i번째 인덱스가 null , 비어있으면 있을때까지 찾기
            if( account2s[i].account.equals(account) && account2s[i].password == password){
                // 만약 i번째 계좌번호 , 비밀번호 일치하면
                if( account2s[i].money >= withdrawal){
                    // 만약 i번째 잔액이 출금액보다 크거나 같으면
                    account2s[i].money -= withdrawal;
                    // 잔액에 출금액 누적 빼기 후 대입
                    return true;
                }else {return false;} // 아니라면 - > 출금액이 더 크면 - > 실패!
            } // if e
        } // for e
        return false;
    } // func e


    // 잔고 출력 메소드
    int getMoney(String account ,int password){
        for( int i = 0 ; i < account2s.length  ; i++){
            // 입금 메소드에서와 같이 순회
            if(account2s[i] == null) continue;
            // 만약 i번째 인덱스가 null , 비어있으면 있을 때까지 찾기
            if(account2s[i].account.equals(account) && account2s[i].password == password) {
                // 계좌번호 , 비밀번호 일치하면
                return account2s[i].money;
                // i번째 계좌의 잔액 반환
            } // if e
        } // for
        return -1 ; // int 자료형이라 음수로 오류표현 , 계좌 못찾음.
    } // func e

    // 계좌이체 메소드 -- 으음...이체 하는 사람 , 받는 사람 구분 어케 나누지
    boolean accounttransfer( String sendaccount ){

    }

}
