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
} // class end
