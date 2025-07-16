package project.model.dao;

import project.model.dto.BookInfoDto;

import java.util.ArrayList;

public class BookInfoDao {

    // bookInfoDao 싱글톤 생성
    private BookInfoDao (){}
    private static final BookInfoDao bookInfoDao = new BookInfoDao();
    public static BookInfoDao getInstance(){ return bookInfoDao;}

    // bookinfoDB 객체 생성
    private ArrayList <BookInfoDto> bookinfoDB = new ArrayList<>();


}
