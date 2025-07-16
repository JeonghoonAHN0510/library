package lilii.library.controller;

import lilii.library.model.dao.BookDao;
import lilii.library.model.dto.BookDto;

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

    // 도서등록 메소드
    // 메소드명 : bookRegis()
    // 매개변수 : String bName, String bAuthor
    // 반환값 : true(성공) / false(실패) -> boolean
    public boolean bookRegis( String bName, String bAuthor ){
        // view로부터 입력값을 받아 dao에게 전달 후, dao로부터 반환값을 받아 view에게 전달
        boolean result = bookDao.bookRegis( bName, bAuthor );
        return result;
    } // func end

} // class end
