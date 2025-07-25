package project.view;

import project.controller.MemberController;

import java.util.Scanner;

public class LogOutView {

    // 싱글톤 생성
    private LogOutView(){}
    private static final LogOutView logoutView = new LogOutView();
    public static LogOutView getInstance(){
        return logoutView;
    }

    // 싱글톤 가져오기
    MemberController memberController = MemberController.getInstance();
    LogInView logInView = LogInView.getInstance();

    // Scanner 생성
    Scanner scan = new Scanner(System.in);

    // 첫 메인 화면
    public void index(){

        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("=====================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ) signup();
            else if (choose == 2)login();
            else System.out.println("[경고] 다시 선택해주십시오. ");
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
        if( result == -1 ) {
            System.out.println("[안내] 관리자 권한으로 회원가입 성공 ");
            login();
        }
        else if (result == 2 ) {
            System.out.println("[안내] 일반 회원으로 회원가입 성공");
            login();
        }
        else if (result == 3  ) {
            System.out.println("[안내] 이미 존재하는 아이디 입니다.");
        }

    } // func e


    // 로그인 화면
    public void  login(){
        System.out.println("--- 로그인 ---");
        System.out.println("아이디 : ");       String memberId = scan.next();
        System.out.println("비밀번호 : ");      String memberPwd = scan.next();
        int result1 = memberController.login( memberId ,memberPwd );
        if( result1 == -1 ){
            System.out.println("[안내] 관리자 로그인 성공 ");
            logInView.adminlogin();
        } else if (result1 == 2) {
            System.out.println("[안내]일반 회원 로그인 성공 ");
            logInView.userlogin();
        }else if (result1 == 3 ){
            System.out.println("[경고] 아이디와 비밀번호를 확인해주세요. ");
        }
    } // func e

} // class e