package library.model.dao;

import library.model.dto.BookDto;

import java.util.ArrayList;

public class BookDao {
    // 1) 싱글톤
    private BookDao(){}
    private static final BookDao instance = new BookDao();
    public static BookDao getInstance(){
        return instance;
    }
    // 2) 여러개 게시물(DTO)들을 저장할 리스트 선언
    private ArrayList<BookDto> bookDB = new ArrayList<>();

    // 도서목록 조회 메소드
    // 메소드명 : bookPrint
    // 매개변수 : X
    // 반환값 : bookDB -> ArrayList<BookDto>
    public ArrayList<BookDto> bookPrint (){
        return bookDB;
    } // func end

    // 도서등록 메소드
    // 메소드명 : bookRegis()
    // 매개변수 : String bName, String bAuthor
    // 반환값 : true(성공) / false(실패) -> boolean
    public boolean bookRegis( String bName, String bAuthor ){
        boolean result = false;         // 초기 반환값 설정

        // 도서번호 자동화
        int bCode = bookDB.size() + 1;
        // 도서 정보 넣을 객체 선언
        BookDto bookDto = new BookDto( bCode, bName, bAuthor );
        // 생성한 객체 ArrayList에 추가
        bookDB.add( bookDto );
        // 추가 성공하면 반환값 true
        result = true;

        return result;
    } // func end

} // class end
