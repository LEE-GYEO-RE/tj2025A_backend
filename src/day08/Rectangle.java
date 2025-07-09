package day08;

public class Rectangle {
    int width;
    int height;

    int getArea( ){
        int result = width * height ;
        return result;
    }
    Rectangle(int width ,int height ){
        this.width = width;
        this.height = height;
    }
}
