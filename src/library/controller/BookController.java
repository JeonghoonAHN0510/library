package library.controller;

import library.model.dao.BookDao;
import library.model.dto.BookDto;

import java.util.ArrayList;

public class BookController {
    // 1) 싱글톤
    private BookController(){}
    private static final BookController instance = new BookController();
    public static BookController getInstance(){
        return instance;
    }
    // 2) dao 싱글톤 가져오기
    private BookDao bookDao = BookDao.getInstance();

    // 도서목록 조회 메소드
    // 메소드명 : bookPrint
    // 매개변수 : X
    // 반환값 : bookDB -> ArrayList<BookDto>
    public ArrayList<BookDto> bookPrint(){
        return bookDao.bookPrint();
    } // func end
} // class end
