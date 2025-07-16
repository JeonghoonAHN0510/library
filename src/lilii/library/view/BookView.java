package lilii.library.view;

import lilii.library.controller.BookController;
import lilii.library.model.dto.BookDto;

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
        System.out.println("-----------------------------------------");
        for ( int i = 0; i < bookDB.size(); i++){
            BookDto book = bookDB.get(i);
            System.out.printf("[%d] 도서명 : %s | 저자 : %s\n", book.getbCode(), book.getbName(), book.getbAuthor());
            System.out.println("-----------------------------------------");
        } // for end
    } // func end

    // 도서등록 메소드
    // 메소드명 : bookRegis()
    // 매개변수 : String bName, String bAuthor
    // 반환값 : true(성공) / false(실패) -> boolean
    public boolean bookRegis( String bName, String bAuthor ){
        boolean result = bookController.bookRegis( bName, bAuthor );
        return result;
    } // func end


    public ArrayList<String> getBook ( int bCode ){
        return bookController.getBook(bCode);
    }

} // class end
