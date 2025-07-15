package library.controller;

import library.model.dao.BookDao;

public class BookController {
    // 1) 싱글톤
    private BookController(){}
    private static final BookController instance = new BookController();
    public static BookController getInstance(){
        return instance;
    }
    // 2) dao 싱글톤 가져오기
    private BookDao bookDao = BookDao.getInstance();
}
