package 종합.과제;

import java.util.Scanner;

public class 종합과제1 { // class s
    public static void main(String[] args) { // main s
        // 메인 화면 구현
        // 입력 받기
        // 메모리 설계
        // 코드 구현

        // String 변수 3개 , int 변수 3개
        String phone1 = null;
        String phone2 = null;
        String phone3 = null;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (; ; ) {

            // 메인 화면 구현
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.println("선택 > ");

            // 1. 대기 등록인지 , 2. 대기 현황 누르는 건지 확인 받기
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

            // 1 눌렀을 때 , 메모리 구성들
            if (choose == 1) {
                System.out.println("전화 번호 : ");
                String phone = scan.next();
                System.out.println("인원수 : ");
                int count = scan.nextInt();

                if (phone1 == null) {
                    phone1 = phone;
                    count1 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else if (phone2 == null) {
                    phone2 = phone;
                    count2 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else if (phone3 == null) {
                    phone3 = phone;
                    count3 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }
            } // if e

            // 2 눌렀을 때 , 메모리 구성들
            else if (choose == 2) {
                System.out.println("============= 대기 현황 =============");
                if (phone1 != null) {
                    System.out.println("1. 연락처 : " + phone1 + " - 인원 : " + count1);
                    System.out.println("------------------------------------");
                }
                if (phone2 != null) {
                    System.out.println("1. 연락처 : " + phone2 + " - 인원 : " + count2);
                    System.out.println("------------------------------------");
                }
                if (phone3 != null) {
                    System.out.println("1. 연락처 : " + phone3 + " - 인원 : " + count3);
                    System.out.println("------------------------------------");
                }
            }
        } // for e
    } // main e
} // class e

