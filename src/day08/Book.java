package day08;

public class Book {
    String title;
    String author;
    int price;


    Book( String title ,String author , int price){
        this.title = title;     // 매개변수를 입력받아 멤버변수를 초기화
        this.author = author;
        this.price = price;
        System.out.println();
    }
}
