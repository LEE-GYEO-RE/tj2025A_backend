package project_0715.controller;

public class MemberController { // class start

    private static int logInMno = 0 ;

    public static int getLogInMno() {
        return logInMno;
    }

    public static void setLogInMno(int logInMno) {
        MemberController.logInMno = logInMno;
    }

    private MemberController(){}
    private static final MemberController memberController = new MemberController();
    public static MemberController getInstance(){
        return memberController;
    }
} // class end