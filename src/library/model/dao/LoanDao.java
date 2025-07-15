package library.model.dao;

import library.model.dto.LoanDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LoanDao {
    // 1) 싱글톤
    private LoanDao(){}
    private static final LoanDao instance = new LoanDao();
    public static LoanDao getInstance(){
        return instance;
    }
    // 2) 여러개 게시물(DTO)들을 저장할 리스트 선언
    private ArrayList<LoanDto> loanDB = new ArrayList<>();


    // 도서 반납 메소드
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookReturn ( int bCode ){
        boolean result = false;         // 기본 반환값 설정
        // 도서코드를 매개변수로 받아서
        // 대출 목록에서 도서코드와 회원코드가 일치하는 대출을 찾아서
        for ( int i = 0; i < loanDB.size(); i++){
            if ( loanDB.get(i).getbCode() == bCode ){   // i번째 대출의 도서코드와 입력한 도서코드가 같다면
                // 해당하는 대출의 반납일에 현재 시간을 입력하고
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String now = formatter.format( LocalDateTime.now() ) ;
                loanDB.get(i).setReturnDate( now );
                // 반환값 true 설정
                result = true;
            } // if end
        } // for end
        return result;
    } // func end
} // class end

