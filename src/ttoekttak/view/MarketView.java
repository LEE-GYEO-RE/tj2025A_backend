package ttoekttak.view;

import ttoekttak.controller.MarketController;
import ttoekttak.controller.QuiryController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MarketView {

    // 싱글톤 생성
    private MarketView(){}
    private static final MarketView instance = new MarketView();
    public static MarketView getInstance(){return instance;}

    // controller 싱글톤 가져오기
    public MarketController marketController = MarketController.getInstance();
    public QuiryController quiryController = QuiryController.getInstance();

    // Scanner 객체 생성
    Scanner scan = new Scanner(System.in);

    // 1. 메인 화면
    public void index(){
        for ( ; ; ){
            try {
                System.out.println("'=============================== 뚝딱마켓 ==============================");
                System.out.println("1.물품 등록 2.물품 조회 3.정보 수정 4.물품 삭제 5. 문의하기 6.상세 조회 7.랭킹 조회 8.검색 조회");
                System.out.println("선택 > ");
                System.out.println("======================================================================");
                int choose = scan.nextInt();
                if (choose == 1) {
                } else if (choose == 2) {
                } else if (choose == 3) {
                } else if (choose == 4) {
                } else if (choose == 5) {
                } else if (choose == 6) {
                } else if (choose == 7) {
                } else if (choose == 8) {
                } else {System.out.println("[안내] 존재하지 않는 기능입니다.");}
            } catch (InputMismatchException e) {
                System.out.println("[경고] 알맞은 숫자를 입력해주세요. ");
                scan = new Scanner(System.in); // 입력객체 초기화 , 잘못받은 데이터 지워버리기
            }catch (Exception e ){
                System.out.println("[오류] 프로그램을 닫아주세요. ");
            } // catch e
        } // for e
    } // func e

    // 2. 물품 등록 화면

    // 3. 물품 조회 화면

    // 4. 정보 수정 화면

    // 5. 물품 삭제 화면

    // 6. 물품 문의 화면

    // 7. 상세 조회 화면

    // 8. 랭킹 조회 화면

    // 9. 검색 조회 화면

} // class e
