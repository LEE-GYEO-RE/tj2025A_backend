package project_0715.controller;

import project_0715.model.dao.BookInfoDao;

public class BookInfoController { // class start

    // 싱글톤
    private BookInfoController(){}
    private static final BookInfoController bookInfoController = new BookInfoController();
    public static BookInfoController getInstance(){
        return bookInfoController;
    }

    // dao 싱글톤 가져오기
    private BookInfoDao bookInfoDao = BookInfoDao.getInstance();


} // class end
