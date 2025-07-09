package day08;

public class MenuItem {
    String name;
    int price;
    boolean isSignature;

    MenuItem(String name , int price ,boolean isSignature ){
        this.name = name;
        this.price = price;
        this.isSignature = isSignature;
        if( isSignature ){
            System.out.println("[대표메뉴]" + name + ":" + price );
        }else {
            System.out.println("[메뉴]" + name + ":" + price);
        }
    }
}
