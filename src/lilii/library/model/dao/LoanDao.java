package lilii.library.model.dao;

import lilii.library.controller.MemberController;
import lilii.library.model.dto.BookDto;
import lilii.library.model.dto.LoanDto;

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
    private static ArrayList<LoanDto> loanDB = new ArrayList<>();


    // 도서 반납 메소드
    // bCode를 받아서 대출 목록을 순회하고, 대출 목록에 입력받은 bCode와 일치하는 대출이 있고 반납일이 null이라면,
    // 반납일을 현재 시간으로 설정하고, true를 반환한다.
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookReturn ( int bCode ){
        boolean result = false;         // 기본 반환값 설정
        // 도서코드를 매개변수로 받아서
        // 대출 목록에서 도서코드와 회원코드가 일치하는 대출을 찾아서
        for ( int i = 0; i < loanDB.size(); i++){
            // i번째 대출의 도서코드와 입력한 도서코드가 같고, 반납일 값이 null이라면
            if ( loanDB.get(i).getbCode() == bCode && loanDB.get(i).getReturnDate() == null ){
                // 해당하는 대출의 반납일에 현재 시간을 입력하고
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String now = formatter.format( LocalDateTime.now() ) ;
                loanDB.get(i).setReturnDate( now );
                return true;        // 반환값 true 설정
            } // if end
        } // for end
        return result;
    } // func end


    // 도서대출 메소드
    // 메소드명 : bookLoan()
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookLoan(int bCode) {
        // 대출 코드 자동 부여
        int lCode = loanDB.size() + 1;
        // 회원 코드를 가져오고
        int mCode = MemberController.returnMCode();
        // 대출일을 현재 날짜/시간으로
        String loanDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 반납일을 null로 설정
        String returnDate = null;
        // 대출 객체를 생성
        LoanDto loanDto = new LoanDto(lCode, bCode, mCode, loanDate, returnDate);

        // 책 존재 여부 확인
        boolean bookExists = false;
        ArrayList<BookDto> bookDB = BookDao.getInstance().returnBookDB();
        for (BookDto book : bookDB) {
            if (book.getbCode() == bCode) { // 책이 bookDB에 있다면
                bookExists = true;          // 존재 true로 바꾸고
                break;                      // 반복문 종료
            } // if end
        } // for end
        if (!bookExists) {                  // 도서 없으면 실패
            return false;
        } // if end

        // 현재 대출 상태 확인 (반납 안 했으면 대출 불가)
        for (LoanDto loan : loanDB) {       // loanDB를 순회하고
            if (loan.getbCode() == bCode && (loan.getReturnDate() == null )) {  // 대출 기록은 있는데, 반납을 안 했다면
                return false;               // 대출 불가
            } // if end
        } // for end

        // 지금까지 return 안됐으면 대출 가능
        loanDB.add(loanDto);    // 리스트에 생성한 객체 추가하고
        return true;            // 종료
    } // func end
} // class end

