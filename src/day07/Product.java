package day07;

public class Product {
    String name;
    int stock = 10; // 초기 재고 10 , main 함수에서 지정해도 되긴함
    boolean sell (int num ){ // sell 메소드 생성
        if( stock >= num){  // 재고 있으면
            stock -=num;
            return true;
        }else {             // 재고 없으면
            System.out.println("재고 부족");
            return false;
        }
    }
}
