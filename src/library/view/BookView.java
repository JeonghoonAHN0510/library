package library.view;

import library.controller.BookController;
import library.model.dto.BookDto;

import java.util.ArrayList;

public class BookView {
    // 1) 싱글톤
    private BookView(){}
    private static final BookView instance = new BookView();
    public static BookView getInstance(){
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private BookController bookController = BookController.getInstance();

    // 도서목록 조회 메소드
    // 메소드명 : bookPrint
    // 매개변수 : X
    // 반환값 : X
    public void bookPrint(){
        ArrayList<BookDto> bookDB =  bookController.bookPrint();
        for ( int i = 0; i < bookDB.size(); i++){
            BookDto book = bookDB.get(i);
            System.out.printf("[%d] %s | %s", book.getbCode(), book.getbName(), book.getbAuthor());
        } // for end
    } // func end
} // class end
