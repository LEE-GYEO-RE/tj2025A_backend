package project.controller;

import project.model.dao.MemberDao;
import project.model.dto.MemberDto;

public class MemberController { // class start

    // 싱글톤 생성
    private MemberController(){}
    private static final MemberController memberController = new MemberController();
    public static MemberController getInstance(){
        return memberController;
    }

    // dao 싱글톤 가져오기
    MemberDao memberDao = MemberDao.getInstance();


    // dao에서 받은 반환값을 (추가된 회원) view로 전달해서 view에서 쓰려고 생성한 메소드
    public int getMember(String memberId , String memberPwd , String memberTel , String memberName){
        int result = memberDao.insertMember(memberId , memberPwd ,memberTel ,memberName);
        if(result == -1) return 3;
        if( memberId.equals("admin")){
            return -1;
        }
        return 2;
    }

    // 로그인 성공여부
    // view에서 입력받은 값들로 로그인 결과 판단 후 결과 코드 반환
    // 이걸 왜 controller에서 함? -->
    // 1. view가 dao에게 접근하지 않도록 하려고
    // 2. view에서 이 코드 치면 졸라 복잡해짐
    // 3. controller 가 dao에게 값 처리하라고 명령하고 결과만 view에게 알려주는 형식
    public int login(String memberId, String memberPwd) {
        MemberDto member = memberDao.findMember(memberId, memberPwd);
        // 입력한 아이디와 비밀번호가 일치하는 회원이 있는지 DAO에서 찾고, 일치하는 회원 정보(MemberDto)를 가져오라는 코드
        if (member == null) return 3; // 일치하는 게 없으면 null 로그인 실패
        if (member.getMemberId().equals("admin")) {
            memberDao.setLogInMno(-1);
            return -1; // -1값으로 관리자 회원 분류, 관리자 등록
        }
        return 2; // 일반회원 등록
    } // func e


    // 로그아웃 메소드 , 회원번호 초기화
    public void logOut(){
        memberDao.setLogInMno(0); // 로그아웃하면 회원번호 0으로 초기화
    }

} // class end