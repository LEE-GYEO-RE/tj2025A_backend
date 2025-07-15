package project_0715.view;

import java.util.Scanner;

public class LogInView { // class start

    private LogInView(){}
    private static final LogInView loginView = new LogInView();
    public static LogInView getInstance(){
        return loginView;
    }

    Scanner scan = new Scanner(System.in);

    // 첫 메인 화면
    public void index(){

        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("=====================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){

            }else if (choose == 2){

            }
        } // for e
    } // func e


    // 회원가입 화면
    public void signup(){
        System.out.println("--- 회원 가입 ---");
        System.out.println("아이디 : ");       String memberId = scan.next();
        System.out.println("비밀번호 : ");      String memberPwd = scan.next();
        System.out.println("이름 : ");
        System.out.println("연락처 : ");
        System.out.println("[안내] 관리자 계정이 등록되었습니다.");

    }


    // 회원가입 화면
    public void  login(){

    }














} // class end