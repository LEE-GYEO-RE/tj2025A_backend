package 심화.심화과제1;

public class BankController1 {



    // 클래스 3개 생성
    // 객체 100개 저장할 수 있는 배열 생성
    // 매개변수로 입력받을 값 지정 -> 생성자 생성 시 같이 할 예정
    // 메소드 생성
    // 1. 계좌등록 메소드
    // 2. 입금 메소드
        // 1) 입금 성공 시 출력 기능
        // 2) 계좌번호 다를 때 , 입금 실패 출력 기능
    // 3. 출금 메소드
        // 1) 출금 성공 시 출력 가능
        // 2) 출금 잔액 부족 시 , 출금 실패 출력 기능
    // 4. 잔고 출력 메소드
    // 메소드 호출
    // 출력

    // 풀면서 질문 :
    // 1. 생성자의 역할 정확히 알아야 함, 객체 생성해서 값을 넣어 저장해야하는데 , 어떤 속성값의 객체인지 지정해줘야함
    // 2. return -1 음수로 오류 표현? 이게 뭔지 모르겠음


    Account1[] accounts = new Account1[100];                   // 객체 100개 저장할 수 있는 accounts

    // 계좌 등록 메소드
    boolean getAccount(String account, int password) {
        // boolean 타입의 getAccount 메소드 생성 , String  account , int password를 매개변수로 지정
        Account1 account1 = new Account1(account , password);  // account1 객체 생성 -> Account1 생성자에서 값 가져옴
        for (int i = 0; i <= accounts.length - 1; i++) {    // accounts 배열의 i번째까지 순회
            if (accounts[i] == null) {                     // accounts[i] 번째가 null 이면
                accounts[i] = account1;                    // accounts[i] 번째에 account1 대입
                return true;                                // true 반환 , 반복문 종료
            } // if end
        } // for end
        return false;                                       // null이 존재 하지 않으면 false
    } // func end


    // 입금 메소드
    boolean getDeposit( String account , int password , int deposit ){
        for( int i = 0; i<= accounts.length -1 ; i++){
            if(accounts[i] != null // null 이지 않으면서
                    && accounts[i].account.equals(account) && accounts[i].password == password){
                // accounts[i] 번째 인덱스의 계좌번호랑 , 입력받은 계좌번호 같으면서
                // accounts[i] 번째 인덱스의 비밀번호랑 , 입력받은 비밀번호도 같으면
                accounts[i].money += deposit;
                // accounts[i] 번째 인덱스의 잔액에 입금액 누적 더하기
                return true;    //  반복문 종료
            } // if end
        } // for end
        return false;   // 하나라도 틀리면 경고
    } // func end

    // 출금 메소드
    boolean getWithdrawal( String account , int password ,int withdrawal ){
        for( int i = 0 ; i <=accounts.length -1 ; i++){
            if( accounts[i] == null ) continue;     // null 이면 계속 찾음
            if( accounts[i].account.equals(account) && accounts[i].password == password ){  // 계좌랑 비번 같으면
                if( accounts[i].money >= withdrawal ) { // 돈이 출금액보다 적거나 같으면
                    accounts[i].money -= withdrawal;    // 돈에 출금액 뺀 금액 대입
                    return true;                        // true 반환 메소드 종료
                }else { return false; }
            } // if end
        } // for end
        return false;                                   // 계좌 못찾음
    } // func end

    // 잔고 출력 메소드
    int getMoney( String account , int password ){
        for( int i = 0 ; i <=accounts.length -1 ; i++){
            if( accounts[i] == null ) continue;
            if(accounts[i].account.equals(account) && accounts[i].password == password){
                return accounts[i].money;
            } // if end
        } // for end
        return -1; // 음수로 오류 표현? 일단 ㅇㅋ
    } // func end

} // class end