package project_0715.controller;

public class MemberController { // class start

    private static int logInMno = 0 ;
    // getter , setter  필요함 아직 안만듬

    private MemberController(){}
    private static final MemberController memberController = new MemberController();
    public static MemberController getInstance(){
        return memberController;
    }
} // class end