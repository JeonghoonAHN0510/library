package library.model.dao;

import library.controller.MemberController;
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

    // 도서대출 메소드
    // 메소드명 : bookLoan()
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookLoan( int bCode ){       // 매개변수로 도서코드를 입력받아
        boolean result = false;         // 반환 초기값
        // 대출코드 자동화
        int lCode = loanDB.size() + 1;
        // 회원코드 가져오기
        int mCode = MemberController.returnMCode();
        // 대출일 만들기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String loanDate = formatter.format( LocalDateTime.now() ) ;
        // 반납일 null값으로 초기화
        String returnDate = null;
        // LoanDto 객체를 만들어서
        LoanDto loanDto = new LoanDto( lCode, bCode, mCode, loanDate, returnDate );

        // 대출이 가능하다면 -> 대출테이블에 입력받은 도서코드와 일치하는 대출이 있다면,
        // 반납일이 null이 아니면 대출 가능, 반납일이 null이라면 대출 불가
        for ( int i = 0; i < loanDB.size(); i++){   // 대출DB를 순회하면서
            LoanDto loan = loanDB.get(i);           // i번째 대출을 loan에 저장
            if ( loan.getmCode() == bCode && loan.getReturnDate() == null ){    // 일치하는 대출을 찾았고, 반납일이 null이 아니라면(반납했다면)
                loanDB.add( loanDto );          // 대출DB에 저장
                result = true;                  // 대출 성공했다면 true
                break;
            } // if end
            if ( loan.getmCode() != bCode ){        // 일치하는 대출이 없다면 -> 대출한 내역이 없는 책이라면
                loanDB.add( loanDto );          // 대출DB에 저장
                result = true;                  // 대출 성공했다면 true
                break;
            } // if end
        } // for end
        return result;
    } // func end

} // class end

