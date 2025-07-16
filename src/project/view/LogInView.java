package project.view;

import project.controller.MemberController;

import java.util.Scanner;

public class LogInView { // class start

    private LogInView(){}
    private static final LogInView loginView = new LogInView();
    public static LogInView getInstance(){
        return loginView;
    }

    MemberController memberController = MemberController.getInstance();

    Scanner scan = new Scanner(System.in);

    // 첫 메인 화면
    public void index(){

        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("=====================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 )signup();
            else if (choose == 2)login();
        } // for e
    } // func e


    // 회원가입 화면
    public void signup(){
        System.out.println("--- 회원 가입 ---");
        System.out.println("아이디 : ");       String memberId = scan.next();
        System.out.println("비밀번호 : ");      String memberPwd = scan.next();
        System.out.println("이름 : ");         String memberName = scan.next();
        System.out.println("연락처 : ");       String memberTel = scan.next();
        int result = memberController.getMember(memberId ,memberPwd ,memberTel ,memberName);
        if(result == -1 ){
            System.out.println("회원가입 실패 : 아이디가 존재합니다.");
        } else if (memberId.equals("admin")) {
            System.out.println("관리자 권한으로 회원가입 성공" + result);
            login();
        }else {
            System.out.println("일반 회원으로 회원가입 성공" + result);
            login();
        }
    } // func e


    // 로그인 화면
    public void  login(){
        System.out.println("--- 로그인 ---");
        System.out.println("아이디 : ");       String memberId = scan.next();
        System.out.println("비밀번호 : ");      String memberPwd = scan.next();
        int result1 = memberController.login( memberId ,memberPwd );
        if( result1 == 1 ){
            System.out.println("[안내] 관리자 로그인 성공 ");
            adminlogin();
        } else if (result1 == 2) {
            System.out.println("[안내]일반 회원 로그인 성공 ");
            userlogin();

        }else if (result1 == 3 ){
            System.out.println("[경고] 아이디와 비밀번호를 확인해주세요. ");
        }
    } // func e

    // 로그인 후 메뉴 (일반 회원)
    public void userlogin(){
        for( ; ; ) {
            System.out.println("=========== 로그인 후 메뉴 (일반회원) ===========");
            System.out.println("  1.도서등록 | 2.도서대출 | 3.도서반납 | 4.내대출현황 | 5.도서목록 | 6.로그아웃");
            System.out.println("=============================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){
                System.out.println("[경고] 해당 메뉴는 관리자만 접근 가능합니다.");
                userlogin();
            }
            else if (choose == 2 ) loanBook();
            else if (choose == 3 ) returnBook();
            else if (choose == 4 ) bookState();
            else if (choose == 5 ){ }
            else if (choose == 6 ) logOut();
        } // for e
    } // func e

    // 로그인 후 메뉴 (관리자 모드)
    public void adminlogin(){

        for( ; ; ) {
            System.out.println("=========== 로그인 후 메뉴 (관리자) ===========");
            System.out.println("  1.도서등록 | 2.도서대출 | 3.도서반납 | 4.내대출현황 | 5.도서목록 | 6.로그아웃");
            System.out.println("=============================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ) addBook();
            else if (choose == 2 ) loanBook();
            else if (choose == 3 ) returnBook();
            else if (choose == 4 ) bookState();
            else if (choose == 5 ){}
            else if (choose == 6 ) logOut();
        } // for e
    } // func e




    // 도서 등록
    public void addBook(){

        System.out.println("--- 도서 등록 ---");
        System.out.println("도서명 : ");
        System.out.println("저자 : ");
        System.out.println("[안내] 도서 등록이 완료되었습니다.");
    } // func e

    // 도서 대출
    public void loanBook(){

        System.out.println("--- 도서 대출 ---");
        System.out.println("대출할 도서 번호 :");
        System.out.println("[안내] 도서 대출이 완료되었습니다.");
    } // func e

    // 도서 반남
    public void returnBook(){

        System.out.println("--- 도서 반납 ---");
        System.out.println("반납할 도서 번호 : ");
        System.out.println("[안내] 도서 반납이 완료되었습니다.");
    } // func e

    // 내 대출 현황
    public void bookState(){

        System.out.println("--- 나의 대출 현황 ---");
        System.out.println("[1] 책이름| 저자 | 대출일: ");

    } // func e

    // 도서 목록
    public void bookList(){
    } // func e

    // 로그아웃
    public void logOut(){
        memberController.logOut();
        System.out.println("[안내] 로그아웃 되었습니다.");
        LogOutView.getInstance().index();
    } // func e

} // class end