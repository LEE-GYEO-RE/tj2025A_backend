package project_0715.controller;

public class BookListController {

    // 싱글톤
    private BookListController(){}
    private static final BookListController bookListController = new BookListController();
    public static BookListController getInstance(){
        return bookListController;
    }
}