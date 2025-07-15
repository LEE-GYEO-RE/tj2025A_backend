package project_0715.controller;

public class BookInfoController { // class start

    // 싱글톤
    private BookInfoController(){}
    private static final BookInfoController bookInfoController = new BookInfoController();
    public static BookInfoController getInstance(){
        return bookInfoController;
    }
} // class end
