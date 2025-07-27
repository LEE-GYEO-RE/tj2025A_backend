package ttoekttak.view;

import ttoekttak.controller.MarketController;
import ttoekttak.controller.QuiryController;
import ttoekttak.model.dto.MarketDto;
import ttoekttak.model.dto.ProductDetailDto;
import ttoekttak.model.dto.QuiryDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
                if (choose == 1) { addProduct();
                } else if (choose == 2) { productsPrint();
                } else if (choose == 3) { productsUpdate();
                } else if (choose == 4) { productsDelete();
                } else if (choose == 5) { prductsQuiry();
                } else if (choose == 6) { detailPrint();
                } else if (choose == 7) { rankPrint();
                } else if (choose == 8) { searchPrint();
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
    public void addProduct(){
        try {
            System.out.print("닉네임 : ");
            String sellId = scan.next();
            System.out.print("물품명 : ");
            String pname = scan.next();
            scan.nextLine(); // 개행 처리
            System.out.print("설명 : ");
            String ptext = scan.nextLine();
            System.out.print("가격 : ");
            int pprice = scan.nextInt();
            System.out.print("비밀번호 : ");
            String sellpwd = scan.next();

            boolean result = marketController.addProduct(pname, ptext, pprice, sellId, sellpwd);
            if (result) {
                System.out.println("[안내] 물품을 등록 완료하였습니다.");
            } else {
                System.out.println("[오류] 등록에 실패했습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[경고] 잘못된 입력입니다. 숫자 형식 확인해주세요.");
            scan = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("[오류] 예외 발생: " + e.getMessage());
        }
    } // func e

    // 3. 물품 조회 화면
    public void productsPrint(){
        ArrayList<MarketDto> list = marketController.productsPrint();

        if (list.isEmpty()) {
            System.out.println("[안내] 등록된 물품이 없습니다.");
        } else {
            for (MarketDto p : list) {
                System.out.printf("물품번호: %d | 물품명: %s | 가격: %d | 닉네임: %s | 등록일: %s | 판매여부: %s\n",
                        p.getPno(), p.getPname(), p.getPprice(), p.getSellId(), p.getAdd_date(), p.getPstate());
            }
        }
    } // func e

    // 4. 정보 수정 화면
    public void productsUpdate(){
        System.out.print("수정할 물품 번호: ");
        int pno = scan.nextInt();
        scan.nextLine(); // 줄바꿈 제거

        System.out.print("비밀번호: ");
        String sellpwd = scan.nextLine();

        System.out.print("새 물품명: ");
        String pname = scan.nextLine();

        System.out.print("새 물품 설명: ");
        String ptext = scan.nextLine();

        System.out.print("새 가격: ");
        int pprice = scan.nextInt();
        scan.nextLine();

        System.out.print("판매 상태 (예: 판매중 / 예약중 / 판매완료): ");
        String pstate = scan.nextLine();

        boolean result = marketController.productsUpdate(pno, sellpwd, pname, ptext, pprice, pstate);
        if (result) {
            System.out.println("[알림] 수정이 완료되었습니다.");
        } else {
            System.out.println("[경고] 물품 번호 또는 비밀번호가 일치하지 않습니다.");
        }
    } // func e

    // 5. 물품 삭제 화면
    public void productsDelete(){
        System.out.print("삭제할 물품 번호: ");
        int pno = scan.nextInt();
        scan.nextLine(); // 개행 제거

        System.out.print("비밀번호: ");
        String sellpwd = scan.nextLine();

        boolean result = marketController.productsDelete(pno, sellpwd);

        if (result) {
            System.out.println("[안내] 물품이 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("[경고] 물품 번호 또는 비밀번호가 일치하지 않습니다.");
        }
    } // func e

    // 6. 물품 문의 화면
    public void prductsQuiry(){
        System.out.print("문의할 물품 번호 입력: ");
        int pno = scan.nextInt();
        scan.nextLine(); // 개행 제거

        System.out.print("문의자 닉네임: ");
        String qid = scan.nextLine();

        System.out.print("문의할 내용: ");
        String qtext = scan.nextLine();

        System.out.print("비밀번호: ");
        String qpwd = scan.nextLine();

        QuiryDto dto = new QuiryDto(0, pno, qtext, qid, qpwd, null);

        boolean result = quiryController.productsQuiry(dto);

        if (result) {
            System.out.println("[안내] 문의글이 등록되었습니다.");
        } else {
            System.out.println("[경고] 문의글 등록에 실패했습니다.");
        }
    } // func e

    // 7. 상세 조회 화면
    public void detailPrint() {
        System.out.print("상세 조회할 물품번호를 입력하세요: ");
        int pno = scan.nextInt();
        scan.nextLine(); // 개행 제거

        ProductDetailDto detail = marketController.detailPrint(pno);

        if (detail != null) {
            MarketDto product = detail.getProductInfo();
            List<QuiryDto> qList = detail.getQuiryList();

            System.out.println("=== 물품 상세 정보 ===");
            System.out.println("번호: " + product.getPno());
            System.out.println("이름: " + product.getPname());
            System.out.println("설명: " + product.getPtext());
            System.out.println("가격: " + product.getPprice());
            System.out.println("판매자: " + product.getSellId());
            System.out.println("상태: " + product.getPstate());
            System.out.println("등록일: " + product.getAdd_date());

            System.out.println("\n=== 문의글 목록 ===");
            if (qList.isEmpty()) {
                System.out.println("문의글이 없습니다.");
            } else {
                for (QuiryDto q : qList) {
                    System.out.println("[문의자] " + q.getQid() + " | [내용] " + q.getQtext() + " | [날짜] " + q.getQ_date());
                }
            }
        } else {
            System.out.println("해당 물품이 존재하지 않습니다.");
        }
    }

    // 8. 랭킹 조회 화면
    public void rankPrint(){
        ArrayList<MarketDto> rankList = marketController.rankPrint();

        System.out.println("\n====== 판매자 등록 랭킹 10위 ======");
        int rank = 1;
        for (MarketDto dto : rankList) {
            System.out.printf("%2d위 | 닉네임: %-10s | 등록 수: %d개\n",
                    rank++, dto.getSellId(), dto.getPcount());
        }
    }

    // 9. 검색 조회 화면
    public void searchPrint() {
        System.out.print("🔍 검색할 키워드를 입력하세요: ");
        scan.nextLine();
        String keyword = scan.nextLine();

        ArrayList<ProductDetailDto> list = marketController.searchPrint(keyword);

        if (list.isEmpty()) {
            System.out.println(" 해당 키워드를 포함한 물품이 없습니다.");
            return;
        }

        System.out.println("\n 검색 결과:");

        for (ProductDetailDto detail : list) {
            MarketDto m = detail.getProductInfo();
            System.out.printf("물품명: %s | 가격: %d원 | 판매자: %s | 등록일: %s | 상태: %s\n",
                    m.getPname(), m.getPprice(), m.getSellId(), m.getAdd_date(), m.getPstate());

            if (!detail.getQuiryList().isEmpty()) {
                System.out.println(" 문의글:");
                for (QuiryDto q : detail.getQuiryList()) {
                    System.out.printf(" - %s (%s)\n", q.getQtext(), q.getQid());
                }
            } else {
                System.out.println(" 문의글: 없음");
            }
            System.out.println("----------------------------------------");
        }
    } // func e

} // class e
